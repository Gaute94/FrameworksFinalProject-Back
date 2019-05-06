package me.gaute.redditcloneback.service;

import me.gaute.redditcloneback.model.Post;
import me.gaute.redditcloneback.model.Subreddit;
import me.gaute.redditcloneback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeleteService {

    @Autowired
    PostService postService;

    @Autowired
    SubredditService subredditService;

    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    public String deletePost(long id) {
        Optional<Post> post = postService.getOne(id);
        if (post.isPresent()) {
            postService.deleteById(post.get().getId());
            return "Deleted";
        } else {
            return "No such post";
        }
    }

    private void deleteAllPostsByOwner(User owner) {
        List<Post> posts = postService.getPostsByOwner(owner);
        for (Post post : posts) {
            deletePost(post.getId());
        }
    }

    private void deleteAllPostsBySubreddit(Subreddit subreddit) {
        List<Post> posts = postService.getAllSubredditPosts(subreddit);
        for (Post post : posts) {
            postService.deleteById(post.getId());
        }
    }

    public String deleteSubreddit(String subreddit) {
        Optional<Subreddit> subreddit1 = subredditService.getById(subreddit);
        if (subreddit1.isPresent()) {
            deleteAllPostsBySubreddit(subreddit1.get());
            subredditService.deleteById(subreddit);
            return "Deleted";
        } else {
            return "No subreddit with that title";
        }
    }

    public String deleteUser(String username) {
        Optional<User> user = userService.getByUsername(username);
        if (user.isPresent()) {
            user.get().setEmail("DELETED");
            user.get().getFollowing().clear();
            user.get().setRole("ROLE_DELETED");
            user.get().getSubreddits().clear();
            user.get().setUsername(randomUsername());
            user.get().setPassword("{noop}" + randomPassword());
            deleteAllPostsByOwner(user.get());
            //deleteImagesByOwner(user.get());
            userService.save(user.get(), true);
            return "Deleted";
        } else {
            return "No user with that username";
        }
    }

    private String randomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVQXYZabcdefghijklmnopqrstuvqxyz1234567890!%&";
        char[] chars = characters.toCharArray();
        StringBuilder password = new StringBuilder();
        int num;
        for (int i = 0; i < 15; i++) {
            num = (int) (Math.random() * characters.length());
            password.append(chars[num]);
        }
        return password.toString();
    }

    private String randomUsername() {
        StringBuilder username = new StringBuilder();
        username.append("deleted");
        int num;
        do {
            num = (int) (Math.random() * 100000);
            username.append(num);
        } while (userService.getByUsername(username.toString()).isPresent());
        return username.toString();
    }
}

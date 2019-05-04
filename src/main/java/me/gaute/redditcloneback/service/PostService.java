package me.gaute.redditcloneback.service;


import me.gaute.redditcloneback.model.Post;
import me.gaute.redditcloneback.model.Subreddit;
import me.gaute.redditcloneback.model.User;
import me.gaute.redditcloneback.repository.PostRepository;
import me.gaute.redditcloneback.repository.SubredditRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostService postService;

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){ return postRepository.findAll(); }

    public Post save(Post post){
        return postRepository.save(post);
    }

    public long countPosts(){
        return postRepository.count();
    }

    public void deleteById(long id){
        postRepository.deleteById(id);
    }

    public Optional<Post> getOne(long id){
        Optional<Post> post = postRepository.findById(id);
        return post;}

    //public Optional<User> getByEmail(String email){ return userRepository.findUserByEmail(email);}

    public List<Post> getAllSubredditPosts(Subreddit subreddit){
        return postRepository.findBySubreddit(subreddit);
    }

    public List<Post> getPostsByOwner(User owner){
        return postRepository.findByOwner(owner);
    }

}

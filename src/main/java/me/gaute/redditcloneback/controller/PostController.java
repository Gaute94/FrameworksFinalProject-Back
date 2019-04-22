package me.gaute.redditcloneback.controller;


import me.gaute.redditcloneback.model.Post;
import me.gaute.redditcloneback.model.Subreddit;
import me.gaute.redditcloneback.service.PostService;
import me.gaute.redditcloneback.service.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/posts/id/{id}")
    public Optional<Post> getPostById(@PathVariable long id){
        return postService.getOne(id);
    }
    /*
    @GetMapping("/subreddits/id/{id}")
    public Optional<User> getUserById(@PathVariable long id){
        return userService.getOne(id);
    }
    */

    @DeleteMapping("/posts/{id}")
    public void deletePostById(@PathVariable long id){
        postService.deleteById(id);
    }

    @PostMapping("/posts")
    public Post savePost( @RequestBody  Post newPost){
        return postService.save(newPost);
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable long id,  @RequestBody  Post newPost){
        newPost.setId(id);
        return postService.save(newPost);
    }
}

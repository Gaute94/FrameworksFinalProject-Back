package me.gaute.redditcloneback.controller;

import me.gaute.redditcloneback.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class DeleteController {

    @Autowired
    DeleteService deleteService;

    @DeleteMapping("/delete/user/{username}")
    public void deleteUserByUsername(@PathVariable String username) {
        deleteService.deleteUser(username);
    }

    @DeleteMapping("/delete/subreddit/{title}")
    public void deleteSubredditByTitle(@PathVariable String title) {
        deleteService.deleteSubreddit(title);
    }

    @DeleteMapping("/delete/post/{id}")
    public void deletePostById(@PathVariable long id) {
        deleteService.deletePost(id);
    }
}

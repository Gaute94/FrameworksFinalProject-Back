package me.gaute.redditcloneback.controller;

import me.gaute.redditcloneback.model.Subreddit;
import me.gaute.redditcloneback.service.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class SubredditController {

    @Autowired
    SubredditService subredditService;

    @GetMapping("/subreddits")
    public List<Subreddit> getAllSubreddits() {
        return subredditService.getAllSubreddits();
    }

    @GetMapping("/subreddits/{title}")
    public Optional<Subreddit> getSubredditByTitle(@PathVariable String title) {
        return subredditService.getOne(title);
    }

    @GetMapping("/subreddits/title/{title}")
    public Optional<Subreddit> getSubredditById(@PathVariable String title) {
        return subredditService.getById(title);
    }


    @DeleteMapping("/subreddits/{title}")
    public void deleteSubredditByTitle(@PathVariable String title) {
        subredditService.deleteById(title);
    }

    @PostMapping("/subreddits")
    public Subreddit saveSubreddit(@RequestBody Subreddit newSubreddit) {
        return subredditService.save(newSubreddit);
    }

    @PutMapping("/subreddits/{title}")
    public Subreddit updateSubreddit(@PathVariable String title, @RequestBody Subreddit newSubreddit) {
        newSubreddit.setTitle(title);
        return subredditService.save(newSubreddit);
    }
}

package me.gaute.redditcloneback.service;

import me.gaute.redditcloneback.model.Subreddit;
import me.gaute.redditcloneback.repository.SubredditRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubredditService {

    @Autowired
    SubredditService subredditService;

    @Autowired
    private SubredditRepository subredditRepository;

    public List<Subreddit> getAllSubreddits(){ return subredditRepository.findAll(); }

    public Subreddit save(Subreddit subreddit){
        return subredditRepository.save(subreddit);
    }

    public long countSubreddits(){
        return subredditRepository.count();
    }

    public void deleteById(String title){
        subredditRepository.deleteById(title);
    }

    public Optional<Subreddit> getOne(String title){
        Optional<Subreddit> subreddit = subredditRepository.findById(title);
        return subreddit;}

    public Optional<Subreddit> getById(String title){ return subredditRepository.findSubredditByTitle(title);}

}

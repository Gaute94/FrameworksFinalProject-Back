package me.gaute.redditcloneback.repository;

import me.gaute.redditcloneback.model.Post;
import me.gaute.redditcloneback.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
        List<Post> findBySubreddit(Subreddit subreddit);
}
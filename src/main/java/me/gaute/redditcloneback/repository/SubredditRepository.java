package me.gaute.redditcloneback.repository;
import me.gaute.redditcloneback.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubredditRepository extends JpaRepository<Subreddit, String> {
    Optional<Subreddit> findSubredditByTitle(String title);

}
package me.gaute.redditcloneback.repository;

import me.gaute.redditcloneback.model.Post;
import me.gaute.redditcloneback.model.Subreddit;
import me.gaute.redditcloneback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
        List<Post> findAllByOrderByDateDesc();
        List<Post> findBySubredditOrderByDateDesc(Subreddit subreddit);
        List<Post> findByOwnerOrderByDateDesc(User user);
        List<Post> findAllBySubredditInOrOwnerInOrderByDateDesc(List<Subreddit> subreddit, List<User> user);
}
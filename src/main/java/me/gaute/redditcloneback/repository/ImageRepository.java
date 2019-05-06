package me.gaute.redditcloneback.repository;

import me.gaute.redditcloneback.model.Image;
import me.gaute.redditcloneback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByOwner(User user);
}
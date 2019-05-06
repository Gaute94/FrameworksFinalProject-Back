package me.gaute.redditcloneback.controller;

import me.gaute.redditcloneback.model.Image;
import me.gaute.redditcloneback.service.ImageService;
import me.gaute.redditcloneback.service.PostService;
import me.gaute.redditcloneback.service.SubredditService;
import me.gaute.redditcloneback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class ImageController {

    @Autowired
    PostService postService;

    @Autowired
    SubredditService subredditService;

    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @GetMapping("/images")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/images/id/{id}")
    public Optional<Image> getImageById(@PathVariable long id) {
        return imageService.getById(id);
    }


    @DeleteMapping("/images/{id}")
    public void deleteImageById(@PathVariable long id) {
        imageService.deleteById(id);
    }

    @PostMapping("/images")
    public Image saveImage(@RequestBody Image newImage) {
        return imageService.save(newImage);
    }

    @PutMapping("/images/{id}")
    public Image updateImage(@PathVariable long id, @RequestBody Image newImage) {
        newImage.setId(id);
        return imageService.save(newImage);
    }
}

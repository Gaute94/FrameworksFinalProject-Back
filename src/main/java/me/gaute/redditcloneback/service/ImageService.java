package me.gaute.redditcloneback.service;

import me.gaute.redditcloneback.model.Image;
import me.gaute.redditcloneback.model.User;
import me.gaute.redditcloneback.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    PostService postService;

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image save(Image image) {
        return imageRepository.save(image);
    }

    public void deleteById(long id) {
        imageRepository.deleteById(id);
    }

    public Optional<Image> getById(long id) {
        Optional<Image> image = imageRepository.findById(id);
        return image;
    }

    public List<Image> getImagesByOwner(User owner) {
        return imageRepository.findByOwner(owner);
    }


}

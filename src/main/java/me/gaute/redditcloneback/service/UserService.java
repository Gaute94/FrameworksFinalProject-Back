package me.gaute.redditcloneback.service;

import me.gaute.redditcloneback.model.User;
import me.gaute.redditcloneback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){ return userRepository.findAll(); }

    public User save(User user){
        return userRepository.save(user);
    }

    public long countUsers(){
        return userRepository.count();
    }

    public void deleteById(long id){
        userRepository.deleteById(id);
    }

    public Optional<User> getOne(long id){
        Optional<User> user = userRepository.findById(id);
        return user;}

    public Optional<User> getByEmail(String email){ return userRepository.findUserByEmail(email);}

    public Optional<User> getByUsername(String username) {return userRepository.findUserByUsername(username);}

}

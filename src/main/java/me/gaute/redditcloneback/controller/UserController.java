package me.gaute.redditcloneback.controller;

import me.gaute.redditcloneback.model.SaveUserResponse;
import me.gaute.redditcloneback.model.User;
import me.gaute.redditcloneback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(){
        return "This is a rest controller  ";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/email/{email}")
    public Optional<User> getUserById(@PathVariable String email){
        return userService.getByEmail(email);
    }

    @GetMapping("/users/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {return userService.getByUsername(username);}

    @GetMapping("/users/id/{id}")
    public Optional<User> getUserById(@PathVariable long id){
        return userService.getOne(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable long id){
        userService.deleteById(id);
    }

    @PostMapping("/users")
    public SaveUserResponse saveUser(@RequestBody  User newUser){
        return userService.save(newUser, false);
    }

    @PutMapping("/users/{id}")
    public SaveUserResponse updateUser(@PathVariable long id,  @RequestBody  User newUser){
        newUser.setId(id);
        return userService.save(newUser, true);
    }

    @GetMapping("/users/nonDeleted")
    public List<User> getNonDeleted(){
        System.out.println("USERS: " + userService.getNonDeleted());
        return userService.getNonDeleted();
    }
}

package com.stacksmplify.restservices.springbootbuildingblocks.Controllers;

import com.stacksmplify.restservices.springbootbuildingblocks.Entities.User;
import com.stacksmplify.restservices.springbootbuildingblocks.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserServices userService;

    @GetMapping("/users")
    public List<User> getAllUsers()
    {

        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") long id)
    {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable("id") long id,@RequestBody User user)
    {
        return userService.updateUserById(user,id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") long id)
    {
        userService.deleteUserById(id);
    }

    @GetMapping("/users/byusername/{username}")
    public User findUserByUserName(@PathVariable("username") String userName)
    {
        return userService.findByUserName(userName);
    }
}

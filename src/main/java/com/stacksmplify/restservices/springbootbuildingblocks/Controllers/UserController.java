package com.stacksmplify.restservices.springbootbuildingblocks.Controllers;

import com.stacksmplify.restservices.springbootbuildingblocks.Entities.User;
import com.stacksmplify.restservices.springbootbuildingblocks.Services.UserServices;
import com.stacksmplify.restservices.springbootbuildingblocks.exceptions.UserNameAlreadyPresent;
import com.stacksmplify.restservices.springbootbuildingblocks.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserServices userService;

    @GetMapping
    public List<User> getAllUsers()
    {

        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user)
    {
        try{
            return userService.createUser(user);

        }catch(UserNameAlreadyPresent ex)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") long id)
    {
        try {
            return userService.getUserById(id);
        }catch (UserNotFoundException ex)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") long id,@RequestBody User user)
    {
        try{
            return userService.updateUserById(user,id);

        }catch (UserNotFoundException ex)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());

        }catch(UserNameAlreadyPresent ex2)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex2.getMessage());

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") long id)
    {
        userService.deleteUserById(id);
    }

    @GetMapping("/byusername/{username}")
    public User findUserByUserName(@PathVariable("username") String userName) throws UserNotFoundException
    {
       User user=userService.findByUserName(userName);
       if(user==null)
       {
           throw new UserNotFoundException("User not found");
       }
       return user;
    }
}

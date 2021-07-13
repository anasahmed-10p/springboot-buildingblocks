package com.stacksmplify.restservices.springbootbuildingblocks.Services;

import com.stacksmplify.restservices.springbootbuildingblocks.Entities.User;
import com.stacksmplify.restservices.springbootbuildingblocks.repositeries.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepositery userRepositery;

    public List<User> getAllUsers()
    {
        return userRepositery.findAll();
    }

    public User createUser(User user)
    {
        return userRepositery.save(user);
    }

    public Optional<User> getUserById(Long id)
    {

        Optional<User> user=userRepositery.findById(id);
        return user;
    }

    public User updateUserById(User user,long id)
    {
        user.setId(id);
        return userRepositery.save(user);
    }

    public void deleteUserById(Long id)
    {
        if(userRepositery.findById(id).isPresent())
        {
            userRepositery.deleteById(id);
        }
    }

    public User findByUserName(String userName)
    {
        return userRepositery.findByUserName(userName);
    }

}

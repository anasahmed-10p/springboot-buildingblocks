package com.stacksmplify.restservices.springbootbuildingblocks.Services;

import com.stacksmplify.restservices.springbootbuildingblocks.Entities.User;
import com.stacksmplify.restservices.springbootbuildingblocks.exceptions.UserNameAlreadyPresent;
import com.stacksmplify.restservices.springbootbuildingblocks.exceptions.UserNotFoundException;
import com.stacksmplify.restservices.springbootbuildingblocks.repositeries.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public User createUser(User user) throws UserNameAlreadyPresent
    {
        User user1=userRepositery.findByUserName(user.getUserName());

        if(user1!=null)
        {

            throw new UserNameAlreadyPresent("Username already present");
        }
        return userRepositery.save(user);
    }

    public Optional<User> getUserById(Long id) throws UserNotFoundException
    {

        Optional<User> user=userRepositery.findById(id);

        if(!user.isPresent())
        {
            throw new UserNotFoundException("User is not present");
        }

        return user;
    }

    public User updateUserById(User user,long id) throws Exception
    {
        Optional<User> optionalUser=userRepositery.findById(id);
        if(!optionalUser.isPresent())
        {
            throw new UserNotFoundException("User not Present");
        }
        else{
            List<User> user2=userRepositery.findAll();
            for(int i=0;i<user2.size();i++)
            {
                if(user2.get(i).getUserName().equals(user.getUserName()) && user2.get(i).getId()!=user.getId())
                {
                    throw new UserNameAlreadyPresent("User name already present");
                }
            }

        }

        user.setId(id);
        return userRepositery.save(user);
    }

    public void deleteUserById(Long id)
    {
        Optional<User> optionalUser=userRepositery.findById(id);
        if(!optionalUser.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User is not Present");
        }
        userRepositery.deleteById(id);
    }

    public User findByUserName(String userName)
    {
        return userRepositery.findByUserName(userName);
    }

}

package com.stacksmplify.restservices.springbootbuildingblocks.Controllers;

import com.stacksmplify.restservices.springbootbuildingblocks.Entities.User;
import com.stacksmplify.restservices.springbootbuildingblocks.Services.UserServices;
import com.stacksmplify.restservices.springbootbuildingblocks.dtos.UserMmDto;
import com.stacksmplify.restservices.springbootbuildingblocks.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/modelmapper/users")
public class UserModelMapperController {

    @Autowired
    private UserServices userService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{id}")
    public UserMmDto getUserById(@PathVariable("id") long id)throws UserNotFoundException
    {
        Optional<User> userOptional=userService.getUserById(id);

        if(!userOptional.isPresent())
        {
            throw new UserNotFoundException("User is not present");
        }

        UserMmDto userMmDto=modelMapper.map(userOptional.get(),UserMmDto.class);

        return userMmDto;

    }
}

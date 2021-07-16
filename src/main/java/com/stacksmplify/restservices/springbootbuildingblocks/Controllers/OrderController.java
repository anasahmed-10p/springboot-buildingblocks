package com.stacksmplify.restservices.springbootbuildingblocks.Controllers;

import com.stacksmplify.restservices.springbootbuildingblocks.Entities.Order;
import com.stacksmplify.restservices.springbootbuildingblocks.Entities.User;
import com.stacksmplify.restservices.springbootbuildingblocks.exceptions.OrderNotPresent;
import com.stacksmplify.restservices.springbootbuildingblocks.exceptions.UserNotFoundException;
import com.stacksmplify.restservices.springbootbuildingblocks.repositeries.OrderRepositery;
import com.stacksmplify.restservices.springbootbuildingblocks.repositeries.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/users")
public class OrderController {

    @Autowired
    private UserRepositery userRepositery;

    @Autowired
    private OrderRepositery orderRepositery;

    @GetMapping("/{userid}/order")
    public List<Order> getOrderByUserId(@PathVariable Long  id) throws UserNotFoundException
    {
        Optional<User> userOptional=userRepositery.findById(id);

        if(!userOptional.isPresent())
        {
            throw new UserNotFoundException("User not found");
        }

        return userOptional.get().getOrders();
    }

    @PostMapping("/{userid}/order")
    public Order createOrder(@PathVariable Long id,@RequestBody Order order)throws UserNotFoundException
    {
        Optional<User> userOptional=userRepositery.findById(id);

        if(!userOptional.isPresent())
        {
            throw new UserNotFoundException("User not found");
        }

        User user=userOptional.get();

        order.setUser(user);

        return orderRepositery.save(order);

    }

    @GetMapping("/order/{orderId}")
    public Order getOrderById(@PathVariable long orderId) throws OrderNotPresent
    {
        Optional<Order> orderOptional=orderRepositery.findById(orderId);

        if(!orderOptional.isPresent())
        {
            throw new OrderNotPresent("Order is not present");
        }

        return orderOptional.get();
    }
}

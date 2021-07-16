package com.stacksmplify.restservices.springbootbuildingblocks.repositeries;

import com.stacksmplify.restservices.springbootbuildingblocks.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositery extends JpaRepository<Order, Long> {
}

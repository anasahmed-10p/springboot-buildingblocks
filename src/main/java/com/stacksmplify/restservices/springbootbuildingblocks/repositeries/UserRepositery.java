package com.stacksmplify.restservices.springbootbuildingblocks.repositeries;

import com.stacksmplify.restservices.springbootbuildingblocks.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositery extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}

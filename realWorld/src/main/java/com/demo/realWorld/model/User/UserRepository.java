package com.demo.realWorld.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> getAllFollowersByUserName(String userName);

    User getUserByUserName(String userName);
}

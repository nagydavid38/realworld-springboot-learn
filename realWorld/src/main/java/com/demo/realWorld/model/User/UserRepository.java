package com.demo.realWorld.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    User findByAccountName(String accountName);



}

package com.powertrader.repository;

import com.powertrader.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dudus on 2015-11-28.
 */
public interface UserRepository extends CrudRepository<User,Long>{

    User findByEmail(String email);
    User findByUsername(String username);
    List<User> findAll();
}

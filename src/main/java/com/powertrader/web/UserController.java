package com.powertrader.web;

import com.powertrader.exception.PowerTraderException;
import com.powertrader.model.User;
import com.powertrader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dudus on 2015-11-28.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userRepository.findOne(id);

        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> offerList() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) == null) {
            user.setId(null);
            user.setActive(false);
            userRepository.save(user);

            return user;
        } else {
            throw new PowerTraderException("Email already exist");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        user.setActive(false);
        userRepository.save(user);

        return "User has been deleted";
    }

    @RequestMapping(value = "/find/{email:.+}", method = RequestMethod.GET)
    public String findByEmail(@PathVariable String email) {
        if (userRepository.findByEmail(email) == null) {
            return "false";
        }
        return "true";
    }

}

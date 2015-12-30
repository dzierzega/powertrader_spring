package com.powertrader.service;

import com.powertrader.model.User;
import com.powertrader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Piotr Dzierżęga on 2015-12-28.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);

        if (user == null) {
            return null;
        }

        String password = user.getPassword();

        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("USER");

        if (username.equals("admin")) {
            auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN");
        }


        return new org.springframework.security.core.userdetails.User(username, password, auth);
    }
}

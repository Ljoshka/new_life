package com.app.security;

import com.app.dao.UsersDAO;
import com.app.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersDAO usersDAO;

    @Override
    public UserDetails loadUserByUsername(String username) {
        List<Users> users = usersDAO.getUserByEmail(username);

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + "not found");
        }

        return new CustomUserDetails(users.get(0));
    }
}

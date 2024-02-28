package com.app.services;

import com.app.dao.UsersDAO;
import com.app.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UsersDAO usersDAO;

    public void storeNewUser(Users users) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoderPassword = encoder.encode(users.getPassword());
        users.setPassword(encoderPassword);

        usersDAO.storeNewUser(users);
    }

    public List<Users> getAllUsers() {
        return usersDAO.getAllUsers();
    }
}

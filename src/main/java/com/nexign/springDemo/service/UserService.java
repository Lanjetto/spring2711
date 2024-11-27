package com.nexign.springDemo.service;

import com.nexign.springDemo.dao.UserDAO;
import com.nexign.springDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private UserDAO userDAO;
    private User user;

    @Autowired
    public UserService(UserDAO userDAO, User user) {
        this.userDAO = userDAO;
        this.user = user;
    }

    public void addUser() {
        System.out.println(userDAO.addUser(user));
    }
}

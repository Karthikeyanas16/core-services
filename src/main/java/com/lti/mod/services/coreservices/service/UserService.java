package com.lti.mod.services.coreservices.service;

import com.lti.mod.services.coreservices.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User findByUsername(String username);

    List<User> findAllUsers();

    User updateUser(User user);
}

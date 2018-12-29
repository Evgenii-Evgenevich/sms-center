package com.smscenter.service;

import com.smscenter.model.User;
import com.smscenter.util.Page;

/**
 * interface User Service
 *
 * @author Evgenii Evgenevich
 */
public interface UserService {
    User userByLogin(String login);

    User addUser(User user);

    User updateUser(User user);

    User getUser(String login, String password);

    Page<User> users(int page, int count);
}

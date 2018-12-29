package com.smscenter.service;

import com.smscenter.model.User;
import com.smscenter.dao.UserRepository;
import com.smscenter.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * implements User Service
 *
 * @author Evgenii Evgenevich
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User userByLogin(String login) {
        Optional<User> user = this.userRepository.findByLogin(login);
        if (!user.isPresent()) {
            throw new RuntimeException();
        }
        return user.get();
    }

    @Override
    @Transactional
    public User addUser(User user) {
        if (this.userRepository.existsByLogin(user.getLogin())) {
            throw new RuntimeException();
        }
        return this.userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getUser(String login, String password) {
        Optional<User> user = this.userRepository.findByLoginAndPassword(login, password);
        if (!user.isPresent()) {
            throw new RuntimeException();
        }
        return user.get();
    }

    @Override
    public Page<User> users(int page, int count) {
        return Page.of(this.userRepository.findAll(PageRequest.of(page, count, Sort.by("id"))));
    }
}

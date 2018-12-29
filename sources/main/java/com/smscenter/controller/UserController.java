package com.smscenter.controller;

import com.smscenter.dto.UserDto;
import com.smscenter.service.UserService;
import com.smscenter.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * User Controller
 *
 * @author Evgenii Evgenevich
 */
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{page}/{count}", method = GET)
    public Page<UserDto> page(@PathVariable("page") int page, @PathVariable("count") int count) {
        return this.userService.users(page, count).map(UserDto::of);
    }
}

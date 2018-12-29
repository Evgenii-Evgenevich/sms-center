package com.smscenter.dto;

import com.smscenter.model.Rate;
import com.smscenter.model.User;

/**
 * User Data Transfer Object
 * Пользователи
 *
 * @author Evgenii Evgenevich
 */
public class UserDto {
    private long id;

    private String login;

    private String username;

    private RateDto rate;

    private UserDto() {
    }

    public long getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getUsername() {
        return this.username;
    }

    public RateDto getRate() {
        return this.rate;
    }

    public static UserDto of(User user) {
        if (user == null) return null;
        UserDto dto = new UserDto();
        dto.id = user.getId();
        dto.login = user.getLogin();
        dto.username = user.getUsername();
        dto.rate = RateDto.of(user.getRate());
        return dto;
    }
}

package com.smscenter.model;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

/**
 * User Data
 * Пользователи
 *
 * @author Evgenii Evgenevich
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login", length = 60, nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "rate_id")
    private Long rateId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "rate_id", insertable = false, updatable = false)
    private Rate rate;

    public boolean passwordEquals(String password) {
        return Objects.equals(this.password, password);
    }

    public Long getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Long getRateId() {
        return this.rateId;
    }

    public Rate getRate() {
        return this.rate;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }
}

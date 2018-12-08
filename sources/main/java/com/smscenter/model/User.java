package com.smscenter.model;

import javax.persistence.*;

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
}

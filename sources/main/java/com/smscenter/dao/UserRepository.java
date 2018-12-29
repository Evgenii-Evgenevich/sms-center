package com.smscenter.dao;

import com.smscenter.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * User Data Access Object
 *
 * @author Evgenii Evgenevich
 */
public interface UserRepository extends Repository<User, Long>, JpaSpecificationExecutor<User> {
    long count();

    Page<User> findAll(Pageable pageable);

    Optional<User> findByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);

    boolean existsByLogin(String login);

    User save(User user);
}

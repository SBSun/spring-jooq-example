package com.example.jooq.user.repository;

import com.example.jooq.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);
    boolean existsByAccountId(String accountId);
}

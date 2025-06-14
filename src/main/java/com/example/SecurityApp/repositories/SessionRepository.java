package com.example.SecurityApp.repositories;

import com.example.SecurityApp.entities.Session;
import com.example.SecurityApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
    Optional<Session> findByRefreshToken(String refreshToken);

    List<Session> findByUser(User user);
}

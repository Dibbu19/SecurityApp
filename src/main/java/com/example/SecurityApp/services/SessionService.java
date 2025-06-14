package com.example.SecurityApp.services;

import com.example.SecurityApp.entities.Session;
import com.example.SecurityApp.entities.User;
import com.example.SecurityApp.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    private final int SESSION_LIMIT = 2;

    public void generateSession(User user, String refreshToken) {
        List<Session> sessionList = sessionRepository.findByUser(user);
        if(sessionList.size() == SESSION_LIMIT) {
            sessionList.sort(Comparator.comparing(Session::getLastUsedAt));
            Session olderSession = sessionList.getFirst();
            sessionRepository.delete(olderSession);
        }
        Session newSession = Session.builder()
                .user(user)
                .refreshToken(refreshToken)
                .build();
        sessionRepository.save(newSession);
    }

    public void validateSession(String refreshToken) {
        Session session = sessionRepository.findByRefreshToken(refreshToken).orElseThrow(
                () -> new SessionAuthenticationException("Session not found for refreshToken: "+ refreshToken)
        );
        session.setLastUsedAt(LocalDateTime.now());
        sessionRepository.save(session);
    }
}

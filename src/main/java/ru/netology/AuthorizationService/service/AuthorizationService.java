package ru.netology.AuthorizationService.service;

import org.springframework.stereotype.Service;
import ru.netology.AuthorizationService.repository.Authorities;
import ru.netology.AuthorizationService.exeption.InvalidCredentials;
import ru.netology.AuthorizationService.exeption.UnauthorizedUser;
import ru.netology.AuthorizationService.repository.UserRepository;

import java.util.List;
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService (UserRepository repository) {
        this.userRepository=repository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
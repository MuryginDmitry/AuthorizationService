package ru.netology.AuthorizationService.repository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private Map<String, String> userPasswordMap = new ConcurrentHashMap<>();
    private Map<String, List<Authorities>> userAuthoritiesMap = new ConcurrentHashMap<>();
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (!userPasswordMap.containsKey(user)) {
            return Arrays.asList();
        }

        String storedPassword = userPasswordMap.get(user);
        if (!password.equals(storedPassword)) {
            return Arrays.asList();
        }

        return userAuthoritiesMap.get(user);
    }
}




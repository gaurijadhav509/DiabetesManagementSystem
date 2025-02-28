package com.diabetesmanagementsystem.Diabetes.Management.System.services;
import com.diabetesmanagementsystem.Diabetes.Management.System.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final Map<Long, User> userStore = new ConcurrentHashMap<>();
    private final AtomicLong userIdGenerator = new AtomicLong(1);

    public Long createUser(User user) {
        if (user.getPassword() == null) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        Long userId = userIdGenerator.getAndIncrement();
        user.setUserId(userId);  // Set generated ID
        userStore.put(userId, user);
        return userId;
    }

    public User getUser(Long userId) {
        return userStore.get(userId);
    }
}



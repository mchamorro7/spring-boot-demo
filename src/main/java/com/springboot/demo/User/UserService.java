package com.springboot.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    void addNewUser(User user) {
        addNewUser(null, user);
    }

    public void addNewUser(UUID userId, User user) {
        UUID newUserId = Optional.ofNullable(userId)
                .orElse(UUID.randomUUID());

        userDao.insertUser(newUserId, user);
    }


    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }

    public int updateUser(UUID userId, User user) { return userDao.updateUser(userId, user); }

    public void deleteUser(UUID userId) {
        userDao.deleteUser(userId);
    }
}

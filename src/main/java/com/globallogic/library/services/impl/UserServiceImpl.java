package com.globallogic.library.services.impl;

import com.globallogic.library.entities.User;
import com.globallogic.library.repositories.UserRepository;
import com.globallogic.library.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        try {
            logger.info("[USERSVC] saving user details {} ", user.getEmailId());
            return this.userRepository.save(user);
        } catch (Exception e) {
            logger.error("[USERSVC] error while saving user details {}", user.getEmailId(), e);
            throw e;
        }
    }

    @Override
    public boolean authenticateUserCredentials(String userName, String password) {
        try {
            List<User> userList = this.userRepository.findByEmailIdAndPassword(userName, password);
            logger.info("[USERSVC] checking user credentials ");
            return !CollectionUtils.isEmpty(userList);
        } catch (Exception e) {
            logger.error("[USERSVC] error while authenticating user {}", userName, e);
        }
        return false;
    }
}

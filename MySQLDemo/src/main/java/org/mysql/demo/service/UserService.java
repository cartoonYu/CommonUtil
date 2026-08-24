package org.mysql.demo.service;

import org.mysql.demo.entity.User;
import org.mysql.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cartoon.yu
 * @since 2026/08/22 21:57
 */
@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findById(Long id) {
        return userMapper.findById(id);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public void create(User user) {
        userMapper.insert(user);
    }
}
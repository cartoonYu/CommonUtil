package org.mysql.demo;

import jakarta.annotation.Resource;
import org.mysql.demo.entity.User;
import org.mysql.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author cartoon.yu
 * @since 2026/08/22 21:58
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User user) {
        userService.create(user);
        return user;
    }
}

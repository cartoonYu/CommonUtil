package org.mysql.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mysql.demo.entity.User;

import java.util.List;

/**
 * @author cartoon.yu
 * @since 2026/08/22 21:57
 */
@Mapper
public interface UserMapper {

    User findById(Long id);

    List<User> findAll();

    int insert(User user);
}

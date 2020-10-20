package org.jpa.demo.dao;


import org.jpa.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cartoon
 * @description
 * @date 2020/4/25 10:38
 */
public interface UserDao extends JpaRepository<User, Long> {

}

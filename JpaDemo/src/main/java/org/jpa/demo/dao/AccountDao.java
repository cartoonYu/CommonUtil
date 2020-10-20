package org.jpa.demo.dao;


import org.jpa.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cartoon
 * @description
 * @date 2020/4/25 10:39
 */
public interface AccountDao extends JpaRepository<Account, Long> {

    @Transactional
    @Modifying
    @Query(value = "update account set password = ?1 where account = ?2", nativeQuery = true)
    int update(String password, String account);
}

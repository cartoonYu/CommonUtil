package org.mybatis.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.demo.bean.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author cartoon
 * @description
 */
@Mapper
@Repository
public interface UserDao {

    int insert(UserInfo userInfo);

    UserInfo selectByPrimaryKey(Long userId);

    int updateByPrimaryKey(UserInfo record);
}

package org.shardingsephere.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.shardingsephere.demo.bean.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author cartoon
 * @description
 * @date 2019/12/23 1:49 PM
 */
@Mapper
@Repository
public interface UserDao {

    int insert(UserInfo userInfo);

    UserInfo selectByPrimaryKey(Long userId);

    int updateByPrimaryKey(UserInfo record);
}

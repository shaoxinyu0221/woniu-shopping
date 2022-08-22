package com.authservice.dao.mysql;

import com.authservice.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/16 10:48
 */
@Mapper
public interface UserMysqlDao {

    @Select("select * from tb_user where username=#{username}")
    User getUserByUserName(String username);
}

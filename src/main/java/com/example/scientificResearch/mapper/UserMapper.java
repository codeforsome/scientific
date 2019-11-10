package com.example.scientificResearch.mapper;

import com.example.scientificResearch.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@Mapper
public interface UserMapper {
    @Insert("insert into user(username,nickname,education,sex,head_icon,college)" +
            "value(#{username},#{nickname},#{education},#{sex},#{headIcon},#{college})")
    Boolean insert(User user);

    @Update("update user set nickname=#{nickname},education=#{education}," +
            "sex=#{sex},head_icon=#{headIcon},college=#{college} " +
            "where username=#{username}")
    void updateUserInfoByUsername(User user);

    @Update("update user set hot=#{hot} " +
            "where id=#{userId}")
    void updateHotByUserId( @Param("userId")BigInteger userId, @Param("hot")int hot);

    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);

    @Select("select hot from user where id=#{id} limit 1")
    int getHotByUserId(BigInteger id);

    @Select("select * from user where id=#{id}")
    User getUserById(BigInteger id);

    @Select("select * from user order by hot desc limit 5 ")
    List<User> getHotUser();
}

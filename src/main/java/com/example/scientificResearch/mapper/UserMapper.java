package com.example.scientificResearch.mapper;

import com.example.scientificResearch.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Insert("insert into user(username,nickname,education)" + "value(#{username},#{nickname},#{education})")
    Boolean insert(User user);

    @Update("update user set nickname=#{nickname},education=#{education}," +
            "sex=#{sex} " +
            "where username=#{username}")
    void updateUserInfoByUsername(User user);
}

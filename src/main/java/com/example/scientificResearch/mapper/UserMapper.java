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

    @Update("update user set status=#{status} " +
            "where id=#{id}")
    Boolean updateStatusById( User user);

    @Update("update user set type=#{type} " +
            "where id=#{id}")
    Boolean updateTypeById( User user);

    @Select("select * from user where  type=2 ")
    List<User> getAllUserTypeProfessor();


    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);

    @Select("select * from user where  nickname like #{username}")
    List<User> searchUser(String username);

    @Select("select * from user where type!=3  order by create_date desc limit #{offset},#{rows}")
    List<User> getAllUser(@Param("offset")int offset, @Param("rows")int rows);

    @Select("select hot from user where id=#{id} limit 1")
    int getHotByUserId(BigInteger id);

    @Select("select * from user where id=#{id}")
    User getUserById(BigInteger id);


    @Select("select count(id) from user ")
    int getAllUserCount();

    @Select("select * from user order by hot desc limit 5 ")
    List<User> getHotUser();

    @Delete("delete  from user where username=#{username}")
    Boolean deleteUserByUsername(String username);
}

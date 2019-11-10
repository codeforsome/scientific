package com.example.scientificResearch.mapper;

import com.example.scientificResearch.model.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface LoginMapper {

    @Select("select * from login where  username=#{username} limit 1")
    Login existUsername(String username);

    @Select("select * from login where  username=#{username} and password=#{password} limit 1")
    Login existLoginInfo(@Param("username")String username, @Param("password")String password);

    @Insert("insert into login(username,password)" + "value(#{username},#{password})")
    Boolean insert(@Param("username")String username, @Param("password")String password);


}

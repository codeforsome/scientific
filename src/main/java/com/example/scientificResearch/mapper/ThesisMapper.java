package com.example.scientificResearch.mapper;

import com.example.scientificResearch.model.Thesis;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Component
public interface ThesisMapper {
    @Insert("insert into thesis(title,abstracts,author_id,keyword,file_path,discipline_specialty)" +
            "value(#{title},#{abstracts},#{authorId},#{keyword},#{filePath},#{disciplineSpecialty})")
    Boolean insert(Thesis thesis);

    @Select("select * from thesis where author_id=#{authorId} order by date desc")
    List<Thesis> getThesisByUserId(BigInteger authorId);

    @Select("select * from thesis where id=#{id} ")
    Thesis getThesisByThesisId(BigInteger id);

    @Select("select * from thesis")
    List<Thesis> getAll();

    @Select("select count(id) from thesis")
    int getThesisCount();

    @Select("select * from thesis order by read_num desc limit #{offset},#{rows}")
    List<Thesis> getThesisHot(@Param("offset")int offset, @Param("rows")int rows);

    @Select("select * from thesis order by date desc limit #{offset},#{rows}")
    List<Thesis> getAllThesis(@Param("offset")int offset, @Param("rows")int rows);

    @Update("update thesis set title=#{title},abstracts=#{abstracts}," +
            "keyword=#{keyword},file_path=#{filePath},discipline_specialty=#{disciplineSpecialty} " +
            "where id=#{id}")
    Boolean updateThesisByThesisId(Thesis thesis);

    @Update("update thesis set read_num=#{readNum} " +
            "where id=#{id}")
    Boolean updateReadNumById(@Param("id") BigInteger id, @Param("readNum")int readNum);


    @Select("select * from thesis where title like #{title}")
    List<Thesis> searchThesis(String title);

    @Delete("delete  from thesis where author_id=#{authorId}")
    Boolean deleteThesisByAuthorId(BigInteger authorId);

    @Delete("delete  from thesis where id=#{id}")
    Boolean deleteThesisById(BigInteger id);
}

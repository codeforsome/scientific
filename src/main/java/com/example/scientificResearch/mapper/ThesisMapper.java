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

    @Select("select * from thesis where author_id=#{authorId}")
    List<Thesis> getThesisByUserId(BigInteger authorId);

    @Select("select * from thesis where id=#{id}")
    Thesis getThesisByThesisId(BigInteger id);

    @Select("select * from thesis")
    List<Thesis> getAll();

    @Select("select count(id) from thesis")
    int getThesisCount();

    @Select("select * from thesis order by read_num desc limit #{offset},#{rows}")
    List<Thesis> getThesisHot(@Param("offset")int offset, @Param("rows")int rows);

    @Update("update thesis set title=#{title},abstracts=#{abstracts}," +
            "keyword=#{keyword},file_path=#{filePath},discipline_specialty=#{disciplineSpecialty} " +
            "where id=#{id}")
    Boolean updateThesisByThesisId(Thesis thesis);

    @Update("update thesis set read_num=#{readNum} " +
            "where id=#{id}")
    Boolean updateReadNumById(@Param("id") BigInteger id, @Param("readNum")int readNum);
}

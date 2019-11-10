package com.example.scientificResearch.mapper;

import com.example.scientificResearch.model.Item;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@Mapper
public interface ItemMapper {

    @Insert("insert into items(title,content,disciplineSpecialty,author_id)" +
            "value(#{title},#{content},#{disciplineSpecialty},#{authorId})")
    Boolean insert(Item item);

    @Update("update items set title=#{title},content=#{content}," +
            "disciplineSpecialty=#{disciplineSpecialty} " +
            "where id=#{id}")
    Boolean updateThesisByThesisId(Item item);

    @Select("select * from items order by create_date desc limit #{offset},#{rows}")
    List<Item> getItemNew(@Param("offset")int offset, @Param("rows")int rows);

    @Select("select * from items where author_id=#{id}")
    List<Item> getItemByAuthorId(@Param("id") BigInteger id);

    @Select("select * from items where id=#{id}")
   Item getItemById(@Param("id") BigInteger id);
}

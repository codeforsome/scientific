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

    @Select("select * from items where author_id=#{id}  order by create_date desc")
    List<Item> getItemByAuthorId(@Param("id") BigInteger id);


    @Select("select * from items where id=#{id}")
   Item getItemById(@Param("id") BigInteger id);

    @Select("select count(id) from items")
    int getItemsCount();

    @Select("select * from items where title like #{title}")
    List<Item> searchItem(String title);

    @Delete("delete  from items where author_id=#{authorId}")
    Boolean deleteItemByAuthorId(BigInteger authorId);

    @Delete("delete  from items where id=#{id}")
    Boolean deleteItemById(BigInteger id);

}

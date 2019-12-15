package com.example.scientificResearch.mapper;

import com.example.scientificResearch.model.Apply;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@Mapper
public interface ApplyMapper {
    @Insert("insert into apply(apply_id,item_id,file_path) " +
            "value(#{applyId},#{itemId},#{filePath})")
    Boolean insert(Apply apply);

    @Select("select * from apply where item_id=#{id} ")
    List<Apply> getItemApplyByItemId(@Param("id") BigInteger id);

    @Select("select * from apply where apply_id=#{id} ")
    List<Apply> getItemApplyByUserId(@Param("id") BigInteger id);


    @Select("select * from apply where item_id=#{id}  and professor_id=#{professorId}")
    List<Apply> getItemApplyByItemIdAndProfeesId(@Param("id") BigInteger id,@Param("professorId") BigInteger professorId);

    @Select("select * from apply where item_id=#{id}  and apply_id=#{applyId}")
   Apply getItemApply(@Param("id") BigInteger id,@Param("applyId") BigInteger applyId);

    @Update("update apply set apply=#{apply},apply_date=#{applyDate}  " +
            "where id=#{id}")
    Boolean updateApplyStatus(Apply apply);

    @Update("update apply set professor_id=#{professorId},professor_date=#{professorDate} " +
            "where id=#{id}")
    Boolean updateProfessor(Apply apply);

    @Update("update apply set check_status=#{checkStatus},check_date=#{checkDate} where id=#{id}")
    Boolean updateProfessorCheck(Apply apply);

    @Select("select * from apply where professor_id=#{id}  order by date desc")
    List<Apply> getItemByProfessId(@Param("id") BigInteger id);

    @Delete("delete  from apply where apply_id=#{applyId}")
    Boolean deleteApplyByApplyId(BigInteger applyId);
}

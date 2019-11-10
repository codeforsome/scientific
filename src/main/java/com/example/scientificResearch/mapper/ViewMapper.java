package com.example.scientificResearch.mapper;

import com.example.scientificResearch.model.View;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Mapper
@Component
public interface ViewMapper {
    @Insert("insert into view(read_user_id,thesis_id)" +
            "value(#{readUserId},#{thesisId})")
    Boolean insert(@Param("thesisId") BigInteger thesisId, @Param("readUserId")BigInteger readUserId);

    @Select("select * from view where read_user_id=#{readUserId} and thesis_id=#{thesisId} limit 1")
    View getViewByThesisIdAndReadUserId(@Param("thesisId") BigInteger thesisId, @Param("readUserId")BigInteger readUserId);

}

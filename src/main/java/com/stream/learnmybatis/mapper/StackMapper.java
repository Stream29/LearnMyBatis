package com.stream.learnmybatis.mapper;

import com.stream.learnmybatis.pojo.StringPiece;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StackMapper
{
    @Select("select * from string_stack")
    List<StringPiece> selectAll();

    @Delete("delete from string_stack where id = #{id}")
    int delete(int id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into string_stack (value) values (#{value})")
    int insert(StringPiece instance);

    @Update("update string_stack set value = #{value} where id = #{id}")
    int update(StringPiece instance);

    @Select("select * from string_stack where id = #{id}")
    StringPiece selectById(int id);

    List<StringPiece> dynamicSelect(@Param("value") String value);

    int deleteByIds(List<Integer> ids);
}

package com.lmy.demospringboot.dao;

import com.lmy.demospringboot.po.Grade;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GradeDao {
    @Results(id = "resultgrade",value = {
            @Result(property = "gradeid",column = "gradeid"),
            @Result(property = "gradename",column = "gradename")
    })
    @Select("select * from grade")
    public List<Grade> findall();

   @ResultMap("resultgrade")
    @Select("select * from grade where gradeid=#{gradeid}")
    public Grade findById(int gradeid);

    @Insert("insert into grade(gradename) values(#{gradename})")
    public int insert(Grade grade);

    @Update("update grade set gradename=#{gradename} where gradeid=#{gradeid}")
    public int update(Grade grade);

    @Delete("delete from grade where gradeid=#{gradeid}")
    public int delete(int gradeid);
}

package com.example.web1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LikeMapper {
    @Select("SELECT count(*) FROM likelist WHERE jlid=#{jlid}")
    Integer getLikeNumByJlid(@Param("jlid") Integer jlid);

}

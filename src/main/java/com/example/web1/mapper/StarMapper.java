package com.example.web1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface StarMapper {
    @Select("SELECT count(*) FROM star WHERE jlid=#{jlid}")
    Integer getStarNumByJlid(@Param("jlid") Integer jlid);
}

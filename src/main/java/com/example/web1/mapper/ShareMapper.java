package com.example.web1.mapper;

import com.example.web1.pojo.Share;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShareMapper {
    @Select("SELECT * FROM share WHERE jlid=#{jlid}")
    Share getShareByJlid(@Param("jlid") int jlid);
}

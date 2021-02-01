package com.example.web1.mapper;

import com.example.web1.pojo.Video;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoMapper {
    @Select("SELECT * FROM video WHERE jlid=#{jlid}")
    Video getVideoByjlid(@Param("jlid") int jlid);

    
}

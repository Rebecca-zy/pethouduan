package com.example.web1.mapper;

import com.example.web1.pojo.Video;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoMapper {
    @Select("SELECT * FROM video WHERE jlid=#{jlid}")
    Video getVideoByjlid(@Param("jlid") int jlid);

    @Select("SELECT jlid FROM video  WHERE sc=0 AND  jlid>= ((SELECT MAX(jlid) FROM video )-(SELECT MIN(jlid) FROM video )) * RAND() + (SELECT MIN(jlid) FROM video )  LIMIT 1")
    int getRandomvdid();
    
}

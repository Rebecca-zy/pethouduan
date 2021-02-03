package com.example.web1.mapper;

import java.util.List;

import com.example.web1.pojo.Photo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PhotoMapper {
    @Select("SELECT * FROM photo WHERE jlid=#{jlid}")
    List<Photo> getPhotoByjlid(@Param("jlid") int jlid);

    @Select("SELECT * FROM photo WHERE yhid=#{yhid}")
    List<Photo> getPhotoByYhid(@Param("yhid") Integer yhid);

    @Select("SELECT DISTINCT photo.jlid FROM photo ")
    int[] getjlidByPhoto(@Param("yhid") Integer yhid);

    @Select("SELECT jlid FROM photo  WHERE sc=0 AND  jlid>= ((SELECT MAX(jlid) FROM photo )-(SELECT MIN(jlid) FROM photo )) * RAND() + (SELECT MIN(jlid) FROM photo )  LIMIT 3")
    int[] getRandomptid();
}
package com.example.web1.mapper;

import java.util.List;

import com.example.web1.pojo.Photo;
import com.example.web1.pojo.userPhotolist;

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

    @Select("select photo.zp FROM photo JOIN `share` on photo.jlid=`share`.jlid join pet on `share`.cwid=pet.cwid WHERE pet.cwid=#{cwid}")
    String[] getPetPicList(@Param("cwid") Integer cwid);

    @Select("select DISTINCT `share`.fbsj FROM photo JOIN `share` on photo.jlid=`share`.jlid  WHERE `share`.sc=0 AND `share`.yhid=#{yhid} ORDER BY `share`.fbsj DESC")
    String[] getPhotoFbsj(@Param("yhid") Integer yhid);

    @Select("select photo.zp FROM photo JOIN `share` on photo.jlid=`share`.jlid  WHERE `share`.sc=0 AND `share`.yhid=#{yhid} AND `share`.fbsj=#{fbsj}")
    String[] getUserPhotolistByYhid(@Param("yhid") Integer yhid,@Param("fbsj") String fbsj);
}
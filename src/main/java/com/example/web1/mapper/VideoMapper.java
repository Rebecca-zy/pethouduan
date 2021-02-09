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

    @Select("select DISTINCT `share`.fbsj FROM video JOIN `share` on video.jlid=`share`.jlid  WHERE `share`.sc=0 AND `share`.yhid=#{yhid} ORDER BY `share`.fbsj DESC")
    String[] getVideoFbsj(@Param("yhid") Integer yhid);

    @Select("select DISTINCT `share`.fbsj FROM video JOIN `share` on video.jlid=`share`.jlid  WHERE `share`.sc=0 AND `share`.yhid=#{yhid} AND `share`.cwid=#{cwid} ORDER BY `share`.fbsj DESC")
    String[] getVideocwidFbsj(@Param("yhid") Integer yhid,@Param("cwid") Integer cwid);
    
    @Select("select video.sp FROM video JOIN `share` on video.jlid=`share`.jlid  WHERE `share`.sc=0 AND `share`.yhid=#{yhid} AND `share`.fbsj=#{fbsj}")
    String[] getUserVideolistByYhid(@Param("yhid") Integer yhid,@Param("fbsj") String fbsj);
}

package com.example.web1.mapper;

import com.example.web1.pojo.Follow;
import com.example.web1.pojo.Star;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StarMapper {
    @Select("SELECT count(*) FROM star WHERE jlid=#{jlid} AND sc=0")
    Integer getStarNumByJlid(@Param("jlid") Integer jlid);

    @Select("SELECT `star`.jlid FROM star JOIN `share` ON `star`.jlid=`share`.jlid WHERE star.yhid=#{yhid}  AND star.sc=0 ORDER BY `share`.fbsj DESC" )
    Integer[] getStarJlid(@Param("yhid") Integer yhid);

    @Select("SELECT `star`.jlid FROM star JOIN `share` ON `star`.jlid=`share`.jlid WHERE star.yhid=#{yhid} AND `share`.fqh=#{fqh} AND star.sc=0 ORDER BY `share`.fbsj DESC" )
    Integer[] getStarfqhJlid(@Param("yhid") Integer yhid,@Param("fqh") Integer fqh);


    @Select("SELECT * FROM star WHERE yhid=#{yhid} AND jlid=#{jlid}")
    Star getIsStar(@Param("yhid") Integer yhid, @Param("jlid") Integer jlid);

    @Insert("INSERT INTO star ( yhid, jlid) VALUES ( #{yhid}, #{jlid}) ")
    Integer addStar(@Param("yhid") Integer yhid,@Param("jlid") Integer jlid);

    @Update({ "update star set sc= #{sc} where yhid = #{yhid} and jlid=#{jlid}" })
    int updateStar(@Param("yhid") Integer yhid,@Param("jlid") Integer jlid,@Param("sc") Integer sc);

    
}

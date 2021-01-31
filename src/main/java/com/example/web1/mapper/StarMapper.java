package com.example.web1.mapper;

import com.example.web1.pojo.Follow;
import com.example.web1.pojo.Star;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StarMapper {
    @Select("SELECT count(*) FROM star WHERE jlid=#{jlid}")
    Integer getStarNumByJlid(@Param("jlid") Integer jlid);

    @Select("SELECT * FROM star WHERE yhid=#{yhid} AND jlid=#{jlid}")
    Star getIsStar(@Param("yhid") Integer yhid, @Param("jlid") Integer jlid);

    @Insert("INSERT INTO star ( yhid, jlid) VALUES ( #{yhid}, #{jlid}) ")
    Integer addStar(@Param("yhid") Integer yhid,@Param("jlid") Integer jlid);

    @Update({ "update star set sc= #{sc} where yhid = #{yhid} and jlid=#{jlid}" })
    int updateStar(@Param("yhid") Integer yhid,@Param("jlid") Integer jlid,@Param("sc") Integer sc);
}

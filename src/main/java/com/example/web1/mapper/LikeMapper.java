package com.example.web1.mapper;

import com.example.web1.pojo.Like;
import com.example.web1.pojo.Star;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LikeMapper {
    @Select("SELECT count(*) FROM likelist WHERE jlid=#{jlid}")
    Integer getLikeNumByJlid(@Param("jlid") Integer jlid);

    @Select("SELECT * FROM likelist WHERE yhid=#{yhid} AND jlid=#{jlid}")
    Like getIsLike(@Param("yhid") Integer yhid, @Param("jlid") Integer jlid);

    @Insert("INSERT INTO likelist ( yhid, jlid) VALUES ( #{yhid}, #{jlid}) ")
    Integer addLike(@Param("yhid") Integer yhid,@Param("jlid") Integer jlid);

    @Update({ "update likelist set sc= #{sc} where yhid = #{yhid} and jlid=#{jlid}" })
    int updateLike(@Param("yhid") Integer yhid,@Param("jlid") Integer jlid,@Param("sc") Integer sc);

}

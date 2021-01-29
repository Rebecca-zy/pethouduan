package com.example.web1.mapper;

import com.example.web1.pojo.Follow;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FollowMapper {
    @Select("SELECT count(*) FROM follow WHERE zyhid=#{zyhid}")
    Integer getFollowZyhId(@Param("zyhid") Integer zyhid);

    @Select("SELECT * FROM follow WHERE zyhid=#{zyhid} and fsid=#{fsid}")
    Follow JudgeFollowZyhId(@Param("zyhid") Integer zyhid, @Param("fsid") Integer fsid);

    @Select("SELECT * FROM follow WHERE zyhid=#{zyhid} AND fsid=#{fsid}")
    Follow getIsFollow(@Param("zyhid") Integer zyhid,@Param("fsid") Integer fsid);

    @Insert("INSERT INTO follow ( zyhid, fsid, qxgz )   VALUES ( #{zyhid}, #{fsid}, #{qxgz}) ")
    Integer addFollow(@Param("zyhid") Integer zyhid,@Param("fsid") Integer fsid,@Param("qxgz") Integer qxgz);

    @Update({ "update follow set qxgz= #{qxgz} where zyhid = #{zyhid} and fsid=#{fsid}" })
    int updateFollow(@Param("zyhid") Integer zyhid,@Param("fsid") Integer fsid,@Param("qxgz") Integer qxgz);
}

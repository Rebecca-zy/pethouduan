package com.example.web1.mapper;

import com.example.web1.pojo.Follow;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FollowMapper {
    @Select("SELECT fsid FROM follow WHERE zyhid=#{zyhid} and qxgz=0")
    Integer getuserFsZyhId(@Param("zyhid") Integer zyhid);

    @Select("SELECT zyhid FROM follow WHERE fsid=#{zyhid} and qxgz=0")
    Integer getuserFollowZyhId(@Param("zyhid") Integer zyhid);

    @Select("SELECT count(*) FROM follow WHERE zyhid=#{zyhid} and qxgz=0")
    Integer getFollowZyhId(@Param("zyhid") Integer zyhid);

    @Select("SELECT count(*) FROM follow WHERE fsid=#{fsid} and qxgz=0")
    Integer getFollowFsId(@Param("fsid") Integer fsid);

    @Select("SELECT * FROM follow WHERE zyhid=#{zyhid} and fsid=#{fsid}")
    Follow JudgeFollowZyhId(@Param("zyhid") Integer zyhid, @Param("fsid") Integer fsid);

    @Select("SELECT * FROM follow WHERE zyhid=#{zyhid} AND fsid=#{fsid}")
    Follow getIsFollow(@Param("zyhid") Integer zyhid,@Param("fsid") Integer fsid);

    @Insert("INSERT INTO follow ( zyhid, fsid, qxgz )   VALUES ( #{zyhid}, #{fsid}, #{qxgz}) ")
    Integer addFollow(@Param("zyhid") Integer zyhid,@Param("fsid") Integer fsid,@Param("qxgz") Integer qxgz);

    @Update({ "update follow set qxgz= #{qxgz} where zyhid = #{zyhid} and fsid=#{fsid}" })
    int updateFollow(@Param("zyhid") Integer zyhid,@Param("fsid") Integer fsid,@Param("qxgz") Integer qxgz);
}

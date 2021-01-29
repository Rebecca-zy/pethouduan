package com.example.web1.mapper;

import com.example.web1.pojo.Follow;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FollowMapper {
    @Select("SELECT count(*) FROM follow WHERE zyhid=#{zyhid}")
    Integer getFollowZyhId(@Param("zyhid") Integer zyhid);

    @Select("SELECT * FROM follow WHERE zyhid=#{zyhid} AND fsid=#{fsid}")
    Follow getIsFollow(@Param("zyhid") Integer zyhid,@Param("fsid") Integer fsid);

    
    @Insert("INSERT INTO follow ( zyhid, fsid, qxgz )   VALUES ( #{zyhid}, #{fsid}, #{qxgz}) ")
    Integer addFollow(@Param("zyhid") Integer zyhid,@Param("fsid") Integer fsid,@Param("qxgz") Integer qxgz);

    @Update({ "update follow set qxgz= #{qxgz} where zyhid = #{zyhid} and fsid=#{fsid}" })
    int updateFollow(@Param("zyhid") Integer zyhid,@Param("fsid") Integer fsid,@Param("qxgz") Integer qxgz);
}

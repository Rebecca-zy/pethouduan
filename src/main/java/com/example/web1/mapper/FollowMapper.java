package com.example.web1.mapper;

import com.example.web1.pojo.Follow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FollowMapper {
    @Select("SELECT count(*) FROM follow WHERE zyhid=#{zyhid}")
    Integer getFollowZyhId(@Param("zyhid") Integer zyhid);

    @Select("SELECT * FROM follow WHERE zyhid=#{zyhid} and fsid=#{fsid}")
    Follow JudgeFollowZyhId(@Param("zyhid") Integer zyhid, @Param("fsid") Integer fsid);

}

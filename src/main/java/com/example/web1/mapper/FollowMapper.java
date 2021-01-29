package com.example.web1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FollowMapper {
    @Select("SELECT count(*) FROM follow WHERE zyhid=#{zyhid}")
    Integer getFollowZyhId(@Param("zyhid") Integer zyhid);

}

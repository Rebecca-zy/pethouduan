package com.example.web1.mapper;

import com.example.web1.pojo.Share;
import com.example.web1.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShareMapper {
    @Select("SELECT count(*) FROM share WHERE yhid=#{yhid}")
    Integer getShareYhId(@Param("yhid") Integer yhid);

    @Select("SELECT * FROM share WHERE jlid=#{jlid}")
    Share getShareByJlid(@Param("jlid") int jlid);

    @Select("SELECT wz FROM share WHERE jlid=(SELECT max(jlid) FROM share WHERE yhid=#{yhid})")
    Share getLatestShareByYhid(@Param("yhid") Integer yhid);

    @Select("SELECT * FROM share WHERE wz like CONCAT('%',#{wz},'%')")
    List<Share> getShareInfoBySimilarName(@Param("wz") String wz);
}

package com.example.web1.mapper;

import com.example.web1.pojo.Share;
import com.example.web1.pojo.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShareMapper {
    @Insert("INSERT INTO share (yhid, cwid,yhm,fbsj,wz,fqh,sc) VALUES ( #{share.yhid}, #{share.cwid}, #{share.yhm}, #{share.fbsj}, #{share.wz}, #{share.fqh},0) ")
    @Options(useGeneratedKeys = true, keyProperty = "jlid", keyColumn = "jlid")//得到插入的主键值
    Integer addShare(@Param("share") Share share);

    @Select("SELECT count(*) FROM share WHERE yhid=#{yhid}")
    Integer getShareYhId(@Param("yhid") Integer yhid);

    @Select("SELECT * FROM share WHERE jlid=#{jlid}")
    Share getShareByJlid(@Param("jlid") int jlid);

    @Select("SELECT wz FROM share WHERE jlid=(SELECT max(jlid) FROM share WHERE yhid=#{yhid})")
    Share getLatestShareByYhid(@Param("yhid") Integer yhid);

    @Select("SELECT * FROM share WHERE wz like CONCAT('%',#{wz},'%')")
    List<Share> getShareInfoBySimilarName(@Param("wz") String wz);

    // 按收藏降序排
    // SELECT `share`.jlid,`share`.wz, COUNT(star.yhid) FROM `share` JOIN star ON
    // `share`.jlid=star.jlid GROUP BY `share`.jlid
    // ORDER BY COUNT(star.yhid)desc
    // 按收藏加喜欢降序
    // SELECT `share`.jlid,`share`.wz, COUNT(star.yhid)+COUNT(likelist.yhid)
    // FROM `share` JOIN star ON `share`.jlid=star.jlid JOIN likelist ON
    // `share`.jlid=likelist.jlid
    // GROUP BY `share`.jlid
    // ORDER BY COUNT(star.yhid)+COUNT(likelist.yhid) desc
    @Select("SELECT `share`.jlid  FROM  `share` JOIN star ON `share`.jlid=star.jlid JOIN likelist ON `share`.jlid=likelist.jlid WHERE EXISTS((SELECT DISTINCT photo.jlid FROM photo) UNION (SELECT DISTINCT video.jlid FROM video)) GROUP BY `share`.jlid ORDER BY COUNT(star.yhid)+COUNT(likelist.yhid) desc")
    int[] getShareidByStarLike();

    // 返回用户的历史分享的记录
    @Select("SELECT `share`.jlid  FROM  `share` WHERE `share`.yhid=#{yhid} ORDER BY `share`.fbsj DESC")
    int[] getShareidByyhid(@Param("yhid") int yhid);

    // 返回用户的历史分享的记录分宠物
    @Select("SELECT `share`.jlid  FROM  `share` WHERE `share`.yhid=#{yhid} AND `share`.cwid=#{cwid} ORDER BY `share`.fbsj DESC")
    int[] getShareidBycwidyhid(@Param("yhid") int yhid, @Param("cwid") int cwid);

    // 返回关注用户的动态
    @Select("select `share`.jlid FROM `share` where `share`.yhid in (SELECT follow.zyhid  FROM follow where follow.fsid=#{yhid}) AND `share`.sc=0 ORDER BY `share`.fbsj DESC")
    Integer[] getfollowShareByyhid(@Param("yhid") int yhid);


    //返回对应分区的关键字相关的记录信息
    @Select("SELECT * FROM share WHERE wz like CONCAT('%',#{wz},'%') AND fqh=#{fqh}")
    List<Share> getShareInfoBySection(@Param("wz") String wz,@Param("fqh") String fqh);

    //返回对应分区的种类相关的记录信息
    @Select("SELECT * FROM share Join pet On share.yhid=pet.yhid Where wz like CONCAT('%',#{wz},'%') AND zl=#{zl}")
    List<Share> getShareInfoByKind(@Param("wz") String wz,@Param("zl") String zl);

}

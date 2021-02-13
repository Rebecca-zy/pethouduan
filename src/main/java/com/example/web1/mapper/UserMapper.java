package com.example.web1.mapper;

import com.example.web1.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//mapper层就是dao层，对数据进行增删改查处理
@Mapper
public interface UserMapper {
    
    @Select("SELECT * FROM user WHERE yhid=#{yhid}")
    User getUserInfoById(@Param("yhid") Integer yhid);

    @Select("SELECT * FROM user WHERE yhm=#{yhm}")
    User getUserInfoByName(@Param("yhm") String yhm);

    @Select("SELECT * FROM user WHERE yhm like CONCAT('%',#{yhm},'%')")
    List<User> getUserInfoBySimilarName(@Param("yhm") String yhm);

    @Select("SELECT * FROM user WHERE yx=#{yx}")
    List<User> getUserInfoByYx(@Param("yx") String yx);

    @Insert("INSERT INTO user ( yhm, mm, yx )   VALUES ( #{yhm}, #{mm}, #{yx}) ")
    @Options(useGeneratedKeys = true, keyProperty = "yhid")
    int addUser( User User);

    @Update("update user,share set user.yhm=#{yhm},yx=#{yx},share.yhm=#{yhm},gxqm=#{gxqm} where user.yhid=#{yhid} and `share`.yhid=#{yhid}")
    void renewUser(@Param("yhid")Integer yhid,@Param("yhm")String yhm,@Param("yx")String yx,@Param("gxqm")String gxqm);
}




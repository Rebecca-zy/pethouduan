package com.example.web1.mapper;

import com.example.web1.pojo.User;
import org.apache.ibatis.annotations.*;

//mapper层就是dao层，对数据进行增删改查处理
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE yhid=#{yhid}")
    User getUserInfoById(@Param("yhid") Integer yhid);

    @Select("SELECT * FROM user WHERE yhm=#{yhm}")
    User getUserInfoByName(@Param("yhm") String yhm);

    @Insert("INSERT INTO user ( yhm, mm )   VALUES ( #{yhm}, #{mm}) ")
    @Options(useGeneratedKeys = true, keyProperty = "yhid")
    int addUser( User User);
}




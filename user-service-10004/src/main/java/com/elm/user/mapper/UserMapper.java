package com.elm.user.mapper;

import com.elm.user.domain.dto.RegisterFormDTO;
import com.elm.user.domain.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper{
    @Select("select * from user where userId=#{userId}")
    User getUserById(String userId);

    @Insert("insert into user values(#{userId},#{password},#{userName},#{userSex},null,1)")
    int saveUser(RegisterFormDTO registerFormDTO);
}

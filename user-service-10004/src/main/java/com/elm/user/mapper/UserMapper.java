package com.elm.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elm.user.domain.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}

package com.ricardo.rebecca.user.mapper;

import com.ricardo.rebecca.api.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @Class UserMapper
 * @Description 用户信息 Mapper接口
 * @Author Cypress
 * @Date 2024-10-14 21:17:26
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}

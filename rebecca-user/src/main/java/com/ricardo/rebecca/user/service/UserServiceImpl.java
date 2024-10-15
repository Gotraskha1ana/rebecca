package com.ricardo.rebecca.user.service;

import cn.hutool.core.lang.Assert;
import com.ricardo.rebecca.api.entity.User;
import com.ricardo.rebecca.user.mapper.UserMapper;
import com.ricardo.rebecca.api.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Class UserServiceImpl
 * @Description 用户信息 服务实现类
 * @Author Cypress
 * @Date 2024-10-14 21:17:26
 */
@Service
@DubboService
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
@Autowired
private UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        Assert.notNull(id, "用户ID不能为空");
        System.out.println("调用getUserById方法查询用户信息");
        return getById(id);
    }

    @Override
    public String test(Long id) {

        return "调通啦：id"+id;
    }
}

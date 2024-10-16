package com.ricardo.rebecca.user.service;

import cn.hutool.core.lang.Assert;
import com.ricardo.rebecca.api.entity.User;
import com.ricardo.rebecca.api.service.ChannelAccountService;
import com.ricardo.rebecca.user.mapper.UserMapper;
import com.ricardo.rebecca.api.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Class UserServiceImpl
 * @Description 用户信息 服务实现类
 * @Author Cypress
 * @Date 2024-10-14 21:17:26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    ChannelAccountService channelAccountService;

    @Override
    public User getUserById(Long id) {
        Assert.notNull(id, "用户ID不能为空");
        return getById(id);
    }

    @Override
    public String testUser(Long id) {
        return "调通啦! id:" + id;
    }

    @Override
    public String testChannelAccount(Long id) {
        return channelAccountService.testMyService(id);
//        return "aa";
    }

    @Override
    public String testLoop(Long id) {
        return channelAccountService.test(id);
//        return "111";
    }

}

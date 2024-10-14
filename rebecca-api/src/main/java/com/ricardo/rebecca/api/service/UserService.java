package com.ricardo.rebecca.api.service;

import com.ricardo.rebecca.api.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Class UserService
 * @Description 用户信息 服务类
 * @Author Cypress
 * @Date 2024-10-14 21:17:26
 */
public interface UserService extends IService<User> {
    User getUserById(Long id);
}

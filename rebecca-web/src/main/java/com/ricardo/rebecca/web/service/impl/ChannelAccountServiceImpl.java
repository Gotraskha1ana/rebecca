package com.ricardo.rebecca.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ricardo.rebecca.web.entity.ChannelAccount;
import com.ricardo.rebecca.web.mapper.ChannelAccountMapper;
import com.ricardo.rebecca.web.service.ChannelAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class ChannelAccountServiceImpl
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/13 13:31
 */
@Service
public class ChannelAccountServiceImpl extends ServiceImpl<ChannelAccountMapper, ChannelAccount> implements ChannelAccountService {
    @Autowired
    private ChannelAccountMapper channelAccountMapper;

}

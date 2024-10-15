package com.ricardo.rebecca.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ricardo.rebecca.api.dto.SaveAccountDTO;
import com.ricardo.rebecca.api.entity.ChannelAccount;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Interface ChannelAccountService
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/14 20:39
 */
public interface ChannelAccountService extends IService<ChannelAccount> {

    Boolean saveOrUpdate(@Valid SaveAccountDTO dto);

    String test(@NotNull Long id);

    String testMyService(@NotNull Long id);
}

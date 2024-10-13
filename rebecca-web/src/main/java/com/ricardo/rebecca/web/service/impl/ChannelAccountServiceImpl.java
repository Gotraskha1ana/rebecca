package com.ricardo.rebecca.web.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ricardo.rebecca.common.enums.ValidEnum;
import com.ricardo.rebecca.web.assembler.ChannelAccountAssembler;
import com.ricardo.rebecca.web.dto.SaveAccountDTO;
import com.ricardo.rebecca.web.entity.ChannelAccount;
import com.ricardo.rebecca.web.mapper.ChannelAccountMapper;
import com.ricardo.rebecca.web.service.ChannelAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Override
    public Boolean saveOrUpdateAccount(SaveAccountDTO dto) {
        Long id = dto.getId();
        Long userId = dto.getUserId();
        ChannelAccount account = new ChannelAccount();
        boolean isNewAccount = ObjUtil.isNull(id);
        if (!isNewAccount){
             account = this.getById(id);
            Assert.isTrue(ObjUtil.isNotNull(account),"不存在当前操作修改的渠道账号，请检查后重试");
            Assert.isTrue(NumberUtil.equals(account.getUserId(),userId),"指定渠道账号不为当前用户创建，无法修改");
            Assert.isTrue(NumberUtil.equals(account.getIsValid(), ValidEnum.INVALID.getCode()),"指定渠道账号已被禁用，无法修改");
        }
        return this.saveOrUpdate(ChannelAccountAssembler.convertToEntity(account,dto,isNewAccount));
    }
}

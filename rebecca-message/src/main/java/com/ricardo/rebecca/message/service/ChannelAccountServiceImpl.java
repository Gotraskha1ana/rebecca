package com.ricardo.rebecca.message.service;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ricardo.rebecca.api.dto.SaveAccountDTO;
import com.ricardo.rebecca.api.entity.ChannelAccount;
import com.ricardo.rebecca.api.entity.User;
import com.ricardo.rebecca.api.service.ChannelAccountService;
import com.ricardo.rebecca.api.service.UserService;
import com.ricardo.rebecca.message.mapper.ChannelAccountMapper;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @Class ChannelAccountServiceImpl
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/14 20:46
 */
@Service
@DubboService
public class ChannelAccountServiceImpl extends ServiceImpl<ChannelAccountMapper, ChannelAccount> implements ChannelAccountService {
    @DubboReference
    UserService userService;

    @Override
    public Boolean saveOrUpdate(SaveAccountDTO dto) {
        System.out.println("调用userService获取用户信息");
        User user = userService.getUserById(dto.getUserId());
        System.out.println("用户信息：" + user);
        System.out.println("调用saveOrUpdate方法创建渠道账号信息");
        return true;
//        Long id = dto.getId();
//        Long userId = dto.getUserId();
//        ChannelAccount account = new ChannelAccount();
//        boolean isNewAccount = ObjUtil.isNull(id);
//        if (!isNewAccount){
//            account = this.getById(id);
//            Assert.isTrue(ObjUtil.isNotNull(account),"不存在当前操作修改的渠道账号，请检查后重试");
//            Assert.isTrue(NumberUtil.equals(account.getUserId(),userId),"指定渠道账号不为当前用户创建，无法修改");
//            Assert.isTrue(NumberUtil.equals(account.getIsValid(), ValidEnum.INVALID.getCode()),"指定渠道账号已被禁用，无法修改");
//        }
//        return this.saveOrUpdate(ChannelAccountAssembler.convertToEntity(account,dto,isNewAccount));
    }

    @Override
    public String test(Long id) {
        System.out.println("调用userService获取用户信息");
        return userService.getUserById(id).toString();
    }

    @Override
    public String testMyService(Long id) {
        System.out.println("当前位置：ChannelAccountService");
        return "调用渠道账号服务成功! id:"+id;
    }
}

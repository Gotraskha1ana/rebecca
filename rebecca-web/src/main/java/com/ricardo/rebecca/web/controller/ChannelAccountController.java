package com.ricardo.rebecca.web.controller;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjUtil;
import com.ricardo.rebecca.common.constant.RebeccaConstant;
import com.ricardo.rebecca.common.enums.RespStatusEnum;
import com.ricardo.rebecca.web.dto.SaveAccountDTO;
import com.ricardo.rebecca.web.entity.ChannelAccount;
import com.ricardo.rebecca.web.service.ChannelAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Class ChannelAccountController
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/13 13:30
 */
@Api(tags = "渠道账号管理接口")
@RestController
@RequestMapping("/account")
public class ChannelAccountController {
    @Autowired
    ChannelAccountService service;

    @PostMapping("/save")
    @ApiOperation("新增/修改渠道账号信息")
    public Boolean saveOrUpdate(@RequestBody SaveAccountDTO dto) {
        return service.saveOrUpdateAccount(dto);
    }
}

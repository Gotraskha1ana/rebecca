package com.ricardo.rebecca.message.controller;

import com.ricardo.rebecca.api.dto.SaveAccountDTO;
import com.ricardo.rebecca.api.service.ChannelAccountService;
import com.ricardo.rebecca.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Class ChannelAccountController
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/14 21:57
 */
@Api(tags = "渠道账号信息")
@RestController
//@RebeccaAspect
//@RebeccaResult
@Slf4j
@RequestMapping("/account")
public class ChannelAccountController {
    @Resource
    ChannelAccountService service;

//    @Value("${username}")
    String username;
    @ApiOperation("测试接口")
    @GetMapping("/test/{id:.+}")
    public String test(@PathVariable("id")@NotNull Long id) {
        return service.test(id);
    }
    @GetMapping("/test")
    public String test() {
        return username;
    }
    @ApiOperation("新建、更新渠道账号信息")
    @PostMapping("/save")
    public Boolean saveOrUpdateAccount(@RequestBody @Valid SaveAccountDTO dto) {
        return service.saveOrUpdate(dto);
    }
}

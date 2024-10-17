package com.ricardo.rebecca.message.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.ricardo.rebecca.api.dto.SaveAccountDTO;
import com.ricardo.rebecca.api.service.ChannelAccountService;
import com.ricardo.rebecca.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

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
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelAccountController {

    ChannelAccountService service;

    @ApiOperation("测试接口")
    @GetMapping("/test/{id:.+}")
    public String test(@PathVariable("id") @NotNull Long id) {
        return service.test(id);
    }

    @ApiOperation("新建、更新渠道账号信息")
    @PostMapping("/save")
    public Boolean saveOrUpdateAccount(@RequestBody @Valid SaveAccountDTO dto) {
        return service.saveOrUpdate(dto);
    }
}

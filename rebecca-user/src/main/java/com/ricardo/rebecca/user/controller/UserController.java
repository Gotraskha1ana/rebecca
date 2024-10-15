package com.ricardo.rebecca.user.controller;

import com.ricardo.rebecca.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.ricardo.rebecca.web.annotation.RebeccaAspect;
//import com.ricardo.rebecca.web.annotation.RebeccaResult;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;


/**
 * @Class UserController
 * @Description 用户信息 前端控制器
 * @Author Cypress
 * @Date 2024-10-14 21:17:26
 */

@Api(tags = "用户信息")
@RestController
//@RebeccaAspect
//@RebeccaResult
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;

@GetMapping("/test/{id:.+}")
public String test(@PathVariable("id") Long id){return userService.test(id);}
}

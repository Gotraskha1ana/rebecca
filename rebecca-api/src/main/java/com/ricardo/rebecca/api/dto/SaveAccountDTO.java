package com.ricardo.rebecca.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Class SaveAccountDTO
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/13 16:21
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveAccountDTO {
    @ApiModelProperty("渠道账号id")
    Long id;

    @ApiModelProperty("账号名称")
    @NotBlank(message = "账号名称不能为空！")
    String name;

    @ApiModelProperty("消息发送渠道：10.IM 20.Push 30.短信 40.Email 50.公众号 60.小程序 70.企业微信 80.钉钉机器人 90.钉钉工作通知 100.企业微信机器人 110.飞书机器人 110. 飞书应用消息 ")
    @NotNull(message = "消息发送渠道：10.IM 20.Push 30.短信 40.Email 50.公众号 60.小程序 70.企业微信 80.钉钉机器人 90.钉钉工作通知 100.企业微信机器人 110.飞书机器人 110. 飞书应用消息 不能为空！")
    Integer sendChannel;

    @ApiModelProperty("账号配置")
    @NotBlank(message = "账号配置不能为空！")
    String accountConfig;

    @ApiModelProperty("用户id")
    Long userId;

}

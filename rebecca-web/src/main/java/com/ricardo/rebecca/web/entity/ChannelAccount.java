package com.ricardo.rebecca.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Class ChannelAccount
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/13 13:31
 */

@Data
@TableName("Channel_Account")
@ApiModel(value = "ChannelAccount对象", description = "渠道账号信息")
public class ChannelAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(message = "不能为空！")
    private Long id;

    @ApiModelProperty("账号名称")
    @TableField("name")
    @NotBlank(message = "账号名称不能为空！")
    private String name;

    @ApiModelProperty("消息发送渠道：10.IM 20.Push 30.短信 40.Email 50.公众号 60.小程序 70.企业微信 80.钉钉机器人 90.钉钉工作通知 100.企业微信机器人 110.飞书机器人 110. 飞书应用消息 ")
    @TableField("send_channel")
    @NotNull(message = "消息发送渠道：10.IM 20.Push 30.短信 40.Email 50.公众号 60.小程序 70.企业微信 80.钉钉机器人 90.钉钉工作通知 100.企业微信机器人 110.飞书机器人 110. 飞书应用消息 不能为空！")
    private Byte sendChannel;

    @ApiModelProperty("账号配置")
    @TableField("account_config")
    @NotBlank(message = "账号配置不能为空！")
    private String accountConfig;

    @ApiModelProperty("拥有者")
    @TableField("creator")
    @NotBlank(message = "拥有者不能为空！")
    private String creator;

    @ApiModelProperty("创建时间")
    @TableField("created")
    @NotNull(message = "创建时间不能为空！")
    private Integer created;

    @ApiModelProperty("更新时间")
    @TableField("updated")
    @NotNull(message = "更新时间不能为空！")
    private Integer updated;

    @ApiModelProperty("是否删除：0.不删除 1.删除")
    @TableField("is_deleted")
    @NotNull(message = "是否删除：0.不删除 1.删除不能为空！")
    private Byte isDeleted;
}

package com.ricardo.rebecca.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;


/**
 * @Class User
 * @Description 用户信息 实体类
 * @Author Cypress
 * @Date 2024-10-14 21:17:26
 */

@Data
@TableName("User")
@ApiModel(value = "User对象", description = "用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(message = "用户ID不能为空！")
    private Long id;

    @ApiModelProperty("用户名")
    @TableField("username")
    @NotBlank(message = "用户名不能为空！")
    private String username;

    @ApiModelProperty("加密后的密码")
    @TableField("password")
    @NotBlank(message = "加密后的密码不能为空！")
    private String password;

    @ApiModelProperty("电子邮件")
    @TableField("email")
    private String email;

    @ApiModelProperty("创建时间")
    @TableField("created")
    @NotNull(message = "创建时间不能为空！")
    private Date created;

    @ApiModelProperty("更新时间")
    @TableField("updated")
    @NotNull(message = "更新时间不能为空！")
    private Date updated;
}

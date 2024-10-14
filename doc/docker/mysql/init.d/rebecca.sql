DROP DATABASE IF EXISTS rebecca;
CREATE DATABASE rebecca DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

USE rebecca;

DROP TABLE IF EXISTS Message_Template;

CREATE TABLE `Message_Template`
(
    `id`               BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name`             VARCHAR(100) NOT NULL DEFAULT '' COMMENT '标题',
    `audit_status`     INT(11) NOT NULL DEFAULT '0' COMMENT '当前消息审核状态： 10.待审核 20.审核成功 30.被拒绝',
    `flow_id`          VARCHAR(50) COMMENT '工单ID',
    `msg_status`       INT(11) NOT NULL DEFAULT '0' COMMENT '当前消息状态：10.新建 20.停用 30.启用 40.等待发送 50.发送中 60.发送成功 70.发送失败',
    `cron_task_id`     BIGINT(20) COMMENT '定时任务Id (xxl-job-admin返回)',
    `cron_crowd_path`  VARCHAR(500) COMMENT '定时发送人群的文件路径',
    `expect_push_time` VARCHAR(100) COMMENT '期望发送时间：0:立即发送 定时任务以及周期任务:cron表达式',
    `id_type`          INT(11) NOT NULL DEFAULT '0' COMMENT '消息的发送ID类型：10. userId 20.did 30.手机号 40.openId 50.email 60.企业微信userId',
    `send_channel`     INT(11) NOT NULL DEFAULT '0' COMMENT '消息发送渠道：10.IM 20.Push 30.短信 40.Email 50.公众号 60.小程序 70.企业微信 80.钉钉机器人 90.钉钉工作通知 100.企业微信机器人 110.飞书机器人 110. 飞书应用消息 ',
    `template_type`    INT(11) NOT NULL DEFAULT '0' COMMENT '10.运营类 20.技术类接口调用',
    `msg_type`         INT(11) NOT NULL DEFAULT '0' COMMENT '10.通知类消息 20.营销类消息 30.验证码类消息',
    `shield_type`      INT(11) NOT NULL DEFAULT '0' COMMENT '10.夜间不屏蔽 20.夜间屏蔽 30.夜间屏蔽(次日早上9点发送)',
    `msg_content`      VARCHAR(4096) NOT NULL DEFAULT '' COMMENT '消息内容 占位符用{$var}表示',
    `send_account`     INT(11) NOT NULL DEFAULT '0' COMMENT '发送账号 一个渠道下可存在多个账号',
    `creator`          VARCHAR(45) NOT NULL DEFAULT '' COMMENT '创建者',
    `updater`          VARCHAR(45) NOT NULL DEFAULT '' COMMENT '更新者',
    `auditor`          VARCHAR(45) NOT NULL DEFAULT '' COMMENT '审核人',
    `team`             VARCHAR(45) NOT NULL DEFAULT '' COMMENT '业务方团队',
    `proposer`         VARCHAR(45) NOT NULL DEFAULT '' COMMENT '业务方',
    `is_deleted`       INT(11) NOT NULL DEFAULT '0' COMMENT '是否删除：0.不删除 1.删除',
    `created`          DATETIME NOT NULL COMMENT '创建时间',
    `updated`          DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_channel` (`send_channel`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
    COMMENT ='消息模板信息';

DROP TABLE IF EXISTS Sms_Record;
CREATE TABLE `Sms_Record`
(
    `id`                  BIGINT(20) NOT NULL AUTO_INCREMENT,
    `message_template_id` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '消息模板ID',
    `phone`               BIGINT(20) NOT NULL DEFAULT '0' COMMENT '手机号',
    `supplier_id`         INT(11) NOT NULL DEFAULT '0' COMMENT '发送短信渠道商的ID',
    `supplier_name`       VARCHAR(40) NOT NULL DEFAULT '' COMMENT '发送短信渠道商的名称',
    `msg_content`         VARCHAR(600) NOT NULL DEFAULT '' COMMENT '短信发送的内容',
    `series_id`           VARCHAR(100) NOT NULL DEFAULT '' COMMENT '下发批次的ID',
    `charging_num`        INT(11) NOT NULL DEFAULT '0' COMMENT '计费条数',
    `report_content`      VARCHAR(50) NOT NULL DEFAULT '' COMMENT '回执内容',
    `status`              INT(11) NOT NULL DEFAULT '0' COMMENT '短信状态： 10.发送 20.成功 30.失败',
    `send_date`           INT(11) NOT NULL DEFAULT '0' COMMENT '发送日期：20211112',
    `created`             DATETIME NOT NULL COMMENT '创建时间',
    `updated`             DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_send_date` (`send_date`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
    COMMENT ='短信记录信息';

DROP TABLE IF EXISTS Channel_Account;

CREATE TABLE `Channel_Account`
(
    `id`             BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name`           VARCHAR(100) NOT NULL DEFAULT '' COMMENT '账号名称',
    `send_channel`   INT(11) NOT NULL DEFAULT '0' COMMENT '消息发送渠道：10.IM 20.Push 30.短信 40.Email 50.公众号 60.小程序 70.企业微信 80.钉钉机器人 90.钉钉工作通知 100.企业微信机器人 110.飞书机器人 110. 飞书应用消息 ',
    `account_config` VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '账号配置',
    `user_id`        BIGINT(128) NOT NULL DEFAULT '1' COMMENT '用户ID',
    `created`        DATETIME NOT NULL COMMENT '创建时间',
    `updated`        DATETIME NOT NULL COMMENT '更新时间',
    `is_valid`       INT(11) NOT NULL DEFAULT '0' COMMENT '启用状态：0.禁用 1.启用',
    PRIMARY KEY (`id`),
    KEY `idx_send_channel` (`send_channel`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
    COMMENT ='渠道账号信息';

-- 创建用户表
DROP TABLE IF EXISTS User;
CREATE TABLE `User` (
                        `id`               BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                        `username`         VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
                        `password`         VARCHAR(255) NOT NULL COMMENT '加密后的密码',
                        `email`            VARCHAR(100) COMMENT '电子邮件',
                        `created`          DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
                        `updated`          DATETIME NOT NULL DEFAULT NOW() COMMENT '更新时间',
                        PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
    COMMENT ='用户信息';

-- 创建角色表
DROP TABLE IF EXISTS Role;
CREATE TABLE `Role` (
                        `id`               BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                        `role_name`       VARCHAR(50) NOT NULL UNIQUE COMMENT '角色名称',
                        `description`     VARCHAR(255) COMMENT '角色描述',
                        `created`          DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
                        `updated`          DATETIME NOT NULL DEFAULT NOW() COMMENT '更新时间',
                        PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
    COMMENT ='角色信息';

-- 创建用户角色关联表
DROP TABLE IF EXISTS User_Role;
CREATE TABLE `User_Role` (
                             `user_id`         BIGINT(20) NOT NULL COMMENT '用户ID',
                             `role_id`         BIGINT(20) NOT NULL COMMENT '角色ID',
                             `created`          DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
                             PRIMARY KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
    COMMENT ='用户与角色关联信息';

-- 创建权限表
DROP TABLE IF EXISTS Permission;
CREATE TABLE `Permission` (
                              `id`               BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
                              `permission_name`  VARCHAR(50) NOT NULL UNIQUE COMMENT '权限名称',
                              `description`      VARCHAR(255) COMMENT '权限描述',
                              `created`          DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
                              PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
    COMMENT ='权限信息';

-- 创建角色权限关联表
DROP TABLE IF EXISTS Role_Permission;
CREATE TABLE `Role_Permission` (
                                   `role_id`         BIGINT(20) NOT NULL COMMENT '角色ID',
                                   `permission_id`   BIGINT(20) NOT NULL COMMENT '权限ID',
                                   `created`          DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
                                   PRIMARY KEY (`role_id`, `permission_id`)
) ENGINE = InnoDB
    COMMENT ='角色与权限关联信息';

-- 创建权限
INSERT INTO `Permission` (`permission_name`, `description`) VALUES
                                                                ('FULL_ACCESS', '拥有所有权限'),
                                                                ('VIEW_DATA', '查看自己数据的权限'),
                                                                ('EDIT_OWN_DATA', '修改自己数据的权限'),
                                                                ('EDIT_ALL_DATA', '修改所有用户数据的权限'),
                                                                ('MANAGE_USERS', '管理用户的权限，包括创建、删除和修改用户'),
                                                                ('MANAGE_ROLES', '管理角色的权限，包括创建、删除和修改角色');
INSERT INTO `Role` (`role_name`, `description`) VALUES
                                                    ('Joker', '伟大，无需多言'),
                                                    ('管理员', '管理员，具有查看和修改所有用户数据的权限'),
                                                    ('普通用户', '普通用户，拥有基本的查看和修改自己数据的权限');
INSERT INTO Role_Permission(`role_id`, `permission_id`) VALUES
                                                            (1, 1),
                                                            (2,2),
                                                            (2,3),
                                                            (2,4),
                                                            (3,2),
                                                            (3,4);
INSERT INTO User_Role(`user_id`, `role_id`) VALUES (1,1);

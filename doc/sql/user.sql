-- 创建用户表
DROP TABLE IF EXISTS User;
CREATE TABLE `User` (
                         `id`               BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                         `username`         VARCHAR(50) COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE COMMENT '用户名',
                         `password`         VARCHAR(255) NOT NULL COMMENT '加密后的密码',
                         `email`            VARCHAR(100) COLLATE utf8mb4_unicode_ci COMMENT '电子邮件',
                         `created`          int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
                         `updated`          int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
                         PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='用户信息';

-- 创建角色表
DROP TABLE IF EXISTS Role;
CREATE TABLE `Role` (
                         `id`               BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                         `role_name`       VARCHAR(50) COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE COMMENT '角色名称',
                         `description`     VARCHAR(255) COLLATE utf8mb4_unicode_ci COMMENT '角色描述',
                         `created`          int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
                         `updated`          int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
                         PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='角色信息';

-- 创建用户角色关联表

DROP TABLE IF EXISTS User_Role;
CREATE TABLE `User_Role` (
                              `user_id`         BIGINT(20) NOT NULL COMMENT '用户ID',
                              `role_id`         BIGINT(20) NOT NULL COMMENT '角色ID',
                              `created`          int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
                              PRIMARY KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='用户与角色关联信息';

-- 创建权限表
DROP TABLE IF EXISTS Permission;
CREATE TABLE `Permission` (
                               `id`               BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
                               `permission_name`  VARCHAR(50) COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE COMMENT '权限名称',
                               `description`      VARCHAR(255) COLLATE utf8mb4_unicode_ci COMMENT '权限描述',
                               `created`          int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
                               PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='权限信息';

-- 创建角色权限关联表
DROP TABLE IF EXISTS Role_Permission;
CREATE TABLE `Role_Permission` (
                                    `role_id`         BIGINT(20) NOT NULL COMMENT '角色ID',
                                    `permission_id`   BIGINT(20) NOT NULL COMMENT '权限ID',
                                    `created`          int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
                                    PRIMARY KEY (`role_id`, `permission_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='角色与权限关联信息';

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
INSERT INTO User(`username`, `password`, `email`, `created`, `updated`) VALUES
    ('Joker','Ricardoc297.','2268658244@qq.com',0,0);
INSERT INTO User_Role(`user_id`, `role_id`) VALUES (1,1);
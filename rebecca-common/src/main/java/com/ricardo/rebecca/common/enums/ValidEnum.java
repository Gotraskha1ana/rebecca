package com.ricardo.rebecca.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Enum ValidEnum
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/13 17:01
 */
@Getter
@AllArgsConstructor
public enum ValidEnum implements CommonEnum {
    INVALID(0,"禁用"),
    VALID(1,"启用");


    private final Integer code;
    private final String description;
}

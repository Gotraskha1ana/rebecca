package com.ricardo.rebecca.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * @Enum  SmsStatus
 * @Description TODO
 * @Author  Cypress
 * @Date  2024/9/23 22:35
 */
@Getter
@AllArgsConstructor
public enum SmsStatus implements CommonEnum {
    /**
     * 调用渠道接口发送成功
     */
    SEND_SUCCESS(10, "调用渠道接口发送成功"),
    /**
     * 用户收到短信(收到渠道短信回执，状态成功)
     */
    RECEIVE_SUCCESS(20, "用户收到短信(收到渠道短信回执，状态成功)"),
    /**
     * 用户收不到短信(收到渠道短信回执，状态失败)
     */
    RECEIVE_FAIL(30, "用户收不到短信(收到渠道短信回执，状态失败)"),
    /**
     * 调用渠道接口发送失败
     */
    SEND_FAIL(40, "调用渠道接口发送失败");



private final Integer code;
private final String description;
}

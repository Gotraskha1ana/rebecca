package com.ricardo.rebecca.common.vo;

import com.ricardo.rebecca.common.enums.RespStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName R
 * @Description TODO
 * @Author RicardoC
 * @Date 2024/9/8 14:36
 */
@Getter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public final class R<T> implements Serializable {
    /**
     * 响应状态
     */
    private String status;

    /**
     * 响应编码
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public R(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public R(RespStatusEnum status) {
        this(status, null);
    }

    public R(RespStatusEnum status, T data) {
        this(status, status.getMsg(), data);
    }

    public R(RespStatusEnum status, String msg, T data) {
        this.status = status.getCode();
        this.msg = msg;
        this.data = data;
    }

    /**
     * @return 默认成功响应
     */
    public static R<Void> success() {
        return new R<>(RespStatusEnum.SUCCESS);
    }

    /**
     * 自定义信息的成功响应
     * <p>通常用作插入成功等并显示具体操作通知如: return R.success("发送信息成功")</p>
     *
     * @param msg 信息
     * @return 自定义信息的成功响应
     */
    public static <T> R<T> success(String msg) {
        return new R<>(RespStatusEnum.SUCCESS, msg, null);
    }

    /**
     * 带数据的成功响应
     *
     * @param data 数据
     * @return 带数据的成功响应
     */
    public static <T> R<T> success(T data) {
        return new R<>(RespStatusEnum.SUCCESS, data);
    }

    /**
     * @return 默认失败响应
     */
    public static <T> R<T> fail() {
        return new R<>(
                RespStatusEnum.FAIL,
                RespStatusEnum.FAIL.getMsg(),
                null
        );
    }

    /**
     * 自定义错误信息的失败响应
     *
     * @param msg 错误信息
     * @return 自定义错误信息的失败响应
     */
    public static <T> R<T> fail(String msg) {
        return fail(RespStatusEnum.FAIL, msg);
    }

    /**
     * 自定义状态的失败响应
     *
     * @param status 状态
     * @return 自定义状态的失败响应
     */
    public static <T> R<T> fail(RespStatusEnum status) {
        return fail(status, status.getMsg());
    }

    /**
     * 自定义状态和信息的失败响应
     *
     * @param status 状态
     * @param msg    信息
     * @return 自定义状态和信息的失败响应
     */
    public static <T> R<T> fail(RespStatusEnum status, String msg) {
        return new R<>(status, msg, null);
    }

}

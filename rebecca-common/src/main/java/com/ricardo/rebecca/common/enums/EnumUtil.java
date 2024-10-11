package com.ricardo.rebecca.common.enums;

import cn.hutool.core.lang.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Class EnumUtil
 * @Description 枚举工具类（获取枚举的描述、获取枚举的code、获取枚举的code列表）
 * @Author RicardoC
 * @Date 2024/9/8 12:30
 */

public class EnumUtil {

    private EnumUtil() {
    }

    /**
     * @param code      枚举编码
     * @param enumClass 需要提供的枚举类，必须实现 {@link CommonEnum} 接口。
     * @param <E>       枚举类型，必须实现 {@link CommonEnum} 接口。
     * @return 枚举编码对应的描述 枚举类下无对应编码时返回空字符串""
     * @Description 根据枚举编码获取对应描述
     */
    public static <E extends CommonEnum> String getDescriptionByCode(Integer code, Class<E> enumClass) {
        verifyEnum(enumClass);
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(i -> Objects.equals(i.getCode(), code))
                .findFirst().map(CommonEnum::getDescription).orElse("");
    }

    /**
     * @param enumClass 需要提供的枚举类，必须实现 {@link CommonEnum} 接口。
     * @param <E>       枚举类型，必须实现 {@link CommonEnum} 接口。
     * @return E 指定编码对应的枚举 枚举类下无对应编码时返回null
     * @Description 根据入参编码获取对应枚举实体
     */
    public static <E extends CommonEnum> E getEnumByCode(Integer code, Class<E> enumClass) {
        verifyEnum(enumClass);
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> Objects.equals(e.getCode(), code))
                .findFirst().orElse(null);
    }

    /**
     * @param enumClass 需要提供的枚举类，必须实现 {@link CommonEnum} 接口。
     * @param <E>       枚举类型，必须实现 {@link CommonEnum} 接口。
     * @return List<Integer> 编码列表
     * @Description 获取入参枚举类的编码列表
     */
    public static <E extends CommonEnum> List<Integer> getCodeList(Class<E> enumClass) {
        verifyEnum(enumClass);
        return Arrays.stream(enumClass.getEnumConstants())
                .map(CommonEnum::getCode)
                .collect(Collectors.toList());
    }

    /**
     * @param clazz 需要提供的枚举类，必须实现 {@link CommonEnum} 接口。
     * @param <E>   CommonEnum
     * @Description 校验入参类型是否为指定泛型的枚举类
     */
    private static <E extends CommonEnum> void verifyEnum(Class<E> clazz) {
        Assert.notNull(clazz);
        Assert.isTrue(clazz.isEnum(), "往枚举工具类里传非枚举类你多少是有点大病。");
    }

}

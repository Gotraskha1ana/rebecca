package com.ricardo.rebecca.common.constant;

/**
 * @ClassName RebeccaConstant
 * @Description TODO
 * @Author RicardoC
 * @Date 2024/9/8 2:38
 */

public class RebeccaConstant {
    /**
     * businessId默认的长度
     * 生成的逻辑：com.ricardo.rebecca.support.utils.TaskInfoUtils#generateBusinessId(java.lang.Long, java.lang.Integer)
     */
    public static final Integer BUSINESS_ID_LENGTH = 16;
    /**
     * 接口限制 最多的人数
     */
    public static final Integer BATCH_RECEIVER_SIZE = 100;
    /**
     * 消息发送给全部人的标识
     * (企业微信 应用消息)
     * (钉钉自定义机器人)
     * (钉钉工作消息)
     */
    public static final String SEND_ALL = "@all";
    /**
     * 链路追踪缓存的key标识
     */
    public static final String CACHE_KEY_PREFIX = "Rebecca";
    public static final String MESSAGE_ID = "MessageId";
    /**
     * 消息模板常量；
     * 如果新建模板/账号时，没传入则用该常量
     */
    public static final String DEFAULT_CREATOR = "Ricardo";
    public static final Long DEFAULT_USER_ID = 1L;
    public static final String DEFAULT_UPDATER = "Ricardo";
    public static final String DEFAULT_TEAM = "Ricardo";
    public static final String DEFAULT_AUDITOR = "Ricardo";
    /**
     * 项目打印常量
     */
    public static final String REBECCA = ":: Rebecca ::";
    public static final String REBECCA_BANNER = "\n________     ______                          \n___  __ \\_______  /________________________ _\n__  /_/ /  _ \\_  __ \\  _ \\  ___/  ___/  __ `/\n_  _, _//  __/  /_/ /  __/ /__ / /__ / /_/ / \n /_/ |_| \\___//_.___/\\___/\\___/ \\___/ \\__,_/  \n\n";
    private RebeccaConstant() {

    }


}

package com.ricardo.rebecca.common.constant;

/**
 * @ClassName CommonConstant
 * @Description 通用常量
 * @Author RicardoC
 * @Date 2024/9/8 13:25
 */

public class CommonConstant {

    public static final String PERIOD = ".";
    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String SEMICOLON = ";";
    public static final String POUND = "#";
    public static final String SLASH = "/";
    public static final String BACKSLASH = "\\";
    public static final String EMPTY_STRING = "";
    public static final String RADICAL = "|";
    public static final String QM_STRING = "?";
    public static final String EQUAL_STRING = "=";
    public static final String AND_STRING = "&";
    public static final String ONE = "1";
    public static final String ZERO = "0";
    public static final String MINUS_ONE = "-1";
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final char QM = '?';
    /**
     * @Description boolean转换
     */
    public static final Integer TRUE = 1;
    public static final Integer FALSE = 0;
    /**
     * @Description 加密算法
     */
    public static final String HMAC_SHA256_ENCRYPTION_ALGO = "HmacSHA256";
    /**
     * @Description 编码格式
     */
    public static final String CHARSET_UTF_8 = "UTF-8";
    /**
     * @Description HTTP请求内容格式
     */
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    public static final String CONTENT_TYPE_TEXT = "text/html;charset=utf-8";
    public static final String CONTENT_TYPE_XML = "application/xml; charset=UTF-8";
    public static final String CONTENT_TYPE_FORM_URL_ENCODE = "application/x-www-form-urlencoded;charset=utf-8;";
    public static final String CONTENT_TYPE_MULTIPART_FORM_DATA = "multipart/form-data";
    /**
     * @Description 协议
     */
    public static final String HTTP = "http";
    public static final String HTTPS = "https";
    public static final String OSS = "oss";
    /**
     * @Description HTTP 请求方法
     */
    public static final String REQUEST_METHOD_GET = "GET";
    public static final String REQUEST_METHOD_POST = "POST";
    public static final String REQUEST_METHOD_PUT = "PUT";
    public static final String REQUEST_METHOD_DELETE = "DELETE";
    public static final String REQUEST_METHOD_PATCH = "PATCH";
    /**
     * @Description JSON默认值
     */
    public static final String EMPTY_JSON_OBJECT = "{}";
    public static final String EMPTY_VALUE_JSON_ARRAY = "[]";
    /**
     * @Description 日期相关
     */
    public static final String CRON_FORMAT = "ss mm HH dd MM ? yyyy-yyyy";
    public static final Long ONE_DAY_SECOND = 86400L;

    /**
     * @Description 环境常量
     */
    public static final String ENV_DEV = "dev";
    public static final String ENV_TEST = "test";
    private CommonConstant() {
    }

}

package com.book.developtest.tuomin;

import java.io.Serializable;

/**
 * @author: hj
 * @date: 2021-06-04 15:43
 * @description:
 **/
/**
 * @date 2020/9/29 16:22
 * 脱敏字段：所有需要脱敏的字段名称
 */
public class BaseField implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 中文名称
     */
    @DesensitizedAnnotation(type = TypeEnum.CHINESE_NAME)
    private String username;

    /**
     * 手机号码
     */
    @DesensitizedAnnotation(type = TypeEnum.MOBILE_PHONE)
    private String phone;

    /**
     * 密码
     */
    @DesensitizedAnnotation(type = TypeEnum.PASSWORD)
    private String password;

    /**
     * 地址
     */
    @DesensitizedAnnotation(type = TypeEnum.ADDRESS)
    private String address;

    /**
     * 银行卡号
     */
    @DesensitizedAnnotation(type = TypeEnum.BANKCARD)
    private String bankCard;

    /**
     * 邮箱地址
     */
    @DesensitizedAnnotation(type = TypeEnum.EMAIL)
    private String email;

    /**
     * 固定电话号码
     */
    @DesensitizedAnnotation(type = TypeEnum.FIXED_PHONE)
    private String fixedPhone;

    /**
     * 证件号
     */
    @DesensitizedAnnotation(type = TypeEnum.ID_CARD_NUM)
    private String idCardNum;
}


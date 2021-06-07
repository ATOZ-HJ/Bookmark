package com.book.developtest.tuomin;

/**
 * @author: hj
 * @date: 2021-06-04 15:41
 * @description:
 **/

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @date 2020/9/29 16:23
 */
public class DesensitizedUtils {

    private static final Logger logger = LoggerFactory.getLogger(DesensitizedUtils.class);

    /**
     * 存储所有需要脱敏的字段
     */
    private static final Map<String, TypeEnum> annotationMaps = new HashMap<>();

    /**
     * 类加载时装配待脱敏字段
     */
    static {
        try {
            Class<?> clazz = Class.forName(BaseField.class.getName());
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                DesensitizedAnnotation annotation = fields[i].getAnnotation(DesensitizedAnnotation.class);
                if (annotation != null) {
                    TypeEnum type = annotation.type();
                    String name = fields[i].getName();
                    //name为注解字段名称，value为注解类型。方便后续根据注解类型扩展
                    DesensitizedUtils.annotationMaps.put(name, type);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            DesensitizedUtils.logger.error("类加载时装配待脱敏字段异常，异常信息:[{}]", new Object[]{e});
        }
    }


    /**
     * 脱敏：可以实现Map或者JavaBean两种模式脱敏
     *
     * @param object 需要脱敏的对象
     */
    public static String desensitization(Object object) {
        String objClassName = object.getClass().getName();
        try {
            // 1.处理Map数据类型
            if (object instanceof Map) {
                HashMap<String, Object> reqMap = (HashMap) object;
                Iterator<String> iterator = DesensitizedUtils.annotationMaps.keySet().iterator();
                iterator.forEachRemaining(annotationName -> {
                    if (reqMap.keySet().contains(annotationName)) {
                        DesensitizedUtils.doconverentForMap(reqMap, annotationName);
                    }
                });
                return JSON.toJSONString(reqMap);
            }
            // 2.处理Object数据类型
            Object val = new Object();
            Class<?> objClazz = Class.forName(objClassName);
            Field[] declaredFields = objClazz.getDeclaredFields();
            for (int j = 0; j < declaredFields.length; j++) {
                Iterator<String> iterator = DesensitizedUtils.annotationMaps.keySet().iterator();
                while (iterator.hasNext()) {
                    String annotationName = iterator.next();
                    if (declaredFields[j].getName().equals(annotationName)) {
                        declaredFields[j].setAccessible(true);
                        val = declaredFields[j].get(object);
                        //获取属性后现在默认处理的是String类型，其他类型数据可扩展
                        String value = DesensitizedUtils.doconverentForObject(val, annotationName);
                        declaredFields[j].set(object, value);
                    }
                }
            }
            return JSON.toJSONString(object);
        } catch (Exception e) {
            e.printStackTrace();
            DesensitizedUtils.logger.error("日志脱敏处理失败，回滚，详细信息:[{}]", new Object[]{e});
            return JSON.toJSONString(object);
        }
    }

    /**
     * 脱敏数据源为Object（JavaBean）时处理方式
     */
    private static String doconverentForObject(Object val, String annotationName) {

        String value = String.valueOf(val);
        if (StringUtils.isNotEmpty(value)) {
            value = DesensitizedUtils.doConverentByType(value, annotationName);
        }
        return value;
    }

    /**
     * 脱敏数据源为Map时处理方式
     */
    private static void doconverentForMap(HashMap<String, Object> reqMap, String annotationName) {
        String value = String.valueOf(reqMap.get(annotationName));
        if (StringUtils.isNotEmpty(value)) {
            value = DesensitizedUtils.doConverentByType(value, annotationName);
        }
        reqMap.put(annotationName, value);
    }


    /**
     * 根据不同注解类型处理不同字段
     */
    private static String doConverentByType(String value, String annotationName) {
        TypeEnum typeEnum = DesensitizedUtils.annotationMaps.get(annotationName);
        switch (typeEnum) {
            case CHINESE_NAME:
                value = DesensitizedUtils.chineseName(value);
                break;
            case ID_CARD_NUM:
                value = DesensitizedUtils.idCardNum(value);
                break;
            case MOBILE_PHONE:
                value = DesensitizedUtils.mobilePhone(value);
                break;
            case FIXED_PHONE:
                value = DesensitizedUtils.fixedPhone(value);
                break;
            case PASSWORD:
                value = DesensitizedUtils.password(value);
                break;
            case BANKCARD:
                value = DesensitizedUtils.bankCard(value);
                break;
            case EMAIL:
                value = DesensitizedUtils.email(value);
                break;
            case ADDRESS:
                value = DesensitizedUtils.address(value);
                break;
        }
        return value;
    }

    /*--------------------------下面的脱敏工具类也可以单独对某一个字段进行使用-------------------------*/

    /**
     * 【中文姓名】只显示第一个汉字，其他隐藏为2个星号，比如：李**
     */
    public static String chineseName(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        String name = StringUtils.left(fullName, 1);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }

    /**
     * 【身份证号】显示最后四位，其他隐藏。共计18位或者15位，比如：*************1234
     */
    public static String idCardNum(String id) {
        if (StringUtils.isBlank(id)) {
            return "";
        }
        String num = StringUtils.right(id, 4);
        return StringUtils.leftPad(num, StringUtils.length(id), "*");
    }

    /**
     * 【固定电话】 显示后四位，其他隐藏，比如：*******3241
     */
    public static String fixedPhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*");
    }

    /**
     * 【手机号码】前三位，后四位，其他隐藏，比如：135****6810
     */
    public static String mobilePhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }

    /**
     * 【地址】只显示到地区，不显示详细地址，比如：湖南省长沙市岳麓区***
     */
    public static String address(String address) {
        int sensitiveSize = 8;
        if (StringUtils.isBlank(address)) {
            return "";
        }
        int length = StringUtils.length(address);
        return StringUtils.rightPad(StringUtils.left(address, (length - sensitiveSize) < 0 ? 0 : length - sensitiveSize), length, "*");
    }

    /**
     * 【电子邮箱】 邮箱前缀仅显示第一个字母，前缀其他隐藏，用星号代替，@及后面的地址显示，比如：d**@126.com
     */
    public static String email(String email) {
        if (StringUtils.isBlank(email)) {
            return "";
        }
        int index = StringUtils.indexOf(email, "@");
        if (index <= 1) {
            return email;
        } else {
            return StringUtils.rightPad(StringUtils.left(email, 1), index, "*").concat(StringUtils.mid(email, index, StringUtils.length(email)));
        }
    }

    /**
     * 【银行卡号】前六位，后四位，其他用星号隐藏每位1个星号，比如：6222600**********1234
     */
    public static String bankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }

    /**
     * 【密码】密码的全部字符都用*代替，比如：******
     */
    public static String password(String password) {
        if (StringUtils.isBlank(password)) {
            return "";
        }
        String pwd = StringUtils.left(password, 0);
        return StringUtils.rightPad(pwd, StringUtils.length(password), "*");
    }
}

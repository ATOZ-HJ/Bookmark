package com.book.developtest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * @Author: hj
 * @DateTime: 2020/10/14 14:37
 * @Description:
 */
public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 纯净映射器：未设置任何策略，向外提供
     */
    public static volatile ObjectMapper pureMapper;

    /**
     * 策略映射器：设置SNAKE_CASE策略，实现驼峰和小写字母下划线之间的转换，
     */
    public static volatile ObjectMapper snakeCaseMapper;

    /**
     * 初始化驼峰构造器
     */
    static {
        snakeCaseMapper = new ObjectMapper();
        snakeCaseMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        snakeCaseMapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        snakeCaseMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        snakeCaseMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        System.out.println("static 执行了");
    }

    /**
     * getPureMapperInstance
     *
     * @Description 获取原生映射器
     */
    public static ObjectMapper getPureMapperInstance() {
        if (pureMapper == null) {
            synchronized (JsonUtil.class) {
                if (pureMapper == null) {
                    pureMapper = new ObjectMapper();
                    pureMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
            }
        }
        return pureMapper;
    }

    /**
     * toJsonString
     *
     * @Description 对象转json字符串
     */
    public static String toJsonString(Object obj, ObjectMapper mapper) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String)obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    /**
     * 对象转json字符串（使用默认转映射器）
     * 
     * @param obj
     * @return
     */
    public static String toJsonString(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj.getClass() == String.class) {
            return (String)obj;
        }
        try {
            String s = snakeCaseMapper.writeValueAsString(obj);
            return s;
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    /**
     * toBean
     *
     * @param json
     *            待转换字符串
     * @param tClass
     *            目标bean类
     * @param mapper
     *            传入的映射器
     * @return T 响应实体类
     * @Description jsonStr转换为bean(字段属性为驼峰)
     */
    public static <T> T toBean(String json, Class<T> tClass, ObjectMapper mapper) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    /**
     * toBean
     *
     * @param json
     *            待转换字符串
     * @param tClass
     *            目标bean类
     * @return T 响应实体类
     * @Description jsonStr转换为bean(使用默认映射器)
     */
    public static <T> T toBean(String json, Class<T> tClass) {
        try {
            return snakeCaseMapper.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    /**
     * 解析json字符串为指定类型
     * 
     * @param jsonString
     * @param typeReference
     * @param <T>
     * @return
     */
    public static <T> T toBean(String jsonString, TypeReference<T> typeReference) {
        try {
            return snakeCaseMapper.readValue(jsonString, typeReference);
        } catch (IOException e) {
            logger.error("json解析出错：" + jsonString, e);
            return null;
        }
    }

    public static <E> List<E> toList(String json, Class<E> eClass, ObjectMapper mapper) {
        if (json == null || json.length() == 0) {
            return Collections.emptyList();
        }
        try {
            return mapper.readValue(json, snakeCaseMapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <E> List<E> toList(String json, Class<E> eClass) {
        ObjectMapper objectMapper = getPureMapperInstance();
        if (json == null || json.length() == 0) {
            return Collections.emptyList();
        }
        try {
            return objectMapper.readValue(json,
                snakeCaseMapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return MAPPER.readValue(json, MAPPER.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <T> T nativeRead(String json, TypeReference<T> type, ObjectMapper mapper) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }
}

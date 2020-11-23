package com.book.developtest;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Map;

/**
 * @Author: hj
 * @DateTime: 2020/10/30 10:24
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        String v2 = "{\n" +
                "    \"entity\": {\n" +
                "     \"bankNo\": null\n" +
                "    }  \n" +
                "}";



//        cn.hutool.json.JSONObject jsonObject1 = JSONUtil.parseObj(v2);
//        System.out.println("jsonObject1 = " + jsonObject1);
//        String entity = jsonObject1.get("entity").toString();

        JSONObject jsonObject = JSON.parseObject(v2, Feature.IgnoreNotMatch);
        String entity = JSON.toJSONString(jsonObject.get("entity"), SerializerFeature.WriteMapNullValue);

        System.out.println("entity = " + entity);
    }
}

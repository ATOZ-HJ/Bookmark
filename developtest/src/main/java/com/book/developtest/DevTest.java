package com.book.developtest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.book.developtest.util.JsonUtil;
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
        String json = "{\n" +
                "    \"task_id\": \"xx123s45a3\",\n" +
                "    \"retcode\": 0,\n" +
                "    \"retmsg\": \"\",\n" +
                "    \"variety_list\":[{\"leg1_symbol\":\"Au(T+D)\"}, {\"leg2_symbol\":\"Ag(T+D)\"},{\"leg2_symbol\":\"Au99.99\"}],\n" +
                "\t\"parameters\":[{\"n_up\":2}, {\"n_down\":0}, {\"n_mid\":0}, {\"f_up\":0}, {\"f_down\":0}, {\"f_mid\":0}]\n" +
                "}";
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
}

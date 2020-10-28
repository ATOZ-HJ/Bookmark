package com.bookmark.json.JsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * @Author: hj
 * @DateTime: 2020/10/15 14:08
 * @Description:
 */
public class JsonObjectMapperDemo {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"user_name\":\"hj\",\"id_number\":\"123456\"}";

    }

    @Data
    class User {
        private String userName;
        private String idNumber;
    }
}

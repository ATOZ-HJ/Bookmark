package com.book.developtest;


import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: kingstar-banana
 * @description:
 * @author: ldl
 * @date: 2020-01-13 15:03
 **/
@Slf4j
public final class HttpUtil {

    private OkHttpClient client;


    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    /**
     * @return $return
     * @Author ldl
     * @Description //TODO
     * @Date
     * @Param
     **/
    private HttpUtil() {
        client = new OkHttpClient().newBuilder().build();
    }

    /**
     * @Author ldl
     * @Description //TODO
     * @Date
     * @Param
     * @return $return
     **/
    private static class Holder {
        private static final HttpUtil httpClientUtil = new HttpUtil();
    }


    /**
     * @return $return
     * @Author ldl
     * @Description //TODO
     * @Date
     * @Param
     **/
    public static HttpUtil getInstance() {
        return Holder.httpClientUtil;
    }



    /**
     * 发送请求数据 支持   get post put delete
     *
     * @param url
     * @param json
     * @param requestType
     * @return
     * @throws IOException
     */
    public Map<String, Object> httpRequest(String url, String json, String requestType) {
        Headers.Builder headersBuilder = new Headers.Builder();
        okhttp3.RequestBody body = okhttp3.RequestBody.create(JSON,json);
        if ("GET".equalsIgnoreCase(requestType)) {
            body = null;
        }
        Request request = new Request.Builder()
                .headers(headersBuilder.build())
                .url(url)
                .method(requestType, body)
                .build();
        Response response = null;

        try {
            response = client.newCall(request).execute();
            return getResponseResultMap(url, response);
        } catch (Exception e) {
            log.info("OKHTTP请求异常: {}", e.getMessage());
        }
        return null;
    }
    /**
     * 封装返回数据
     *
     * @param url
     * @param response
     * @return
     * @throws IOException
     */
    private Map<String, Object> getResponseResultMap(String url, Response response) throws IOException {
        Map<String, Object> map = new HashMap<>(16);
        String responseBody = "{}";
        Headers headers = new Headers.Builder().build();
        int code = -1;
        if (response != null) {
            responseBody = response.body().string();
            headers = response.headers();
            code = response.code();
        }
        map.put("responseBody", responseBody);
        map.put("headers", headers);
        map.put("code", code);
        map.put("url", url);
        return map;
    }

    /**
     * 发送请求数据 支持   get post put delete
     *
     * @param stepUrl
     * @param headerParamsMap
     * @param json
     * @param requestType
     * @return
     * @throws IOException
     */
    public Map<String, Object> httpRequest(String stepUrl, Map<String, Object> headerParamsMap, String json, String requestType) throws IOException {
        okhttp3.RequestBody body = RequestBody.create(JSON,json);
        if ("GET".equalsIgnoreCase(requestType)) {
            body = null;
        }
        Headers.Builder headersBuilder = new Headers.Builder();
        if (!headerParamsMap.isEmpty() && headerParamsMap.size() > 0) {
            Iterator iterator = headerParamsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                headersBuilder.add((String) entry.getKey(), (String) entry.getValue());
            }
        }
        Request request = new Request.Builder()
                .url(stepUrl)
                .headers(headersBuilder.build())
                .method(requestType, body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return getResponseResultMap(stepUrl, response);
        }
    }

}

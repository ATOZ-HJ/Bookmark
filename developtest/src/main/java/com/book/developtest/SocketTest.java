package com.book.developtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author: hj
 * @date: 2021-03-20 16:11
 * @description:
 **/
@Slf4j
public class SocketTest {


    @Value("${b2b.host}")
    private String host;

    @Value("${b2b.port}")
    private int port;

    private final static Integer MIN_LENGTH = 4;

    private final static String RESULT_STATUS = "Y";

    private final static Integer RESULT_STATUS_LENGTH = 3;

    private final static Integer TIME_OUT = 1000 * 10 * 60;


    public String singlePackage(String message) {
        String resultMsg = null;
        Socket socket = null;
        BufferedInputStream inputStream = null;
        PrintWriter out = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), TIME_OUT);
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.print(message);
            out.flush();
            inputStream = new BufferedInputStream(socket.getInputStream());
            resultMsg = readInputStream(inputStream);
            log.info("发送内容: {}  返回结果: {} ", message, resultMsg);
        }catch (IOException e) {
            log.info("host: {} ,port :{} 发送内容: {} ,异常: {}", host, port, message, e);
            throw new RuntimeException("服务繁忙");
        } finally {
            close(socket, inputStream, out);
        }
        return resultMsg;
    }

    public List<String> manyPackage(String message, String nextMessage) {
        List<String> list = new ArrayList<>();
        Socket socket = null;
        BufferedInputStream inputStream = null;
        PrintWriter out = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), TIME_OUT);
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.print(message);
            out.flush();
            inputStream = new BufferedInputStream(socket.getInputStream());
            String resultMsg = readInputStream(inputStream);
            String[] split = resultMsg.split("\\|");
            if (split.length >= MIN_LENGTH) {
                String resultStatus = split[RESULT_STATUS_LENGTH];
                if (resultStatus.equals(RESULT_STATUS)) {
                    int count = Integer.parseInt(split[MIN_LENGTH]);
                    log.info("发送报文：{} 返回多包数量为: {}", message, count);
                    for (int i = 0; i < count; i++) {
                        out.print(nextMessage);
                        out.flush();
                        resultMsg = readInputStream(inputStream);
                        log.info("发送多包循环数: {} 请求包：{}  结果 : {}", i, nextMessage, resultMsg);
                        list.add(resultMsg);
                    }
                } else {
                    list.add(resultMsg);
                }
            }
        } catch (IOException e) {
            log.info("host: {} ,port :{} 发送内容: {} ,异常: {}", host, port, message, e);
            throw new RuntimeException("服务繁忙");
        } finally {
            close(socket, inputStream, out);
        }
        return list;
    }


    private String readInputStream(BufferedInputStream paramBufferedInputStream) throws IOException {
        StringBuilder str = new StringBuilder();
        int i = paramBufferedInputStream.read();
        if (i == -1) {
            return null;
        }
        str.append((char) i);
        int j = paramBufferedInputStream.available();
        if (j > 0) {
            byte[] arrayOfByte = new byte[j];
            paramBufferedInputStream.read(arrayOfByte);
            str.append(new String(arrayOfByte, "GBK"));
        }
        return str.toString();
    }

    private void close(Socket socket, BufferedInputStream inputStream, PrintWriter out) {
        try {
            if (socket != null) {
                socket.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(100);
        try {
            for (int j = 0; j < 10; j++) {
                new Thread(() -> {
                    try {
                        countDownLatch.countDown();
                        for (int i = 0; i < 1; i++) {
                            SocketTest socketService = new SocketTest();
                            socketService.host = "10.253.48.83";
                            socketService.port = 13921;
                            String s = socketService.singlePackage("R|10.253.147.23|8888888|20044,0||WSWT|8000000442|111111|");
                            System.out.println(s);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }).start();
            }
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.book.developtest;

/**
 * @Author: hj
 * @DateTime: 2020/11/18 14:57
 * @Description:
 */
public class TestIdMaker {
    public static void main(String[] args) {
        String lockPriceId = "12345678";
        int infoCount = 1;
        for (int i = 0; i < 4; i++) {
            StringBuffer stringBuffer = new StringBuffer(lockPriceId);
            stringBuffer.append(String.format("%02d", infoCount));
            infoCount++;
            System.out.println("stringBuffer = " + stringBuffer.toString());
        }
    }
}

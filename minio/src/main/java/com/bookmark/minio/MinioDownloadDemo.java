package com.bookmark.minio;

import io.minio.MinioClient;
import io.minio.errors.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: hj
 * @DateTime: 2020/9/11 15:58
 * @Description:
 */
public class MinioDownloadDemo {
    public static void main(String[] args) throws InvalidPortException, InvalidEndpointException, IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException, InvalidExpiresRangeException {
        //1.初始化minio对象
        String endPoint = "http://47.111.240.51:9000";
        String accessKey = "admin";
        String secretKey = "12345678";
        String bucketName = "test";
        String objectName = "桌面壁纸test.jpg";
        MinioClient minioClient = new MinioClient(endPoint, accessKey, secretKey);
        InputStream downloadInS = minioClient.getObject(bucketName, objectName);
        File file = new File("D:\\documents\\" + objectName);
        FileUtils.copyInputStreamToFile(downloadInS, file);

        String url =  minioClient.presignedGetObject(bucketName,objectName,60*60*24);
        System.out.println("url = " + url);
    }
}

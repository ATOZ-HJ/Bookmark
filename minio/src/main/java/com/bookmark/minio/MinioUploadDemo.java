package com.bookmark.minio;

import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: hj
 * @DateTime: 2020/9/11 15:43
 * @Description:
 */
public class MinioUploadDemo {
    public static void main(String[] args) throws InvalidPortException, InvalidEndpointException, IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException, RegionConflictException {
        //1.初始化minio对象
        String endPoint = "http://47.111.240.51:9000";
        String accessKey = "admin";
        String secretKey = "12345678";
        String bucketName = "test";
        MinioClient minioClient = new MinioClient(endPoint, accessKey, secretKey);
        boolean isExist = minioClient.bucketExists(bucketName);
        if (isExist) {
            System.out.println("bucket is already exists");
        } else {
            minioClient.makeBucket(bucketName);
        }
        //通过文件路径上传
        String objectName = "桌面壁纸test.jpg";
        String filePath = "D:\\documents\\pics\\桌面壁纸.jpg";
        minioClient.putObject(bucketName, objectName, filePath, null);
        //通过流的方式上传
        FileInputStream fileInputStream = new FileInputStream(filePath);
        PutObjectOptions options = new PutObjectOptions(fileInputStream.available(), -1);
        options.setContentType("image/png");
        minioClient.putObject(bucketName, objectName, fileInputStream, options);

    }
}

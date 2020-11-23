package com.bookmark.pdf.service.impl;

import com.bookmark.pdf.PDFUtil;
import com.bookmark.pdf.pojo.User;
import com.bookmark.pdf.service.CommonService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: hj
 * @DateTime: 2020/11/23 15:43
 * @Description:
 */
@Service
public class CommonServiceImpl implements CommonService {
    @Override
    public ResponseEntity<?> export() {
        HttpHeaders headers = new HttpHeaders();

        /**
         * 数据导出(PDF 格式)
         */
        String fontPath = "templates/simsun.ttc";
        String ftlPath = "templates/user.ftl";
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User("name " + i, "passwd " + i));
        }

        Map<String, Object> dataMap = new HashMap<>(16);
        dataMap.put("list", userList);
        String htmlStr = PDFUtil.freemarkerRender(dataMap, ftlPath);
        byte[] pdfBytes = PDFUtil.createPDF(htmlStr,null);
        if (pdfBytes != null && pdfBytes.length > 0) {
            String fileName = System.currentTimeMillis() + (int) (Math.random() * 90000 + 10000) + ".pdf";
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(pdfBytes, headers, HttpStatus.OK);
        }

        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<String>("{ \"code\" : \"404\", \"message\" : \"not found\" }",
                headers, HttpStatus.NOT_FOUND);
    }
}

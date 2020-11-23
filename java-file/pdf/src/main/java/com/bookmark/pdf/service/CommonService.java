package com.bookmark.pdf.service;

import org.springframework.http.ResponseEntity;

/**
 * @Author: hj
 * @DateTime: 2020/11/23 15:43
 * @Description:
 */
public interface CommonService {

    /**
     * PDF 文件导出
     * @return
     */
    ResponseEntity<?> export();
}

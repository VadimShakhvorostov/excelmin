package com.example.excelmin.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface NumService {

    Integer getMinNum(String path, Integer n) throws IOException;
}

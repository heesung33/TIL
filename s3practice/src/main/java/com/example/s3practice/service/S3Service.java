package com.example.s3practice.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface S3Service {

    String upload(MultipartFile file) throws IOException;

    void delete(String objectName);

}

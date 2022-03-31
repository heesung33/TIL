package com.example.s3practice.controller;

import com.example.s3practice.dto.FileDto;
import com.example.s3practice.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @PostMapping("/upload")
    public void upload(@RequestPart("file")MultipartFile file) throws IOException {
        s3Service.upload(file);
    }

    @DeleteMapping("/remove")
    public void delete(@RequestBody FileDto.FileName request){
        s3Service.delete(request.getName());
    }
}

package com.example.s3practice.service;

import com.example.s3practice.entity.File;
import com.example.s3practice.entity.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final S3Service s3Service;
    private final FileRepository fileRepository;

    public void saveImageUrl(MultipartFile file) throws IOException {
        String imageUrl = s3Service.upload(file);

        fileRepository.save(File.builder()
                .imageUrl(imageUrl)
                .build());
    }
}

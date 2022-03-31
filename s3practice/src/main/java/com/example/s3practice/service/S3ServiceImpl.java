package com.example.s3practice.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.s3practice.entity.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {

    private final FileRepository fileRepository;
    private final AmazonS3 s3;

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.base_image_url}")
    private String baseImageUrl;

    @Override
    public String upload(MultipartFile file) throws IOException {
        if (file.isEmpty()) throw new RuntimeException();
        String originalFilename = file.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String randomName = UUID.randomUUID().toString();
        String filename = randomName + "." + ext;

        s3.putObject(new PutObjectRequest(bucket, "images/" + filename, file.getInputStream(), null)
                .withCannedAcl(CannedAccessControlList.AuthenticatedRead));

        return filename;
    }

    @Override
    public void delete(String objectName) {
        s3.deleteObject(bucket, objectName);
    }

}

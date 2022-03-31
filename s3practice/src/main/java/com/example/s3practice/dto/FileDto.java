package com.example.s3practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FileDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class FileName{
        private String name;
    }
}

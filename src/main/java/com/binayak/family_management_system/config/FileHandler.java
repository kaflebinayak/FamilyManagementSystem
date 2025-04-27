package com.binayak.family_management_system.config;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileHandler {

    private final String uploadDir = "D:/familymanagementsystem/";

    public String saveFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        Path directory = Paths.get(uploadDir);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        String filePath = uploadDir + file.getOriginalFilename();
        Path path = Paths.get(filePath);
        Files.write(path, file.getBytes());

        return filePath;
    }

    public byte[] loadFile(String filename) throws IOException {
        Path path = Paths.get(uploadDir + filename);
        return Files.readAllBytes(path);
    }

    public boolean deleteFile(String filename) throws IOException {
        Path path = Paths.get(uploadDir + filename);
        return Files.deleteIfExists(path);
    }
}

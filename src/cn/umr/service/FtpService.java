package cn.umr.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FtpService {
    boolean upload(MultipartFile fileUpload) throws IOException;
}

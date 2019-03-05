package cn.umr.service.impl;

import cn.umr.service.FtpService;
import cn.umr.util.FtpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author UMR丶晨哥
 * @version 1.0
 * @date 2018/12/15 18:24
 */
@Service
public class FtpServiceImpl implements FtpService {
    @Value("${ftpclient.host}")
    private String host;
    @Value("${ftpclient.port}")
    private int port;
    @Value("${ftpclient.username}")
    private String username;
    @Value("${ftpclient.password}")
    private String password;
    @Value("${ftpclient.basepath}")
    private String basePath;
    @Value("${ftpclient.filepath}")
    private String filePath;
    @Override
    public boolean upload(MultipartFile fileUpload) throws IOException {
        String filename = UUID.randomUUID() + fileUpload.getOriginalFilename().substring(fileUpload.getOriginalFilename().lastIndexOf("."));
        InputStream inputStream = fileUpload.getInputStream();
        System.out.println("filename = " + filename);
//        boolean result = FtpUtil.uploadFile("192.168.146.128",21,"ftpuser",
//                "123","/home/ftpuser","/",filename,fileUpload.getInputStream());
        boolean result = FtpUtil.uploadFile(host,port,username,password,basePath,filePath,filename,inputStream);
        return result;
    }
}

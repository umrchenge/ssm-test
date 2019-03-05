package cn.umr.controller;

import cn.umr.service.FtpService;
import cn.umr.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author UMR丶晨哥
 * @version 1.0
 * @date 2018/12/15 16:21
 */
//@RequestMapping("/ftp")
@Controller
public class FtpFileUploadController {
    @Autowired
    private FtpService ftpService;
    @RequestMapping("/upload")
    public String upload(MultipartFile fileUpload)throws Exception{
        boolean upload = ftpService.upload(fileUpload);
        if (upload) {
            return "success";
        }else{
        return "error";
        }
    }
}

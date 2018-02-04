package com.taotao.route;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Auther: zhaomeng
 * @Description:
 * @Date: Create in 22:39 2018/2/3
 * @Modified By:
 */
@Component(value = "fileUploadToDisk")
public class FileUploadToDisk implements FileUpload {
    @Override
    public Map<String, Object> fileUpload(MultipartFile uploadFile) {
        System.out.println("图片保存到磁盘上");
        return null;
    }
}

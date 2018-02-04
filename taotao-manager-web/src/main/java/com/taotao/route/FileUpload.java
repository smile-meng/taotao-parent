package com.taotao.route;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Auther: zhaomeng
 * @Description: 路由类的编写
 * @Date: Create in 21:29 2018/2/3
 * @Modified By:
 */
public interface FileUpload {

    /**
     * 上传文件的方法
     * @param uploadFile
     * @return
     */
    public abstract Map<String,Object> fileUpload(MultipartFile uploadFile);
}

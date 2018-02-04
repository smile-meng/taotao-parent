package com.taotao.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.route.FileUpload;
import com.taotao.route.FileUploadRoute;
import com.taotao.route.FileUploadToFastDFS;
import com.taotao.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhaomeng
 * @Description: 图片上传Controller
 * @Date: Create in 16:56 2018/2/3
 * @Modified By:
 */
@Controller
public class PictureController {

//    @Value("${IMAGE_SERVER_URL}")
//    private String IMAGE_SERVER_URL;

    @Autowired
    private FileUploadRoute fileUploadRoute;

    //,produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8"

    @RequestMapping(value = "/pic/upload")
    @ResponseBody
    public Map<String, Object> fileUpload(MultipartFile uploadFile){

        return fileUploadRoute.fileUpload(uploadFile);
    }
}

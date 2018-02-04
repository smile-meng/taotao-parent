package com.taotao.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Auther: zhaomeng
 * @Description:
 * @Date: Create in 23:06 2018/2/3
 * @Modified By:
 */
public class FileUploadRoute {

    @Autowired
    private Map<String,FileUpload> fileUploadMap;

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    /**
     * fileUploadToFastDFS
     * fileUploadToDisk
     */
    private FileUpload getFileUpload(){
        return fileUploadMap.get("fileUploadTo"+type);
    }

    public Map<String,Object> fileUpload(MultipartFile multipartFile){
        return getFileUpload().fileUpload(multipartFile);
    }
}

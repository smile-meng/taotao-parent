package com.taotao.route;

import com.taotao.common.utils.JsonUtils;
import com.taotao.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhaomeng
 * @Description: 路由类的实现到FastDfs
 * @Date: Create in 21:32 2018/2/3
 * @Modified By:
 */
@Component(value = "fileUploadToFastDFS")
public class FileUploadToFastDFS implements FileUpload {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @Override
    public Map<String, Object> fileUpload(MultipartFile uploadFile) {
        try {
            //接收上传的文件
            byte[] content = uploadFile.getBytes();
            //取文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //把文件内容上传到图片服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/fast_dfs.conf");
            String url = fastDFSClient.uploadFile(content, ext);
            //从配置文件中取图片服务器的url
            //创建返回结果对象
            Map result = new HashMap<>();
            result.put("error",0);
            result.put("url",IMAGE_SERVER_URL+url);
            //返回结果
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap<>();
            result.put("error",1);
            result.put("message","图片上传失败");
            return result;
        }

    }
}

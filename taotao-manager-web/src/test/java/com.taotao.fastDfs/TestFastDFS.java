package com.taotao.fastDfs;

import com.taotao.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * @Auther: zhaomeng
 * @Description: 图片服务器的测试
 * @Date: Create in 15:24 2018/2/3
 * @Modified By:
 */
public class TestFastDFS {

    @Test
    public void testFastDFS() throws Exception{
        //1.创建一个配置文件fast_dfs.conf，配置文件的内容就是指定TrackerServer的地址
        //2.加载配置文件
        ClientGlobal.init("D:\\develop\\Idea_workspace\\taotao-parent\\taotao-manager-web\\src\\main\\resources\\resource\\fast_dfs.conf");
        //3.创建一个TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //4.通过TrackerClient对象获得TrackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //5.创建一个StorageServer引用，null就可以
        StorageServer storageServer = null;
        //6.创建一个StorageClient对象。两个参数TrackerServer、StorageServer
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        //7.使用StoreageClient对象上传文件。
        //参数1：文件名，参数2：扩展名，不能保护"." 参数3：文件的元数据
        String[] strings = storageClient.upload_appender_file("E:\\zhaomengmeng\\timg.jpg", "jpg", null);
        for(String string:strings){
            System.out.println(string);
        }
    }

    @Test
    public void testFastDfsClient() throws Exception{
        FastDFSClient fastDFSClient = new FastDFSClient("D:\\develop\\Idea_workspace\\taotao-parent\\taotao-manager-web\\src\\main\\resources\\resource\\fast_dfs.conf");
        String file = fastDFSClient.uploadFile("E:\\zhaomengmeng\\4d638e20716ec2088a00034c.jpg");
        System.out.println(file);
    }

}

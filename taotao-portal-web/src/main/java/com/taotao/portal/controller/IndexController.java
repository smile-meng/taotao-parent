package com.taotao.portal.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;
import com.taotao.portal.pojo.Ad1Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhaomeng
 * @Description: 首页展示Controller
 * @Date: Create in 18:37 2018/2/4
 * @Modified By:
 */
@Controller
public class IndexController {

    @Autowired
    private ContentService contentService;

    @Value("${AD1_CONTENT_CID}")
    private Long AD1_CID;

    @Value("${AD1_WIDTH}")
    private String AD1_WIDTH;

    @Value("${AD1_WIDTH_B}")
    private String AD1_WIDTH_B;

    @Value("${AD1_HEIGHT}")
    private String AD1_HEIGHT;

    @Value("${AD1_HEIGHT_B}")
    private String AD1_HEIGHT_B;


    @RequestMapping("/index")
    public String showIndex(Model model){
        //取轮播图的信息
        List<TbContent> list = contentService.getContentList(AD1_CID);
        //转换为Ad1NodeList
        List<Ad1Node> ad1NodeList = new ArrayList<>();
        for (TbContent content:list){
            Ad1Node ad1Node = new Ad1Node();
            ad1Node.setAlt(content.getTitle());
            ad1Node.setHeight(AD1_HEIGHT);
            ad1Node.setHeightB(AD1_HEIGHT_B);
            ad1Node.setWidth(AD1_WIDTH);
            ad1Node.setWidthB(AD1_WIDTH_B);
            ad1Node.setHref(content.getUrl());
            ad1Node.setSrc(content.getPic());
            ad1Node.setSrcB(content.getPic2());
            ad1NodeList.add(ad1Node);
        }
        //把数据传回页面
        model.addAttribute("ad1", JsonUtils.objectToJson(ad1NodeList));
        return "index";
    }
}

package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: zhaomeng
 * @Description: 内容管理的controller
 * @Date: Create in 0:12 2018/2/5
 * @Modified By:
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentList(Long categoryId,Integer page, Integer rows){
        EasyUIDataGridResult result = contentService.getContentList(categoryId, page, rows);
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult addContent(TbContent content){
        TaotaoResult result = contentService.addContent(content);
        return result;
    }
    @RequestMapping("/edit")
    @ResponseBody
    public TaotaoResult editContent(TbContent content){
        TaotaoResult result = contentService.editContent(content);
        return result;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteContent(String ids){
        TaotaoResult result = contentService.deleteContent(ids);
        return result;
    }

}

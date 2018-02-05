package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: zhaomeng
 * @Description: 内容分类管理的Controller
 * @Date: Create in 20:11 2018/2/4
 * @Modified By:
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0")Long parentId){
        List<EasyUITreeNode> easyUITreeNodes = contentCategoryService.getContentCategoryList(parentId);
        return easyUITreeNodes;
    }

    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult createCategory(Long parentId,String name){
        TaotaoResult result = contentCategoryService.addContentCategory(parentId, name);
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateCategory(Long id,String name){
        TaotaoResult result = contentCategoryService.updateContentCategory(id,name);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteCategory(Long id){
        TaotaoResult result = contentCategoryService.deleteContentCategory(id);
        return result;
    }



}

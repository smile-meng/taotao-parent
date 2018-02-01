package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: zhaomeng
 * @Description: 商品管理
 * @Date: Create in 10:00 2018/2/1
 * @Modified By:
 */
@Controller
public class ItemController {

    @Autowired(required = false)
    private ItemService itemService;

    @RequestMapping("/item/list")
    @ResponseBody
    public  EasyUIDataGridResult getItemList(Integer page,Integer rows){
        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }
}

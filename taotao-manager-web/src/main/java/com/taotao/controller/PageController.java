package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zhaomeng
 * @Description: 页面跳转controller
 * @Date: Create in 15:17 2018/1/31
 * @Modified By:
 */
@Controller
public class PageController {

    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}

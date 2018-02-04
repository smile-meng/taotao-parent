package com.taotao.mybatis.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: zhaomeng
 * @Description: 分页测试类
 * @Date: Create in 19:27 2018/1/31
 * @Modified By:
 */
public class TestPageHelper {

//    @Test
//    public void testPageHelper() throws Exception{
//        //初始化spring容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//        //从容器中获得mapper代理对象
//        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
//
//        //执行查询
//        TbItemExample example = new TbItemExample();
//        //分页处理
//        PageHelper.startPage(1,30);
//        List<TbItem> tbItems = itemMapper.selectByExample(example);
//        //取分页信息
//        System.out.println("结果集中的记录数："+tbItems.size());
//        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
//        System.out.println("总记录数："+pageInfo.getTotal());
//        System.out.println("总页数："+pageInfo.getPages());
//
//
//    }
}

package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: zhaomeng
 * @Description: 商品列表service的实现类
 * @Date: Create in 13:57 2018/1/31
 * @Modified By:
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {

        //分页处理
        PageHelper.startPage(page,rows);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //创建返回结果对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        //取总记录数
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public TaotaoResult addItem(TbItem item, String desc) {
        //1.生成商品id
        long itemId = IDUtils.genItemId();
        //2.补全TbItem对象的属性
        item.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        //3.向商品表插入数据
        itemMapper.insert(item);
        //4.创建一个TbItemDesc对象
        TbItemDesc itemDesc = new TbItemDesc();
        //5.补全TbItemDesc的属性
        itemDesc.setItemId(itemId);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        itemDesc.setItemDesc(desc);
        //6.向商品描述表插入数据
        itemDescMapper.insert(itemDesc);
        //7.TaoTaoResult.ok()
        return TaotaoResult.ok();
    }


}

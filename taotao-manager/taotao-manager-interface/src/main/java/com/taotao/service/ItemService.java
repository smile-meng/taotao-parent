package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

import java.util.List;

/**
 * @Auther: zhaomeng
 * @Description: 商品列表service
 * @Date: Create in 13:56 2018/1/31
 * @Modified By:
 */
public interface ItemService {

    EasyUIDataGridResult getItemList(int page,int rows);

    TaotaoResult addItem(TbItem item,String desc);


}

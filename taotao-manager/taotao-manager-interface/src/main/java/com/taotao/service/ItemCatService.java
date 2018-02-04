package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * @Auther: zhaomeng
 * @Description: 商品类目的service接口
 * @Date: Create in 17:17 2018/2/2
 * @Modified By:
 */
public interface ItemCatService {

    public List<EasyUITreeNode> getCatList(long parentId);
}

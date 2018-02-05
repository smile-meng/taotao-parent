package com.taotao.content.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * @Auther: zhaomeng
 * @Description: 内容分类管理的service接口
 * @Date: Create in 19:26 2018/2/4
 * @Modified By:
 */
public interface ContentCategoryService {

    List<EasyUITreeNode> getContentCategoryList(long parentId);

    TaotaoResult addContentCategory(long parentId,String name);

    TaotaoResult updateContentCategory(long id,String name);

    TaotaoResult deleteContentCategory(long id);
}

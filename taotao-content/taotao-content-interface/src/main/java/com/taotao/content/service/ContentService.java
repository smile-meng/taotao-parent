package com.taotao.content.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * @Auther: zhaomeng
 * @Description: 内容管理的Service的接口
 * @Date: Create in 0:10 2018/2/5
 * @Modified By:
 */
public interface ContentService {

    EasyUIDataGridResult getContentList(long categoryId,int page, int rows);

    List<TbContent> getContentList(long cid);

    TaotaoResult addContent(TbContent content);

    TaotaoResult editContent(TbContent content);

    TaotaoResult deleteContent(String ids);

}

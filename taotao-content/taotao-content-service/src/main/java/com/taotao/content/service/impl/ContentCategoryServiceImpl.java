package com.taotao.content.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: zhaomeng
 * @Description: 内容分类管理的service
 * @Date: Create in 19:33 2018/2/4
 * @Modified By:
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EasyUITreeNode> getContentCategoryList(long parentId) {

        // 1、取查询参数id，parentId
        // 2、根据parentId查询tb_content_category，查询子节点列表。
        TbContentCategoryExample example = new TbContentCategoryExample();
        //设置查询条件
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //3.得到List<TbContentCategory>
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        //4.将列表转换成List<EasyUITreeNode>
        List<EasyUITreeNode> easyUITreeNodes = new ArrayList<>();
        //5.遍历List<TbContentCategory>，添加到List<EasyUITreeNode>
        for (TbContentCategory contentCategory:list){
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(contentCategory.getId());
            easyUITreeNode.setText(contentCategory.getName());
            easyUITreeNode.setState(contentCategory.getIsParent()?"closed":"open");
            //添加到列表
            easyUITreeNodes.add(easyUITreeNode);
        }
        return easyUITreeNodes;
    }

    @Override
    public TaotaoResult addContentCategory(long parentId, String name) {
        //1.接收两个参数：parentId,name
        //2.向tb_content_category表中插入数据
        //a)创建一个tb_content_category对象
        TbContentCategory contentCategory = new TbContentCategory();
        //b)补全TbContentCategory对象的属性
        contentCategory.setIsParent(false);
        contentCategory.setName(name);
        contentCategory.setParentId(parentId);
        //排列序号，表示同级类目的展现次序，如数值相等则按名称次序排序，取值范围：大于零的整数
        contentCategory.setSortOrder(1);
        //状态，可选值：1（正常），2（删除）
        contentCategory.setStatus(1);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        //c)向tb_content_category表中插入数据
        contentCategoryMapper.insert(contentCategory);
        //3.判断父节点的isparent是否为true,不是true需要改为true
        TbContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentId);
        if(!parentNode.getIsParent()){
            parentNode.setIsParent(true);
            //更新父节点
            contentCategoryMapper.updateByPrimaryKey(parentNode);
        }
        //4.需要主键返回
        //5.返回TaotaoResult，其中包装TbContentCategory对象
        return TaotaoResult.ok(contentCategory);
    }

    @Override
    public TaotaoResult updateContentCategory(long id, String name) {
        TbContentCategory category = contentCategoryMapper.selectByPrimaryKey(id);
        category.setName(name);
        contentCategoryMapper.updateByPrimaryKey(category);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult deleteContentCategory(long id) {
        //根据id查询该分类
        TbContentCategory category = contentCategoryMapper.selectByPrimaryKey(id);
        //判断该分类是否是父节点
        if(category.getIsParent()){
            //该节点是父节点
            TbContentCategoryExample example = new TbContentCategoryExample();
            TbContentCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(id);
            //根据父节点条件查询，子节点内容
            List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
            //遍历子节点内容
            for (TbContentCategory category1:list){
                //判断子节点是否是一个父节点
                if(category1.getIsParent()){
                    //是父节点，继续调用本方法，递归
                    deleteContentCategory(category1.getId());
                }else {
                    //如果子节点不是父节点，直接根据id删除本分类
                    contentCategoryMapper.deleteByPrimaryKey(category1.getId());
                }
            }
            //当删完这个父节点中的父节点和子节点，将该父节点设置成子节点，
            category.setIsParent(false);

            //当删除父节点中的所有节点
            TbContentCategoryExample example2 = new TbContentCategoryExample();
            TbContentCategoryExample.Criteria criteria2 = example2.createCriteria();
            criteria2.andParentIdEqualTo(category.getParentId());
            //根据该节点的父节点来查询，该节点的兄弟节点是否存在
            List<TbContentCategory> list2 = contentCategoryMapper.selectByExample(example2);
            //如果该节点没有兄弟节点
            if(list2.size()==1){
                //将该节点的父节点改为子节点
                TbContentCategory category3 = contentCategoryMapper.selectByPrimaryKey(category.getParentId());
                category3.setIsParent(false);
                contentCategoryMapper.updateByPrimaryKey(category3);
            }
            //然后进行删除该节点
            contentCategoryMapper.deleteByPrimaryKey(id);
        }else {
            TbContentCategoryExample example2 = new TbContentCategoryExample();
            TbContentCategoryExample.Criteria criteria2 = example2.createCriteria();
            criteria2.andParentIdEqualTo(category.getParentId());
            //根据该节点的父节点进行查询，该节点的兄弟节点是否存在
            List<TbContentCategory> list2 = contentCategoryMapper.selectByExample(example2);
            //如果该节点没有兄弟节点
            if(list2.size()==1){
                //将该节点的父节点改为子节点
                TbContentCategory category3 = contentCategoryMapper.selectByPrimaryKey(category.getParentId());
                category3.setIsParent(false);
                contentCategoryMapper.updateByPrimaryKey(category3);
            }
            //最后进行删除改节点
            contentCategoryMapper.deleteByPrimaryKey(id);
        }
        return TaotaoResult.ok();
    }
}

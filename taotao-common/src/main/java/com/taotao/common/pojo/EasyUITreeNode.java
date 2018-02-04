package com.taotao.common.pojo;

import java.io.Serializable;

/**
 * @Auther: zhaomeng
 * @Description: tree的节点信息
 * @Date: Create in 17:14 2018/2/2
 * @Modified By:
 */
public class EasyUITreeNode implements Serializable{

    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

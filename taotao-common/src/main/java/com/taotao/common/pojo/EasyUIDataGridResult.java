package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: zhaomeng
 * @Description: 响应json数据
 * @Date: Create in 17:02 2018/1/31
 * @Modified By:
 */
public class EasyUIDataGridResult implements Serializable {

    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}

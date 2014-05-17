package com.zorbit.platform.core;

import java.io.Serializable;

/**
 * 所有查询对象都必须继承的类
 * @since 2013年8月11日 下午7:12:55
 * @author Jamin Zou
 */
public class BaseQuery implements Serializable {
    
    private static final long serialVersionUID = -5158325889474364884L;
    
    /**
     * 排序字段
     */
    private String orderby;
    
    /**
     * 排序方式
     */
    private String order;

    
    public String getOrderby() {
        return orderby;
    }

    
    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    
    public String getOrder() {
        return order;
    }

    
    public void setOrder(String order) {
        this.order = order;
    }

    
    
    
    
}

package com.zorbit.platform.core;

/**
 * dao基类
 * @param <M> po
 * @since 2013年8月17日 上午11:31:38
 * @author Jamin Zou
 */
public interface IBaseDao<M extends IdEntity> {
    
    /**
     * 新增
     * @param m
     * @author Jamin Zou
     */
    public void persist(M m);
    
    /**
     * 查找
     * @param id
     * @return
     * @author Jamin Zou
     */
    public M find(String id);
    
    /**
     * 删除
     * @param id
     * @author Jamin Zou
     */
    public void remove(String id);
    
    /**
     * 跟新
     * @param m
     * @author Jamin Zou
     */
    public void merge(M m);
}

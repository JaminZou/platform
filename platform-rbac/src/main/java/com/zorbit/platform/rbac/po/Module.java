package com.zorbit.platform.rbac.po;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 系统模块
 * 
 * @since 2013年10月13日 上午10:57:31
 * @author Jamin Zou
 */
@Entity
@Table(name="tc_module")
@PrimaryKeyJoinColumn(name="uid")
public class Module extends Resource {

    /**
     * 
     */
    private static final long serialVersionUID = 7132939637454995695L;

    private String curl;
    private String cparams;
    /**
     * 打开方式
     */
    private String ctarget;
    /**
     * 图标
     */
    private String cicon;
    
    public String getCurl() {
        return curl;
    }
    
    public void setCurl(String curl) {
        this.curl = curl;
    }
    
    public String getCparams() {
        return cparams;
    }
    
    public void setCparams(String cparams) {
        this.cparams = cparams;
    }

    
    /**
     * 获取 图标
     * @return cicon
     */
    public String getCicon() {
        return cicon;
    }

    
    /**
     * 设置 图标
     * @param cicon 图标
     */
    public void setCicon(String cicon) {
        this.cicon = cicon;
    }

    
    /**
     * 获取 打开方式
     * @return ctarget
     */
    public String getCtarget() {
        return ctarget;
    }

    
    /**
     * 设置 打开方式
     * @param ctarget 打开方式
     */
    public void setCtarget(String ctarget) {
        this.ctarget = ctarget;
    }
    
    
}

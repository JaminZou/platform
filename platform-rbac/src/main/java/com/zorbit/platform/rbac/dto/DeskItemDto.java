package com.zorbit.platform.rbac.dto;

import java.io.Serializable;

public class DeskItemDto implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2610080245037915959L;
    /**名称*/
    public String name;
    /**id*/
    public String id;
    /**任务栏中显示的图标，bs3class图标，或者系统自定class*/
    public String itemIcon;
    /**点击后访问的url*/
    public String url;
    /**自定义样式*/
    public String classz;
    /**图片*/
    public String icon;
    
    /**回调行数名*/
    public String loaded;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getItemIcon() {
        return itemIcon;
    }
    
    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getClassz() {
        return classz;
    }
    
    public void setClassz(String classz) {
        this.classz = classz;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public String getLoaded() {
        return loaded;
    }
    
    public void setLoaded(String loaded) {
        this.loaded = loaded;
    }
    
}

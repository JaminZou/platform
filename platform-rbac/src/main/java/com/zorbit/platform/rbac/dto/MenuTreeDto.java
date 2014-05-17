package com.zorbit.platform.rbac.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MenuTreeDto implements Serializable {

    private static final long serialVersionUID = 8732654142121573669L;
    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 显示图标
     */
    private String icon;
    /**
     * 父菜单id
     */
    private String parentid;
    /**
     * 是否为叶子节点
     * 1-是
     * 0-否
     */
    private String leaf;
    
    /**
     * 类型，ui用
     * 当leaf=1时，type=item
     * 当leaf！=1时 type=folder
     */
    private String type;
    /**
     * url
     * 一般只有叶子菜单会有值
     */
    private String url;
    
    /**
     * 排序号
     */
    private Integer ordernum;
    /**
     * 菜单等级
     * 数据库中，deskitem 的 level为0
     */
    private String level;
    /**
     * 菜单类型，为手机应用，还是桌面应用，
     *       mobile  pc
     */
    private String apptype;
    /**
     * 子菜单
     */
    private List<MenuTreeDto> children = new ArrayList<MenuTreeDto>();

    /**
     * 弹出目标，比如iframename，_blank
     */
    private String target;
    
    
    /**
     * 获取 id
     * @return id
     */
    public String getId() {
        return id;
    }


    
    /**
     * 设置 id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }


    
    /**
     * 获取 名称
     * @return name
     */
    public String getName() {
        return name;
    }


    
    /**
     * 设置 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }


    
    /**
     * 获取 显示图标
     * @return icon
     */
    public String getIcon() {
        return icon;
    }


    
    /**
     * 设置 显示图标
     * @param icon 显示图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }


    
    /**
     * 获取 父菜单id
     * @return parentid
     */
    public String getParentid() {
        return parentid;
    }

    
    /**
     * 设置 父菜单id
     * @param parentid 父菜单id
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    
    /**
     * 获取 是否为叶子节点      1-是      0-否
     * @return leaf
     */
    public String getLeaf() {
        return leaf;
    }

    /**
     * 设置 是否为叶子节点      1-是      0-否
     * @param leaf 是否为叶子节点      1-是      0-否
     */
    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }



    /**
     * 获取 url      一般只有叶子菜单会有值
     * @return url
     */
    public String getUrl() {
        return url;
    }


    
    /**
     * 设置 url      一般只有叶子菜单会有值
     * @param url url      一般只有叶子菜单会有值
     */
    public void setUrl(String url) {
        this.url = url;
    }


    
    /**
     * 获取 菜单等级      数据库中，deskitem 的 level为0
     * @return level
     */
    public String getLevel() {
        return level;
    }


    
    /**
     * 设置 菜单等级      数据库中，deskitem 的 level为0
     * @param level 菜单等级      数据库中，deskitem 的 level为0
     */
    public void setLevel(String level) {
        this.level = level;
    }


    
    /**
     * 获取 菜单类型，为手机应用，还是桌面应用，            mobile  pc
     * @return apptype
     */
    public String getApptype() {
        return apptype;
    }


    
    /**
     * 设置 菜单类型，为手机应用，还是桌面应用，            mobile  pc
     * @param apptype 菜单类型，为手机应用，还是桌面应用，            mobile  pc
     */
    public void setApptype(String apptype) {
        this.apptype = apptype;
    }


    
    /**
     * 获取 子菜单
     * @return children
     */
    public List<MenuTreeDto> getChildren() {
        return children;
    }


    
    /**
     * 设置 子菜单
     * @param children 子菜单
     */
    public void setChildren(List<MenuTreeDto> children) {
        this.children = children;
    }


    /**
     * 获取 排序号
     * @return ordernum
     */
    public Integer getOrdernum() {
        return ordernum;
    }

    
    /**
     * 设置 排序号
     * @param ordernum 排序号
     */
    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }



    
    /**
     * 获取 弹出目标，比如iframename，_blank
     * @return target
     */
    public String getTarget() {
        return target;
    }



    
    /**
     * 设置 弹出目标，比如iframename，_blank
     * @param target 弹出目标，比如iframename，_blank
     */
    public void setTarget(String target) {
        this.target = target;
    }



    
    /**
     * 获取 类型，ui用      当leaf=1时，type=item      当leaf！=1时 type=folder
     * @return type
     */
    public String getType() {
        return type;
    }



    
    /**
     * 设置 类型，ui用      当leaf=1时，type=item      当leaf！=1时 type=folder
     * @param type 类型，ui用      当leaf=1时，type=item      当leaf！=1时 type=folder
     */
    public void setType(String type) {
        this.type = type;
    }

    
}

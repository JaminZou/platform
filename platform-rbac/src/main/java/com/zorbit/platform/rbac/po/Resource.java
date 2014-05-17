package com.zorbit.platform.rbac.po;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.zorbit.platform.core.IdEntity;

/**
 * 资源父类
 * 
 * @since 2013年10月13日 上午10:57:54
 * @author Jamin Zou
 */
@Entity
@Table(name="tc_resource")
@Inheritance(strategy=InheritanceType.JOINED) 
public class Resource extends IdEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -3320266018436662373L;
    private String cname;
    private String ccode;
    private String ctype;
    private String ccodepath;
    private String uparentid;
    private Integer ilevel;
    private Integer ileaf;
    
    public String getCname() {
        return cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    public String getCcode() {
        return ccode;
    }
    
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    public String getCtype() {
        return ctype;
    }
    
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    
    public String getCcodepath() {
        return ccodepath;
    }

    
    public void setCcodepath(String ccodepath) {
        this.ccodepath = ccodepath;
    }

    
    public String getUparentid() {
        return uparentid;
    }

    
    public void setUparentid(String uparentid) {
        this.uparentid = uparentid;
    }

    public Integer getIlevel() {
        return ilevel;
    }

    
    public void setIlevel(Integer ilevel) {
        this.ilevel = ilevel;
    }

    
    public Integer getIleaf() {
        return ileaf;
    }

    
    public void setIleaf(Integer ileaf) {
        this.ileaf = ileaf;
    }
    
    public enum ResourceType {

      MENU("菜单", 1);

      // 成员变量

      private String name;

      private int index;

      // 构造方法

      private ResourceType(String name, int index) {

      this.name = name;

      this.index = index;

      }

      // 普通方法

      public static String getName(int index) {

          for (ResourceType c : ResourceType.values()) {
    
              if (c.getIndex() == index) {
        
              return c.name;
        
              }
    
          }
    
          return null;

      }

      // get set 方法

      public String getName() {

          return name;

      }

      public void setName(String name) {

          this.name = name;

      }

      public int getIndex() {

          return index;

      }

      public void setIndex(int index) {

          this.index = index;

      }

    }

    
}

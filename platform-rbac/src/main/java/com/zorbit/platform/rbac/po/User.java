package com.zorbit.platform.rbac.po;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zorbit.platform.core.IdEntity;

@Entity
@Table(name="tc_user")
public class User extends IdEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -172420716787668314L;
    
    private String cname;
    
    private String cloginname;
    
    private String cpassword;
    
    private String upersonid;
    
    public String getCname() {
        return cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    public String getCloginname() {
        return cloginname;
    }
    
    public void setCloginname(String cloginname) {
        this.cloginname = cloginname;
    }
    
    public String getCpassword() {
        return cpassword;
    }
    
    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    
    public String getUpersonid() {
        return upersonid;
    }

    
    public void setUpersonid(String upersonid) {
        this.upersonid = upersonid;
    }
    
    
    
}

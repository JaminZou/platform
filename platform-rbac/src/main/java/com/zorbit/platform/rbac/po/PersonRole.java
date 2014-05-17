package com.zorbit.platform.rbac.po;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zorbit.platform.core.IdEntity;

@Entity
@Table(name="tc_person_role")
public class PersonRole extends IdEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -2230509136005758475L;
    private String upersonid;
    private String uroleid;
    
    
    
    public String getUpersonid() {
        return upersonid;
    }

    
    public void setUpersonid(String upersonid) {
        this.upersonid = upersonid;
    }

    public String getUroleid() {
        return uroleid;
    }
    
    public void setUroleid(String uroleid) {
        this.uroleid = uroleid;
    }
    
}

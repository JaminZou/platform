package com.zorbit.platform.rbac.po;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zorbit.platform.core.IdEntity;

@Entity
@Table(name="tc_privilege")
public class Privilege extends IdEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -6882482317592679360L;
    
    private String uresourceid;
    
    private String uroleid;

    
    public String getUresourceid() {
        return uresourceid;
    }

    
    public void setUresourceid(String uresourceid) {
        this.uresourceid = uresourceid;
    }

    
    public String getUroleid() {
        return uroleid;
    }

    
    public void setUroleid(String uroleid) {
        this.uroleid = uroleid;
    }
    
   
    
    
}

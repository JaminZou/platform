package com.zorbit.platform.rbac.po;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zorbit.platform.core.IdEntity;

@Entity
@Table(name="tc_role")
public class Role extends IdEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -7634750393176319259L;
    
    private String cname;

    
    public String getCname() {
        return cname;
    }

    
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    
}

package com.zorbit.platform.organization.po;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.zorbit.platform.core.IdEntity;

@Entity
@Table(name = "tc_party")
@Inheritance(strategy=InheritanceType.JOINED)  
public class Party extends IdEntity {
    
    private static final long serialVersionUID = -1437299224001611997L;
    
    private String cname;
    
    public String getCname() {
        return cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }
    
}

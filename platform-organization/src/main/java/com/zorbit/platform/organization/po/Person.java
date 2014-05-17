package com.zorbit.platform.organization.po;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tc_person")
@PrimaryKeyJoinColumn(name="uid")
public class Person extends Party {

    private static final long serialVersionUID = 7510841716524320122L;
    /**
     * 年龄
     */
    private Integer iage;
    
    public Integer getIage() {
        return iage;
    }
    
    public void setIage(Integer iage) {
        this.iage = iage;
    }
    
    
    
}

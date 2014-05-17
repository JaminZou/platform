package com.zorbit.platform.rbac.po;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zorbit.platform.core.IdEntity;
/**
 * 用户和组织机构中关联person为人或者岗位
 * @since 2014年4月8日 下午8:30:07
 * @author Jamin Zou
 */
@Entity
@Table(name="tc_user_person")
public class UserPerson extends IdEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -1268756809946324677L;
    private String uuserid;
    private String upersonid;
    
    public String getUuserid() {
        return uuserid;
    }
    
    public void setUuserid(String uuserid) {
        this.uuserid = uuserid;
    }
    
    public String getUpersonid() {
        return upersonid;
    }
    
    public void setUpersonid(String upersonid) {
        this.upersonid = upersonid;
    }
    
    
}

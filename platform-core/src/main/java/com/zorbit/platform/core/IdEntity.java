package com.zorbit.platform.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
/**
 * 所有entity都必须继承的类
 * @author jamin Zou
 *
 */
@MappedSuperclass
public class IdEntity implements Idable<String>,Orderable,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3409550174936742696L;
	@Id
	@GenericGenerator(name = "uuidgenerator", strategy = "uuid")
	@GeneratedValue(generator = "uuidgenerator")
	private String uid;

	@Column
	private Long nordernum;

	
    public String getUid() {
        return uid;
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }

    @Transient
	public boolean isNew() {
		return this.uid == null||"".equals(this.uid.trim());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		IdEntity other = (IdEntity) obj;
		if (uid == null) {
			if (other.uid != null) {
				return false;
			}
		} else if (!uid.equals(other.uid)) {
			return false;
		}
		return true;
	}

    @Override
    public Long getNordernum() {
        return this.nordernum;
    }

    
    /**
     * 设置 排序号
     * @param nordernum 排序
     */
    public void setNordernum(Long nordernum) {
        this.nordernum = nordernum;
    }

	
}

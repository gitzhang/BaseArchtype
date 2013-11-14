package com.trgis.hkic.sms.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.ImmutableList;

/**
 * @author 张谦
 * 
 */
@Entity
@Table(name="sms_role")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1998962728460227983L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "permissions", length = 255)
	private String permissions;

	public Role() {
	}

	public Role(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Transient
	public Collection<String> getPermissionList() {
		return ImmutableList.copyOf(StringUtils.split(permissions, ","));
	}

}

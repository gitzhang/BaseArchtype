package com.trgis.hkic.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.trgis.hkic.sms.entity.User;

/**
 * 针对于读操作，支持定义方法级别查询   Method Query  
 * 
 * findBy*******EntityProperty
 * 
 * And                     
 * Or
 * Between
 * LessThan
 * GreaterThan
 * IsNull
 * IsNotNull，NotNull
 * Like
 * NotLike
 * OrderBy
 * Not
 * In
 * NotIn
 * 
 * 
 * @author 张谦
 *
 */
public interface UserDao extends JpaRepository<User, String>,
		JpaSpecificationExecutor<User> {

	/**
	 * SpringJPA 针对方法级别的查询  无需具体实现
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

	public List<User> findByUsernameAndName(String username, String name);
	
}

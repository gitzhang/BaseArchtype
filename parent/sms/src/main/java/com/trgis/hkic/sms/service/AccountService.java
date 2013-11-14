package com.trgis.hkic.sms.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.trgis.hkic.sms.entity.User;

/**
 * 用户账户服务接口
 * 
 * 
 * @author 张谦
 * 
 */
public interface AccountService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	
	public static final String DISABLED = "disabled";

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public void addUserAccount(User user);

	/**
	 * Method Query
	 * @param username
	 * @return
	 */
	public User findUserByLoginName(String username);
	
	/**
	 * Criteria Query
	 * @param username
	 * @return
	 */
	public User findUser(String username);

	/**
	 * 利用MethodQuery 查询所有用户
	 * @return
	 */
	public List<User> findAllUsers();
	
	/**
	 * 分页查询
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<User> findUser(Integer page,Integer size);

	public User getUser(Long id);

	public void saveUser(User userEntity);

	public List<User> searchUser(String loginName, String name);
}

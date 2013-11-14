package com.trgis.hkic.sms.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.trgis.hkic.sms.entity.User;
import com.trgis.hkic.sms.repository.UserDao;
import com.trgis.hkic.sms.service.AccountService;
import com.trgis.modules.security.utils.Digests;
import com.trgis.modules.utils.Encodes;

@Component("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	//安全码长度
	private static final int SALT_SIZE = 8;

	@Autowired
	private UserDao userDao;

	@Override
	public void addUserAccount(User user) {
		entryptPassword(user);
		userDao.save(user);
	}

	@Override
	public User findUserByLoginName(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findUser(final String username) {
		/*
		 * 基于JpaSpecificationExecutor接口的实现，主要是围绕Specification<T>的功能实现
		 */
		Specification<User> spec = new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				root = query.from(User.class);
				Path<String> nameExp = root.get("name");
				return cb.like(nameExp, "%" + username + "%");
			}
		};
		return userDao.findOne(spec);
	}

	@Override
	public List<User> findAllUsers() {
		Sort sort = new Sort(Direction.DESC, "id");
		return userDao.findAll(sort);
	}

	@Override
	public Page<User> findUser(Integer page, Integer size) {
		return userDao.findAll(new PageRequest(page, size));
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		//随机生成安全码
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		//根据安全码进行1024次的hash加密
		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	@Override
	public User getUser(Long id) {
		return userDao.findOne(id.toString());
	}

	@Override
	public void saveUser(User userEntity) {
		userDao.save(userEntity);
	}

	@Override
	public List<User> searchUser(String username, String name) {
		return userDao.findByUsernameAndName(username,name);
	}

}

package test.com.trgis.hkic.sms.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trgis.hkic.sms.entity.User;
import com.trgis.hkic.sms.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
public class TestAccountService {

	private AccountService accountService;

	@Test
	public void TestSaveUserAccount() {
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setName("张三丰"+i);
			user.setUsername("admin"+i);
			user.setPlainPassword("123456");
			accountService.addUserAccount(user);
		}
	}

	@Test
	public void TestFindAllUsers() {
		List<User> users = accountService.findAllUsers();
		for (User u : users) {
			System.out.println(u.getId());
		}
	}
	
	@Test
	public void TestFindPageUsers() {
		Page<User> users = accountService.findUser(0, 10);
		System.out.println("size:"+users.getSize());
		System.out.println("number:"+users.getNumber());
		System.out.println("pages:"+users.getTotalPages());
		for (User u : users.getContent()) {
			System.out.println(u.getId());
		}
	}

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}

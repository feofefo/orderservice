package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.UserDao;
import com.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderserviceApplicationTests {
	@Autowired
	private UserDao userDao;

	@Test
	void  testInsert(){
		User user = new User();
		user.setUsername("w");
		user.setPassword("pwdw");
		user.setAge(31);
		userDao.insert(user);
	}
	@Test
	void  testDelete(){
		userDao.deleteById(132);
	}
	@Test
	void testUpdate(){
		User user =new User();
		user.setId(123L);
		user.setUsername("kongk");
		userDao.updateById(user);
	}
	@Test
	void  testUpdateById(){
		User user = userDao.selectById(30L);
		User user2 = userDao.selectById(30L);

		user.setUsername("lll");

		user2.setPassword("pwdlllllllllll");

		userDao.updateById(user);
		userDao.updateById(user2);
	}
	@Test
	void testGetAll() {
		List<User> users = userDao.selectList(null);
		for (User user:users){
			System.out.println(user.getUsername());
		}
	}
	@Test
	void  testQuery(){
		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//		lqw.select(User::getId,User::getUsername,User::getPassword,User::getAge);
		lqw.lt(User::getId,10).or().gt(User::getId,30);
		List<User> users = userDao.selectList(lqw);
		System.out.println(users);
	}

	@Test
	void testByPage(){
		IPage page = new Page(2,2);
		userDao.selectPage(page,null);
		System.out.println(page.getPages());
		System.out.println(page.getCurrent());
		System.out.println(page.getRecords());
		System.out.println(page.getTotal());
	}

}

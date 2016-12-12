package daoTest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yang.blog.model.User;
import com.yang.blog.service.IArticService;
import com.yang.blog.service.IUserService;

/**
 * @Title: daoTest.java
 * @Prject: sb-blog
 * @Package:
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月29日 下午11:05:55
 * @version: V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class daoTest {
	@Resource
	IUserService user;
	@Resource
	IArticService service;
	@Test
	public void UserDao() throws Exception {
		List<User> u = user.listAll();
		for (User user : u) {
			System.out.println(user);
		}
	}
}

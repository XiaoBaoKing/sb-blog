package daoTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yang.blog.dao.IUserDao;

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
	IUserDao iUserDao;
	@Test
	public void UserDao() throws Exception{
		iUserDao.create();
	}
}

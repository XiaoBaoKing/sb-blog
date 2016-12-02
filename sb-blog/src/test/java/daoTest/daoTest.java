package daoTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yang.blog.dao.IArticDao;
import com.yang.blog.dao.IGroupDao;
import com.yang.blog.dao.IMenuDao;
import com.yang.blog.dao.IPermissionDao;
import com.yang.blog.dao.ISelectInfoDao;
import com.yang.blog.dao.ITagDao;
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
	@Resource
	ITagDao iTagDao;
	@Resource
	ISelectInfoDao iSelectInfoDao;
	@Resource
	IPermissionDao iPermissionDao;
	@Resource
	IMenuDao iMenuDao;
	@Resource 
	IGroupDao iGroupDao;
	@Resource
	IArticDao iArticDao;
	@Test
	public void UserDao() throws Exception{
		iUserDao.create();
		iTagDao.create();
		iSelectInfoDao.create();
		iPermissionDao.create();
		iMenuDao.create();
		iGroupDao.create();
		iArticDao.create();
	}
}

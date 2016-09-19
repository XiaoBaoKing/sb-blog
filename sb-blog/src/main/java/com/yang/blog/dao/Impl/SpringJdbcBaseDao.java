package com.yang.blog.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yang.blog.dao.IBaseDao;

/**
 * @Title: SpringJdbcBaseDao.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.dao.Impl
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月14日 上午10:00:01
 * @version: V1.0
 */
public abstract class SpringJdbcBaseDao<M extends Serializable, PK extends Serializable> implements IBaseDao<M, PK> {

	private Class clazz = this.getClass();

	private JdbcTemplate jdbcTemplateObject;
	private  final Map<String, Object> sqlParam=new HashMap<>();
	
	private  void getSQLparam(){
		Field[] field = clazz.getDeclaredFields();
		Object[] obj = new Object[field.length];
		String valuesName = "", values = "",updateValues="";
		for (int i = 0; i < field.length; i++) {
			obj[i] = this.getter(this, "get" + field[i].getName());
			if (!field[i].getName().contains("id")) {
				valuesName += i == field.length - 1 ? field[i].getName() + "," : field[i].getName();
				values += i == field.length - 1 ? "?," : "?";
			}
		}
		sqlParam.put("valuesName", valuesName);
		sqlParam.put("values", values);
		sqlParam.put("updateValues", updateValues);
		sqlParam.put("objParam", obj);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#save(java.io.Serializable)
	 */
	@Override
	public void save(M model) {
		

		String sql = "INSERT INTO " + clazz.getSimpleName() + "(" + valuesName + ")" + "VALUES(" + values + ")";
		jdbcTemplateObject.update(sql, obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#saveOrUpdate(java.io.Serializable)
	 */
	@Override
	public void saveOrUpdate(M model) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#update(java.io.Serializable)
	 */
	@Override
	public void update(M model) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#merge(java.io.Serializable)
	 */
	@Override
	public void merge(M model) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#delete(java.io.Serializable)
	 */
	@Override
	public void delete(PK id) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#get(java.io.Serializable)
	 */
	@Override
	public M get(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#countAll()
	 */
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#listAll()
	 */
	@Override
	public List<M> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#listAll(int, int)
	 */
	@Override
	public List<M> listAll(int pn, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object getter(Object obj, String att) {
		try {
			Method method = obj.getClass().getMethod("get" + toUpperCaseFirstOne(att));
			return method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static String toUpperCaseFirstOne(String s)
    {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}

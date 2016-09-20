package com.yang.blog.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yang.blog.annotation.Id;
import com.yang.blog.dao.IBaseDao;
import com.yang.blog.utils.common;

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
	private static final String INSERT_SQL = "INSERT INTO TABLE(TABLE_VALUE) VALUES(VALUE)";
	private static final String SELECT_SQL = "SELECT * FROM TABLE";
	private static final String SELECT_PRARM_SQL = "SELECT * FROM TABLE WHERE PARAM";
	private static final String UPDATE_SQL = "UPDATE TABLE SET VALUE WHERE PARAM";
	private static final String DELETE_SQL = "DELETE FROM TABLE WHERE PARAM";

	private Class clazz = this.getClass();

	private JdbcTemplate jdbcTemplateObject;

	private Map getSQLparam() throws Exception {
		Map<String, Object> sqlParam = new HashMap<>();
		Field[] field = clazz.getDeclaredFields();
		List<Object> obj = new ArrayList<>();
		String valuesName = "", values = "", updateValues = "SET ", idName = "";
		Integer id = 0;
		for (int i = 0; i < field.length; i++) {
			field[i].setAccessible(true);
			if (field[i].get(this) != null) {
				if (field[i].isAnnotationPresent(Id.class)) {
					id = field[i].getInt(this);
					idName = field[i].getName();
				}
				valuesName += field[i].getName() + ",";
				values += "?,";
				updateValues += field[i].getName() + "=?,";
				obj.add(field[i].get(this));
			}
		}
		valuesName = common.substrStringExceptLastOne(valuesName);
		values = common.substrStringExceptLastOne(values);
		updateValues = common.substrStringExceptLastOne(updateValues);
		obj.add(id);
		sqlParam.put("valuesName", valuesName);
		sqlParam.put("values", values);
		sqlParam.put("updateValues", updateValues);
		sqlParam.put("objParam", obj);
		sqlParam.put("idName", idName);
		return sqlParam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#save(java.io.Serializable)
	 */
	@Override
	public void save(M model) throws Exception {
		Map map = getSQLparam();
		String sql = INSERT_SQL.replaceAll("TABLE", this.getClass().getSimpleName())
				.replaceAll("TABLE_VALUE", (String) map.get("valuesName"))
				.replaceAll("VALUE", (String) map.get("values"));
		jdbcTemplateObject.update(sql, map.get("objParam"));
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
	public void update(M model) throws Exception {
		Map map = getSQLparam();
		String sql = UPDATE_SQL.replaceAll("TABLE", this.getClass().getSimpleName())
				.replaceAll("VALUE", (String) map.get("updateValues")).replace("PARAM", (String) map.get("idName")+"=?");
		jdbcTemplateObject.update(sql, map.get("objParam"));
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

	

}

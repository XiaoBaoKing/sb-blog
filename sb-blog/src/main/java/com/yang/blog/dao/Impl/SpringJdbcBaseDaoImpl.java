package com.yang.blog.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.yang.blog.annotation.Id;
import com.yang.blog.dao.IBaseDao;
import com.yang.blog.model.enums.TypeEnum;
import com.yang.blog.utils.Common;

/**
 * @Title: SpringJdbcBaseDao.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.dao.Impl
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月14日 上午10:00:01
 * @version: V1.0
 */

public class SpringJdbcBaseDaoImpl<M> implements IBaseDao<M> {
	private static final String INSERT_SQL = "INSERT INTO `TABLE`(TABLE_VALUE) VALUES(VALUE)";
	private static final String SELECT_SQL = "SELECT * FROM `TABLE`";
	private static final String SELECT_PRARM_SQL = "SELECT * FROM `TABLE` WHERE PARAM";
	private static final String SELECT_PRARM_LIMIT_SQL = "SELECT * FROM `TABLE` LIMIT PARAM";
	private static final String UPDATE_SQL = "UPDATE `TABLE` SET VALUE WHERE PARAM";
	private static final String DELETE_SQL = "DELETE FROM `TABLE` WHERE PARAM";
	private static final String SELECT_COUNT_SQL = "SELECT COUNT(*)  FROM `TABLE`";
	private static final String CREATE_SQL = "CREATE TABLE if not exists `TABLENAME` (PARAM)";
	private Class<M> clazz;
	
	Class<List<M>> clazzListM;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	public SpringJdbcBaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		clazz = (Class<M>) type.getActualTypeArguments()[0];
		clazzListM = (Class<List<M>>) type.getActualTypeArguments()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#save(java.io.Serializable)
	 */
	public void save(M model) throws Exception {

		Map map = getSQLparamName(model);
		String sql = INSERT_SQL.replaceAll("TABLE", clazz.getSimpleName())
				.replaceAll("TABLE_VALUE", (String) map.get("valuesName"))
				.replaceAll("VALUE", (String) map.get("values"));
		jdbcTemplate.update(sql, List2Array((List<Object>) map.get("objParam")));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#saveOrUpdate(java.io.Serializable)
	 */
	public void saveOrUpdate(M model) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#update(java.io.Serializable)
	 */
	public void update(M model) throws Exception {
		Map map = getSQLparamName(model);
		String sql = UPDATE_SQL.replaceAll("TABLE", clazz.getSimpleName())
				.replaceAll("VALUE", (String) map.get("updateValues"))
				.replace("PARAM", (String) map.get("idName") + "=?");
		jdbcTemplate.update(sql, List2Array((List<Object>) map.get("objParam")));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#merge(java.io.Serializable)
	 */
	public void merge(M model) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#delete(java.io.Serializable)
	 */
	public void delete(M model) throws Exception {
		Map map = getSQLparam();
		String sql = DELETE_SQL.replaceAll("TABLE", clazz.getSimpleName()).replaceAll("PARAM",
				(String) map.get("idName") + "=?");
		jdbcTemplate.update(sql, map.get("idObj"));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#get(java.io.Serializable)
	 */
	public M get(M model) throws Exception {
		Map map = getSQLparamName(model);
		String sql = SELECT_PRARM_SQL.replaceAll("TABLE", clazz.getSimpleName()).replaceAll("PARAM",
				(String) map.get("idName") + "=?");
		return (M) jdbcTemplate.queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(clazz),
				map.get("idObj"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#countAll()
	 */
	public int countAll() throws Exception {
		// Map map = getSQLparam();
		String sql = SELECT_COUNT_SQL.replaceAll("TABLE", clazz.getSimpleName());
		return jdbcTemplate.queryForInt(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#listAll()
	 */
	public List<M> listAll() throws Exception {
		Map map = getSQLparam();
		String sql = SELECT_SQL.replaceAll("TABLE", clazz.getSimpleName());
		return (List<M>) jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(clazzListM));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#listAll(int, int)
	 */
	public List<M> listAll(int pn, int pageSize) throws Exception {
		Map map = getSQLparam();
		String sql = SELECT_PRARM_LIMIT_SQL.replaceAll("TABLE", clazz.getSimpleName()).replaceAll("PARAM", "?,?");
		return (List<M>) jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(clazzListM),
				new Object[] { pn, pageSize });
	}

	public void create() throws Exception {
		// Map map = getSQLparam();
		String sql = CREATE_SQL.replaceAll("TABLENAME", clazz.getSimpleName()).replaceAll("PARAM", getCreateParam());
		jdbcTemplate.execute(sql);
	}

	private String getCreateParam() throws Exception {
		Field[] field = clazz.getDeclaredFields();
		String retString = "";
		for (int i = 0; i < field.length; i++) {
			if (field[i].getAnnotation(Id.class) != null)
				retString += field[i].getName() + " " + Common.typeMapper(field[i])
						+ " not null primary key auto_increment ,";
			else {
				try {
					retString += field[i].getName() + " " + Common.typeMapper(field[i]) + " not null ,";
				} catch (Exception e) {
					// TODO info();
				}
			}

		}
		return Common.substrStringExceptLastOne(retString);
	}

	private Map getSQLparamName(Object thisObj) throws Exception {
		Map<String, Object> sqlParam = new HashMap<>();
		Field[] field = clazz.getDeclaredFields();
		List<Object> obj = new ArrayList<>();
		Object idObj = new Object();
		String valuesName = "", values = "", updateValues = "SET ", idName = "";
		Integer id = 0;
		for (int i = 0; i < field.length; i++) {
			field[i].setAccessible(true);
			if (field[i].get(thisObj) != null) {
				if (field[i].isAnnotationPresent(Id.class)) {
					id = field[i].getInt(thisObj);
					idName = field[i].getName();
				}
				if (!(field[i].getType().getName() == "java.util.List"
						|| field[i].getType().getName().equals("List"))) {
					valuesName += field[i].getName() + ",";
					values += "?,";
					updateValues += field[i].getName() + "=?,";
					obj.add(field[i].get(thisObj));
				}
			}
			field[i].setAccessible(false);
		}
		valuesName = Common.substrStringExceptLastOne(valuesName);
		values = Common.substrStringExceptLastOne(values);
		updateValues = Common.substrStringExceptLastOne(updateValues);
		idObj = id;
		sqlParam.put("valuesName", valuesName);
		sqlParam.put("values", values);
		sqlParam.put("updateValues", updateValues);
		sqlParam.put("objParam", obj);
		sqlParam.put("idName", idName);
		sqlParam.put("idObj", id);
		return sqlParam;
	}

	/**
	 * 获取SQL
	 * 
	 * @return
	 * @throws Exception
	 */
	private Map getSQLparam() throws Exception {
		Map<String, Object> sqlParam = new HashMap<>();

		Field[] field = clazz.getDeclaredFields();
		List<Object> obj = new ArrayList<>();
		Object idObj = new Object();
		String valuesName = "", values = "", updateValues = "SET ", idName = "";
		Integer id = 0;
		for (int i = 0; i < field.length; i++) {
			field[i].setAccessible(true);
			if (field[i].isAnnotationPresent(Id.class)) {
				idName = field[i].getName();
			}
			if (!(field[i].getType().getName() == "java.util.List" || field[i].getType().getName().equals("List"))) {
				valuesName += field[i].getName() + ",";
				values += "?,";
				updateValues += field[i].getName() + "=?,";
			}
		}
		valuesName = Common.substrStringExceptLastOne(valuesName);
		values = Common.substrStringExceptLastOne(values);
		updateValues = Common.substrStringExceptLastOne(updateValues);

		sqlParam.put("valuesName", valuesName);
		sqlParam.put("values", values);
		sqlParam.put("updateValues", updateValues);
		sqlParam.put("idName", idName);
		return sqlParam;
	}

	private Object[] List2Array(List<Object> objs) {
		Object[] arrayObj = new Object[objs.size()];
		for (int i = 0; i < arrayObj.length; i++) {
			arrayObj[i] = objs.get(i);
		}
		return arrayObj;
	}

}

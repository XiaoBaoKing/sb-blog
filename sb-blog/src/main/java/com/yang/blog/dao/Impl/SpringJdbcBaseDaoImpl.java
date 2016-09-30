package com.yang.blog.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.yang.blog.annotation.Id;
import com.yang.blog.dao.IBaseDao;
import com.yang.blog.model.enums.TypeEnum;
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
public abstract class SpringJdbcBaseDaoImpl<M>  implements IBaseDao<M> {
	private static final String INSERT_SQL = "INSERT INTO TABLE(TABLE_VALUE) VALUES(VALUE)";
	private static final String SELECT_SQL = "SELECT * FROM TABLE";
	private static final String SELECT_PRARM_SQL = "SELECT * FROM TABLE WHERE PARAM";
	private static final String SELECT_PRARM_LIMIT_SQL = "SELECT * FROM TABLE LIMIT PARAM";
	private static final String UPDATE_SQL = "UPDATE TABLE SET VALUE WHERE PARAM";
	private static final String DELETE_SQL = "DELETE FROM TABLE WHERE PARAM";
	private static final String SELECT_COUNT_SQL = "SELECT COUNT(*)  FROM TABLE";
	private static final String CREATE_SQL = "CREATE TABELE TABLENAME (PARAM)";
	private Class<M> clazz;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#save(java.io.Serializable)
	 */
	@Override
	public void save(M model) throws Exception {
		
		Map map = getSQLparam();
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
	public void delete() throws Exception {
		Map map = getSQLparam();
		String sql = DELETE_SQL.replaceAll("TABLE",clazz.getSimpleName()).replaceAll("PARAM",
				(String) map.get("idName") + "=?");
		jdbcTemplate.update(sql, map.get("idObj"));
			
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#get(java.io.Serializable)
	 */
	@Override
	public M get() throws Exception {
		Map map = getSQLparam();
		String sql = SELECT_PRARM_SQL.replaceAll("TABLE", clazz.getSimpleName()).replaceAll("PARAM",
				(String) map.get("idName") + "=?");
		return (M) jdbcTemplate.queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(this.getClass()),
				map.get("idObj"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#countAll()
	 */
	@Override
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
	@Override
	public List<M> listAll() throws Exception {
		Map map = getSQLparam();
		String sql = SELECT_SQL.replaceAll("TABLE", clazz.getSimpleName());
		return (List<M>) jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(this.getClass()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.dao.IBaseDao#listAll(int, int)
	 */
	@Override
	public List<M> listAll(int pn, int pageSize) throws Exception {
		Map map = getSQLparam();
		String sql = SELECT_PRARM_LIMIT_SQL.replaceAll("TABLE",clazz.getSimpleName()).replaceAll("PARAM",
				"?,?");
		return (List<M>) jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(this.getClass()),
				new Object[] { pn, pageSize });
	}
	@Override
	public void create() throws Exception{
		Map map = getSQLparam();
		String sql = CREATE_SQL.replaceAll("TABLENAME",clazz.getSimpleName()).replaceAll("", getCreateParam());
		jdbcTemplate.execute(sql);
	}
	
	private String getCreateParam() throws Exception{
		Field[] field = clazz.getDeclaredFields();
		String retString="";
		for (int i = 0; i < field.length; i++) {
			if(field[i].getAnnotation(Id.class)!=null)
				retString += field[i].getName()+" "+common.typeMapper(field[i]) +" not null primary key auto_increment ,";
			else
				retString += field[i].getName()+" "+common.typeMapper(field[i])+ " not null ,";
		}
		return common.substrStringExceptLastOne(retString);
	}
	
	private Map getSQLparamName(Object obj) throws Exception{
		Map<String, Object> sqlParam = new HashMap<>();
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
			if (field[i].get(this) != null) {
				if (field[i].isAnnotationPresent(Id.class)) {
					id = field[i].getInt(this);
					idName = field[i].getName();
				}
				if(!(field[i].getType().getName()=="java.util.List"||field[i].getType().getName().equals("List"))){
					valuesName += field[i].getName() + ",";
					values += "?,";
					updateValues += field[i].getName() + "=?,";
					obj.add(field[i].get(this));
				}
			}
			field[i].setAccessible(false);
		}
		valuesName = common.substrStringExceptLastOne(valuesName);
		values = common.substrStringExceptLastOne(values);
		updateValues = common.substrStringExceptLastOne(updateValues);
		idObj = id;
		sqlParam.put("valuesName", valuesName);
		sqlParam.put("values", values);
		sqlParam.put("updateValues", updateValues);
		sqlParam.put("objParam", obj);
		sqlParam.put("idName", idName);
		sqlParam.put("idObj", id);
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

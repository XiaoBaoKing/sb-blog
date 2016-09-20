package com.yang.blog;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.yang.blog.annotation.Id;
import com.yang.blog.model.User;
import com.yang.blog.model.enums.TypeEnum;

/**  
 * @Title: test.java
 * @Prject: sb-blog
 * @Package: com.yang.blog
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年9月18日 下午8:57:08
 * @version: V1.0  
 */
public class test {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		User u = new User();
		u.setEmail("1");
		u.setPassWord("a");
		u.setUserName("abc");
	
		System.out.println( TypeEnum.INTEGER);
		
		getSQLparam(u.getClass(),u);
	}
	
	private static  void getSQLparam(Class clazz,Object o) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Field[] fields= clazz.getDeclaredFields();
		//Object[] obj = new Object[field.length];
		String valuesName = "", values = "",updateValues="";
		 for(Field field :fields){
			 if(field.isAnnotationPresent(Id.class)){
				 Id a=(Id)field.getAnnotation(Id.class);
				 
					System.out.println(a.name());
			 }
		
		 }
		
		/*for (int i = 0; i < field.length; i++) {
			//obj[i] = test.getter(clazz, field[i].getName(),o);
			field[i].setAccessible(true);
			System.out.println(List.class.getSimpleName());
			Object ob =field[i].get(o);
			
			if (!field[i].getName().contains("id")) {
				valuesName += i != field.length - 1 ? field[i].getName() + "," : field[i].getName();
				values += i != field.length - 1 ? "?," : "?";
			}else
			{
				Object a = field[i].getClass().getAnnotations()[0].getClass().getField("name").get(field[i].getClass().getAnnotations()[0]);
			}
		}*/
	}
	private static Object getter(Class obj, String att,Object o) {
		try {
			Method method = obj.getMethod("get" + toUpperCaseFirstOne(att));
			return method.invoke(o);
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

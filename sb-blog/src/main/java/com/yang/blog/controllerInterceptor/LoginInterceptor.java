package com.yang.blog.controllerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yang.blog.annotation.Auth;
import com.yang.blog.utils.Assert;
import com.yang.blog.utils.security.Base32;
import com.yang.blog.utils.security.Md5Utils;
import com.yang.blog.utils.webutils.WebUtils;

/**
 * @Title: MvcInterceptor.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.ControllerInterceptor
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年12月9日 下午4:25:51
 * @version: V1.0
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURL().toString();
		System.out.println(">>>: " + url);
	
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			Auth authPassport = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
			if (authPassport == null) {
				return true;
			} else {
				String login =WebUtils.getSession(request, "uid");
				Cookie verifyCode = WebUtils.getCookieByName(request, "verifyCode");
				
				String deCodeValue =new String(Base32.decode(verifyCode.getValue()),"utf-8");
				String code = request.getParameter("code");
				//前端生成verifyCode并用base32加密
				if (true) {
					// 如果验证成功返回true（这里直接写false来模拟验证失败的处理）
					System.out.println("执行权限校验了");
					return true;
				} else {
					// 如果验证失败
					// response.sendRedirect("account/login");
					return false;
				}
			}
		}
		return false;
	}
}

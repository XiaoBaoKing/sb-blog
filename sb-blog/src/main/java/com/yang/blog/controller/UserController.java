package com.yang.blog.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.blog.service.IUserService;

/**
 * @Title: UserController.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.controller
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年12月6日 下午1:40:03
 * @version: V1.0
 */
@Controller
public class UserController {
	

	@RequestMapping("User/")
	public String getUserInfo() throws Exception {
		
		return null;
	}
}

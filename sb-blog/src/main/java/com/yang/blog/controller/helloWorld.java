package com.yang.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.blog.annotation.Auth;

/**
 * @Title: helloWorld.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.controller
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年12月2日 下午8:28:07
 * @version: V1.0
 */
@Controller
public class helloWorld {
	@RequestMapping("/hello")
	@Auth
	public String hello() {
		return "hello";
	}
}

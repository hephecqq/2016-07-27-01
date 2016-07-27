package com.net;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author Administrator
 *
 *         演示Spring AOP测试类
 */
@Controller
public class UserAction {
	public void queryUser() {
		System.out.println("查询所有用户【all users list】");
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-aop.xml");
		UserAction userAction = (UserAction) ctx.getBean("userAction");
		userAction.queryUser();
		ctx.destroy();
	}
}

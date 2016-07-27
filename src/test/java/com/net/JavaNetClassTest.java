package com.net;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Junit4 测试(通配符引入spring配置文件)
 * 
 * @author Administrator
 * @version [版本号,2016-07-26]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext.xml"})
public class JavaNetClassTest {

	/**
	 * 自动装配,注入接口的实现类
	 */
	@Autowired
	private JavaNetClass javaNetClass;
	
	/**
	 * 单元测试代码
	 * 
	 * @throws Exception
	 * @ses [类,类#方法,类#成员]
	 * 
	 */
	@Test
	public void test() throws Exception{
		System.out.println(javaNetClass.getClassName());
		
	}
}

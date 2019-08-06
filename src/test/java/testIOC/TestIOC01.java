package testIOC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC01 {

	public static void main(String[] args) {
		/*
		 * HelloService hs = new HelloService(); hs.sayHello();
		 */
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
	HelloService hService = ctx.getBean("helloService",HelloService.class);
	hService.sayHello();
	ctx.close();
	}

}

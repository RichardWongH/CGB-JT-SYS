package testIOC;

public class HelloService {
	public HelloService() {
		System.out.println("helloService()");	
		}
	public void init() {
		System.out.println("init");

	}
	public void sayHello() {
		System.out.println("sayHello spring");
	}
	public void destory() {
		System.out.println("destory");
	}
}

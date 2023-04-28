package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloAppSpring {

	public static void main(String[] args) {
		String config ="src/main/java/ex04/appContext.xml";
		ApplicationContext ctx = new FileSystemXmlApplicationContext(config);
		
		Message msg = ctx.getBean("mb1",Message.class);
		msg.sayHello();
		msg.sayHi("¼öÁö", "Ã¶¼ö","¿µÈñ","BTS");
	}

}

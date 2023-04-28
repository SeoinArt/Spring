package ex01;

public class HelloApp {

	public static void main(String[] args) {
//		MessageBeanEn mb = new MessageBeanEn();
		MessageBeanKo mb = new MessageBeanKo();
		mb.sayHello("홍길동");
//		HelloApp이 MessageBeanEn 객체를 사용(use) => HelloApp이 MessageBeanEn에 의존한다(dependency)한다
		//의존성 있는 객체들간의 결합도가 중요하다.
		// 결합도가 강하면 향후 객체를 교체하고자 할때 문제가 될 수 있다.
	}

}

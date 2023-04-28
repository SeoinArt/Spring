package ex04;

public interface Message {
	void sayHello();
	void sayHi(String ... names);
	// 매개변수를 자유자제로 넣을 수 있다. 
	// names변수는 String[]배열 타입
}

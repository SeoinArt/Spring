package day05.Homework;
import java.util.*;

public class Q9_removeChar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 :");
		String str = sc.nextLine();
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : str.toCharArray()) {
			if(c==')')while(!stack.empty()&&stack.pop()!='(') {} 
			else stack.push(c);
		}
		System.out.println(stack.toString());
	}
}

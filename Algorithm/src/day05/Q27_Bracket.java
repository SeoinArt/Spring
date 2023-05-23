package day05;
import java.util.*;

/*
6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(
* */

public class Q27_Bracket {

	static String solution(String str) {
		Stack<Character> stack = new Stack<>();
		boolean result=true;
		
		for(int i =0; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				stack.push('(');
			}
			else if(stack.isEmpty()) {
				result=false;
				break;
			}
			else {
				stack.pop();
			}
		}
		return (result && stack.isEmpty())?"Yes":"No";
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("소괄호를 입력하세요 : ");
		
		String str = sc.next();
		
		System.out.println(solution(str));
			
		}
		
	}

	



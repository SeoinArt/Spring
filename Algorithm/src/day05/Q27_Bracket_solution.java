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

public class Q27_Bracket_solution {

	static String solution(String str) {
		String result = "";
		Stack<Character> stack = new Stack<>();
		char[] ch = str.toCharArray();
		Stack<Character> sk = new Stack<>();
		for (char c : ch) {
			if (c == '(') { // 여는 괄호일 때 push
				sk.push(c);
			} else if (c == ')') {
				if (sk.isEmpty()) { // 닫는 괄호일때 pop if-> 짝이 맞는 여는 괄호가 있는지 체크 후 없으면 No
					result = "NO";
					return result;
				}
				sk.pop();
			}
			result = (sk.isEmpty()) ? "Yes" : "NO";
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇개의 문자열을 입력하겠습니까?");

		int n = sc.nextInt();
		System.out.println("\n소괄호를 입력하세요 : ");
		String[] arr =new String[n];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			arr[i]=solution(str);
			
		}
		System.out.println(Arrays.toString(arr));
	}

}

package day05.Homework;

import java.util.*;

public class Q11_StrCompression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println((solution(str)));

	}

	static String solution(String str) {
		int n =1;
		str +=" ";
		StringBuilder answer = new StringBuilder();
		for(int i = 0; i<str.length()-1; i++) {
			if(str.charAt(i)==str.charAt(i+1)) n++;
			else {
				answer.append(str.charAt(i));
				if(n>1) {
					answer.append(n);
					n=1;
				}
			}
		}
		return answer.toString();
	}
}

package day01;

import java.util.*;

public class Q2_Median {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("3개의 정수를 입력하세요");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int result = median(a, b, c);
		System.out.println(result);

	}

	public static int median(int a, int b, int c) {
//		 int[] list = {a, b, c};
//		 Arrays.sort(list);
//		 return list[1];
		if(a>=b) return (b>=c)?b:(a>c)?c:a;
		else return (a>=c)?a:(b>c)?c:b;
		
	}
}

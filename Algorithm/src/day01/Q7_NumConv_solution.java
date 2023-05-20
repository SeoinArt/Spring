package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q7_NumConv_solution {
	public static void solution(int num, int radix, char[] arr) {
		System.out.printf("%d를 %d진수로 변환 : \n",num,radix);
		String str="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int cnt =0;
		do {
			int mod = num%radix;
			char c = str.charAt(mod);
			arr[cnt++]=c;
			num/=radix;
		}while(num!=0);
		
		
		/*
		 * for(int i=0; i<cnt; i++) { System.out.print(arr[cnt-1-i]); }
		 */
		for(int i=0; i<cnt/2;i++) {
			char tmp = arr[i];
			arr[i]=arr[cnt-i-1];
			arr[cnt-i-1]=tmp;
		}
		System.out.println(Arrays.toString(arr));
		
		
	}

	public static void main(String[] args) {
		char[] arr = new char[32];
		Scanner sc = new Scanner(System.in);
		System.out.println("정수(양수) 입력: ");
		int num=sc.nextInt();
		System.out.println("몇 진수로 변환할까요? (2~36) ");
		int radix =sc.nextInt();
		solution(num,radix,arr);
	}
}

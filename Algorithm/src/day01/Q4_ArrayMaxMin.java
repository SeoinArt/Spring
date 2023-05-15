package day01;

import java.util.*;

public class Q4_ArrayMaxMin {
	
	// 최대, 최소값을 배열에 담아 반환하세요
	public static int[] solution(int[] heights) {
		Arrays.sort(heights);
		int[] answer = new int[2]; // 최대키, 최소키 값을 저장할 배열
		answer[1]=heights[0];
		answer[0]=heights[heights.length-1];
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사람 수를 입력하세요 [키의 최대, 최소 값을 구합니다]");
		int num = sc.nextInt();
		Random rn = new Random();
		int[] num1 = new int[num];
		for (int i =0; i<num; i++) {
			num1[i]=rn.nextInt(90)+100;
			System.out.printf("num1[%d]=%d\n",i,num1[i]);
		}
		//반복문을 돌면서 height에 랜덤한 키 값을 저장하기 (100~190);
		
		int[] answer= solution(num1);
		System.out.println("최대키 :"+answer[0]);
		System.out.println("최소키 :"+answer[1]);
	}
}

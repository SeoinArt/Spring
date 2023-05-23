package day05;

import java.util.*;

public class Q26_assignment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("회의 수:");
		int n = sc.nextInt();
		int[][] num = new int[n][2];

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + "번째 회의 시작시간, 종료 시간 입력 : ");
			num[i][0] = sc.nextInt();
			num[i][1] = sc.nextInt();
		}

		Arrays.sort(num, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		
		int c = 0;
		int laEnd=0;
		
		for(int i=0; i<n; i++) {
			if(laEnd <=num[i][0]) {
				laEnd=num[i][1];
				c++;
			}
		}
		System.out.println("회의 가능한 수 : "+c);
	}
}

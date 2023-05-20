package homework;
import java.util.*;
public class Q8_CrossSumMax {

	public static void solution(int[][] arr) {
		int x,y;
		int answer=0;
		for(int i=0; i<arr.length; i++) {
			x=y=0;
			for(int j=0; j<arr.length; j++) {
				x+=arr[i][j];
				y+=arr[j][i];
			}
			answer=(Math.max(Math.max(answer,x),y));
		}
		x=y=0;
		for(int i=0;i<arr.length;i++) {
			x+=arr[i][i];
			y+=arr[arr.length-1][arr.length-1];
		}
		System.out.println("가장 큰 합은 : "+Math.max(Math.max(answer, x),y));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("격자판의 크기를 입력하시오 : ");
		int n = sc.nextInt(); 
		int[][] arr = new int [n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		solution(arr);
	}

}

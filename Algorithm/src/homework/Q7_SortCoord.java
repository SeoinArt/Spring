package homework;
import java.util.*;
public class Q7_SortCoord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, (a,b)->{
			if(a[0] == b[0])
				return b[1] - a[1];
			else 
				return b[0] - a[0];
		});
		
		for(int i=0; i<n; i++) {
			System.out.printf("%d %d\n", arr[i][0], arr[i][1]);
		}
	}
}

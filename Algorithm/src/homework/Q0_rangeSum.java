package homework;
import java.util.*;

public class Q0_rangeSum {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[][] tab=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				tab[i][j]=sc.nextInt()+tab[i-1][j]+tab[i][j-1]-tab[i-1][j-1];
			}
		}
		for(int i=0;i<m;i++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			System.out.println(tab[x2][y2]-tab[x2][y1-1]-tab[x1-1][y2]+tab[x1-1][y1-1]);
		}
		
	}
}

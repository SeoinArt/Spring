package homework;
import java.util.*;
import java.util.stream.Stream;

public class Q10_ArrayCommon {
	
	public static void solution(int[] a, int[] b) {
		for(int i=0; i<a.length; i++) {
			for(int j =0; j<b.length; j++) {
				if(a[i]==b[j]) {
					System.out.print(a[i]+" ");
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[2];
		
		for(int i=0; i<num.length; i++) {
			System.out.println("배열"+(i+1)+"의 개수 :");
			num[i]=sc.nextInt();
		}
		int[] a = new int[num[0]];
		int[] b = new int[num[1]];
			
		for(int i =0; i<num.length; i++) {
			System.out.println("배열"+(i+1)+"에 저장할 값을 오름차순으로 입력 :");
			for(int j=0; j<num[i];j++) {
				if(i==0) {
					a[j]=sc.nextInt();
				}
				else {
					b[j]=sc.nextInt();
				}
			}
		}
		solution(a,b);
		
		
		
	}

}

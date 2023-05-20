package homework;
import java.util.*;
public class Q6_Array_Rank {
	static Scanner sc = new Scanner(System.in);
	
	public static int[] solution(int[] arr) {
		int[] ar = new int[arr.length];
		for(int i=0; i<arr.length; i++){
            int count =1;
            for(int j=0; j<arr.length; j++){
               count=(arr[i] < arr[j])? ++count:count;
            }
            ar[i] = count;
        }
		return ar;
	}
	
	
	public static void main(String[] args) {
		System.out.println("학생 수 입력");
		int num = sc.nextInt();
		System.out.printf("국어 성적 %d개 입력\n",num);
		int[] arr =new int[num];
		
		for(int i=0; i<num; i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(Arrays.toString(arr));
		int[] a = solution(arr);
		for(int i: a){
			System.out.print(i+" ");
		}
	}
}

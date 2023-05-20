package homework;
import java.util.*;

public class Q1_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int a = Integer.valueOf(sc.nextLine());
		String b = sc.nextLine();
		for(int i=0; i<a; i++) {
			max+=Integer.parseInt(String.valueOf(b.charAt(i)));
		}
		System.out.println(max);				
	}

}

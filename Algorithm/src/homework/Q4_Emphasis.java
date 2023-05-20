package homework;
import java.util.*;
public class Q4_Emphasis {
	
	public static String solution(String myString) {
		String b = myString.toLowerCase();
        b=b.replace('a','A');
        return b;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(solution(sc.nextLine()));
	}
}

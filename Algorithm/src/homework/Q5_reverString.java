package homework;
import java.util.*;
public class Q5_reverString {

	public static String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder(my_string.substring(s,e+1)).reverse();
        String a = my_string.substring(0,s);
        String b =my_string.substring(e+1);     
        return a+answer.toString()+b;
    }
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		int c =Integer.parseInt(String.valueOf(sc.nextLine()));
		int b =Integer.parseInt(String.valueOf(sc.nextLine()));
		System.out.println(solution(a,c,b));
	}

}

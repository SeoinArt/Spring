package homework;
import java.util.*;

public class Q2_ChangeString {
	
	public static String solution(String str1, String str2) {
	       
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<str1.length();i++){
            answer.append(str1.charAt(i));
            answer.append(str2.charAt(i));
        }
        return answer.toString();
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(solution(a,b));

	}

}

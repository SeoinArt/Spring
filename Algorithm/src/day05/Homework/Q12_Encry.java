package day05.Homework;
import java.util.*;

public class Q12_Encry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자개수 입력(8이하로)");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("암호 문자 입력");
		String str = sc.nextLine();	
		System.out.println(solution(str));
	}
	static String solution(String str) {
		StringBuilder ans =new StringBuilder();
		StringBuilder answer = new StringBuilder(str.replace('#','1').replace('*', '0'));	
		System.out.println(answer.toString().length()+"개를 입력했어요 \n풀이한 암호는 아래와 같습니다.");
		for(int i =0; i<answer.toString().length(); i+=7) {
			ans.append((char)Integer.parseInt(answer.substring(i, i+7).toString(),2));
		}
		return ans.toString();
	}	
	//#**##**#**####*##**###****##
}

package homework;
import java.util.*;
public class Q3_UpperLower {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(int i=0; i<a.length(); i++){
        	System.out.println(Character.isUpperCase(a.charAt(i))?(Character.toLowerCase(a.charAt(i))):(Character.toUpperCase(a.charAt(i))));
        }
	}
}

package homework;

import java.util.*;
import java.util.stream.Collectors;

public class Q9_SumArray {

	public static int[] solution (int[] a, int[] b) {
		ArrayList<Integer> a1 = (ArrayList<Integer>)Arrays.stream(a).boxed().collect(Collectors.toList());
		ArrayList<Integer> a2 = (ArrayList<Integer>)Arrays.stream(b).boxed().collect(Collectors.toList());
		a1.addAll(a2);
		Collections.sort(a1);
		return a1.stream().mapToInt(i->i).toArray();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("배열 1의 개수 : ");
		int[] a = new int[sc.nextInt()];
		System.out.println("배열 1에 저장할 값을 오름차순으로 입력하시오");
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("배열 2의 개수 : ");
		int[] b = new int[sc.nextInt()];
		System.out.println("배열 2에 저장할 값을 오름차순으로 입력하시오");
		for(int i=0; i<b.length; i++) {
			b[i] = sc.nextInt();
		}
		int[] answer = solution(a,b);
		for(int i:answer ) {
			System.out.print(i+" ");
		}
	}
}

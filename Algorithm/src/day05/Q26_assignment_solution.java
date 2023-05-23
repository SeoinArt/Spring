package day05;
import java.util.*;

/* 1  3
2  3
1  2
3  5
4  6*/
class Time implements Comparable<Time> {
	int start; // 회의 시작 시간
	int end; // 회의 종료 시간

	public Time(int s, int e) {
		this.start = s;
		this.end = e;
	}

	@Override
	public int compareTo(Time o) {
		if (this.end == o.end) { // 끝나는 시간이 같으면 시작시간으로 오름차순 정렬하자
			return this.start - o.start; // 시작시간 오름차순
		}

		return this.end - o.end; // 종료시간 오름차순
	}

	public String toString() {
		return "Time[start=" + start + ", end = " + end + "]";
	}

}

public class Q26_assignment_solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("회의 수:");
		int n = sc.nextInt();
		List<Time> times = new ArrayList<>();
		
		System.out.println("회의 시작 시간, 종료 시간 입력 : ");
		
		for(int i =0; i<n; i++) {
			int start= sc.nextInt();
			int end= sc.nextInt();
			Time t = new Time(start,end);
			times.add(t);
		}
		int cnt = solution(times,n);
		
		
		System.out.println("회의 가능한 수 : " + cnt);
	}

	private static int solution(List<Time> arr, int n) {
		int cnt = 0;
		// arr을 정렬
//		Arrays.sort(arr); 배열일 경우 사용 가능
		
		Collections.sort(arr);
		int endTime = 0;
		for(Time obj : arr) {
			if(obj.start>=endTime) {
				cnt++;
				System.out.println(obj);
				endTime = obj.end;
			}
		}
		return cnt;
	}
}

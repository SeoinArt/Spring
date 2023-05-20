package day03;

import day02.Emp;

public class Q25_MyArrayListTest {
	public static void main(String[] args) {
		// MyARrayList 생성해서 Integer 유형 객체 저장한 후 반복문 이용하여 출력
		
		MyArrayList<Integer> arr = new MyArrayList<>();
		arr.add(Integer.valueOf(10));
		arr.add(Integer.valueOf(20));
		arr.add(Integer.valueOf(30));
		arr.add(Integer.valueOf(40));
		arr.add(50);
		System.out.println("arr.size() : "+arr.size());
		
		arr.add(60);
		arr.add(70);
		System.out.println("arr.size() : "+arr.size());
		
		for(int i=0; i<arr.size();i++) {
			Integer val = arr.get(i);
			System.out.println(val);
		}
		arr.remove(2);
		System.out.println("인덱스 2번 객체 삭제 후 -------");
		for(int i=0; i<arr.size();i++) {
			Integer val = arr.get(i);
			System.out.println(val);
		}
		
		MyArrayList<Emp> arr2 = new MyArrayList<Emp>();
		
		Emp e1 = new Emp("Scott",158);
		Emp e2 = new Emp("Ward",169);
		arr2.add(e1);
		arr2.add(e2);
		
		Emp tmp =  arr2.get(0);
		System.out.println(tmp);
	}
}

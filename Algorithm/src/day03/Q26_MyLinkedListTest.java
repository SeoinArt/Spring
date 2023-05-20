package day03;

import day03.MyLinkedList.Node;

import java.util.Comparator;

import day02.Emp;

public class Q26_MyLinkedListTest {

	public static void main(String[] args) {
		//test1();
		test2();
	}

	public static void test2() {
		// Emp 객체 3개 생성해서 MyLinkedList에 저장하세요
		
		Emp e1 = new Emp("김사원",150);
		Emp e2 = new Emp("님사원",200);
		Emp e3 = new Emp("딤사원",250);
		
		// [1] 모두 출력하기;
		MyLinkedList<Emp> list = new MyLinkedList<>();
		list.addLast(e1);
		list.addLast(e2);
		list.addLast(e3);
		list.print();
		
		/*
		 * list.remove(list.currentN); list.printCurrentNode();
		 * 
		 * list.removeFirst();
		 */
		
		// [2] 사원 검색
		// [2]-1. 키로 검색하기 search()활용
		
		Emp answer1 = list.search(new Emp("",150),Emp.Height_Order);
		System.out.println((answer1 == null)?"해당 키를 가진 사원은 없어요":answer1);
		System.out.println("----------------------------------------------------");
		// [2]-2. 이름으로 검색하기 => Emp에 Name_Order Comparator 구성
		answer1 = list.search(new Emp("김사원",0),Emp.Name_Order);
		System.out.println((answer1==null)?"해당 사원의 이름은 없어요":answer1);
		System.out.println("----------------------------------------------------");
		
		list.printCurrentNode();
		
		while(list.next()) {
			list.printCurrentNode();
		}
		
		
	}

	public static void test1() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.printCurrentNode();

		list.addLast("C");
		list.addFirst("D");

		list.printCurrentNode();
		list.print();

		list.removeFirst();
		list.printCurrentNode();
		list.print();

		list.addLast("D");
		list.print();

//		list.remove(new MyLinkedList.Node<>("C",null)); => 주소값이 다르므로 삭제되지 않는다.
		list.remove("C");
		list.print();

		list.clear();
		list.printCurrentNode();
		list.print();

	}

}

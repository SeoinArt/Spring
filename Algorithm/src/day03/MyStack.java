package day03;

import javax.management.RuntimeErrorException;

public class MyStack<T> {
	
	private Node<T> top = null;
	
	//inner class
	class Node<T>{
		private T data;
		private Node<T> next =null;
		public Node(T data) {
			this.data = data;
		}
	} // inner class end -----------------------
	
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.next=top;
		top=newNode; // top에 방금 들어온 item 노드를 전달한다
	}
	
	public T peek() {
		if(top== null) {
			throw new RuntimeException("EmptyException");
		}
		return top.data;
	}
	
	public T pop() {
		if(top==null) {
			throw new RuntimeException("EmptyException");
		}
		T delData = top.data; // 꼭대기 데이터
		top = top.next;
		
		return delData;
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
} // main class end -----------------------

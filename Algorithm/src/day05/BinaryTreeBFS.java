package day05;

import java.util.LinkedList;
import java.util.Queue;

// BFS (Breath First Search)
public class BinaryTreeBFS {

	class Node {
		int data;
		Node left, right; // 왼쪽 자식, 오른쪽 자식 노드를 참조할 변수

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}// ~Node{}

	private Node makeTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
		return root;
	}// ~makeTree()

	
	
	private void makeBFS(Node root) {
		Queue<Node> q = new LinkedList<>();
		// 삽입 : offer(), add()
		// 삭제 : poll() , remove()
		// 검사 : peek()
		q.offer(root);
		int level = 0;
		while(!q.isEmpty()) {
			System.out.print("Level "+level+": ");
			int size = q.size();
			for(int i=0; i<size; i++) {
				Node item = q.poll();
				System.out.printf(item.data+"->");
				if(item.left!=null) q.offer(item.left); // 왼쪽 자식 노드를 큐에 추가
				if(item.right!=null) q.offer(item.right); // 오른쪽 자식 노드를 큐에 추가
				
			}// ~for
			level++;
			System.out.println();
			
		}// ~while
	}// ~makeBFS()

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeBFS app = new BinaryTreeBFS();
		Node root = app.makeTree();
		app.makeBFS(root);
	}

}

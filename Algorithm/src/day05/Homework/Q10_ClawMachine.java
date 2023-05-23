package day05.Homework;

import java.util.*;

public class Q10_ClawMachine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size,start;
		int[] move;
		
		System.out.println("인형뽑기의 크기를 정하시오 : ");
		size=sc.nextInt();
		int[][] board = new int[size][size];
		System.out.println("인형의 위치를 정하시오");
		for(int i=0; i<size; i++) {
			System.out.println(i+1+"번쨰 행");
			for(int j=0; j<size; j++){
				board[i][j] = sc.nextInt(); 
			}
		}
	
		System.out.println("크레인의 작동 횟수를 정하세요 :");
		start = sc.nextInt();
		move= new int[start];
		for(int i=0; i<start; i++) {
			move[i]= sc.nextInt();
		}
		int answer = solution(board,move);
		System.out.println(answer);
		
	}

	private static int solution(int[][] board, int[] move) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		//move = {1,5,3,5,1,2,1,4}
		for(int i : move) {
			for(int j=0; j<board.length;j++) {		
				if(board[j][i-1]==0) {
//					System.out.println((j)+"흘러내림");	
					continue;}
				else {
//					if(stack.empty()) {
//						stack.push(board[j][i-1]);
////						System.out.println("1번째 삽입");
//					}
					if(!stack.empty()&&stack.peek()==board[j][i-1]) {
						stack.pop();
//						System.out.println("pop 동작");
						answer+=2;
					}else {
						stack.push(board[j][i-1]);
//						System.out.println("push 작동");
					}
					board[j][i-1] =0;
					break;
				}
			}
		}
//		System.out.println(stack.toString());
		return answer;
	}
}

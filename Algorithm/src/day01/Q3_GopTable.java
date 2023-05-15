package day01;

public class Q3_GopTable {
	
	public static void solution() {
		for(int i =0; i<10; i++) {
			
			String n="";
			if(i==0) n=" |";
			else n=i+"|";
			System.out.print(n);
			
			for(int j =1; j<10; j++) {
				if(i==0) {
					System.out.print("  "+j);
					if(j==9) {
						System.out.print("\n-|----------------------------");
					}
					continue;	
				}
				System.out.printf("%3d",(i)*(j));
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		solution();
	}
}

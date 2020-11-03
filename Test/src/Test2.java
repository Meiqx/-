import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		
		System.out.println("请输入第一个数字:");
		int i = scan.nextInt();
		
		System.out.println("请输入第二个数字:");
		int j = scan.nextInt();
		
		int sum = new Test2().test(i,j);
		
		System.out.println("i+j="+sum);
	}
	
	private int test(int i,int j) {			
		int sum = i + j;
		return sum;
	}

}

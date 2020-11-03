package test5;

public class Test4 {

	
	public static void a(int i) {
		if(i>100) {
			return;
		}
		i++;
		
		System.out.println(i);
		a(i);
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		int i = 0;
		a(i);

	}

}

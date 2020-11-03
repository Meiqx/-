
public class Static {
	static int a;
	int b;
	static int c;
	
	public int aMethod() {
		a++;
		return a;
	}
	public int bMethod() {
		b++;
		return b;
	}
	public static int cMethod() {
		c++;
		return c;
	}
	
	public static void main(String[] args) {
		Static t1 = new Static();
		Static t2 = new Static();
		
		
		t1.aMethod();
		System.out.println(t1.aMethod());
		
		t2.bMethod();
		System.out.println(t2.bMethod());
		
		cMethod();
		System.out.println(cMethod());
	}
}

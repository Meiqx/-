package test5;

public class Test3 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] a= {8,65,7,35,5,2,64,22,65,44,15,97,88,66,91};
		int num;
		for(int i = 0;i<a.length;i++) {
			for(int j = 1;j<a.length-i-1;j++) {
				if(a[j]>a[j+1]) {
					num = a[j];
					a[j]=a[i];
					a[j+1]=num;
				}
			}				
		}
		for(int i = 0;i<a.length;i++) {
			System.out.print(a[i]+"  ");
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);

	}

}

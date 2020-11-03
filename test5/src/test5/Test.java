package test5;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	/**
	 * ��������   O(NlogN)
	 * @param list
	 */
	private static void quickSort(ArrayList<Integer> list) {
		
		if(list.size()>1) {
			
			ArrayList<Integer> smallerlist = new ArrayList<>();
			ArrayList<Integer> centerList = new ArrayList<>();
			ArrayList<Integer> largeList = new ArrayList<>();
			
			//�м�Ԫ��
			Integer center = list.get(list.size()/2);
			
			//����
			for(Integer i : list) {
				if(i < center) {
					//���м�Ԫ��С
					smallerlist.add(i);
				}else if (i > center) {
					//���м�Ԫ�ش�
					largeList.add(i);
				}else {
					//���м�Ԫ�����
					centerList.add(i);
				}
			}
			
			//��������
			quickSort(smallerlist);
			quickSort(largeList);
			
			//���
			list.clear();
			//�ϲ�
			list.addAll(smallerlist);
			list.addAll(centerList);
			list.addAll(largeList);
		}
	}
	
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		int[] a = {1,8,2,6,4,2,3,8,4,6,10,12,45,21,311,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,
				1,8,2,6,4,2,3,8,4,6,10,12,45,21,311,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,1,8,2,6,4,2,3,8,4,6,10,12,45,21,31};
		
		ArrayList<Integer> list = new ArrayList<>();

		for(int i = 0;i<a.length;i++) {
			list.add(a[i]);
		}
		
		quickSort(list);
		long end = System.nanoTime();
		System.out.println(end-start);
		for(Integer integer : list) {
			System.out.print(integer+"\t");
		}
	}
}




























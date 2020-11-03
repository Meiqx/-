package test5;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	/**
	 * 快速排序   O(NlogN)
	 * @param list
	 */
	private static void quickSort(ArrayList<Integer> list) {
		
		if(list.size()>1) {
			
			ArrayList<Integer> smallerlist = new ArrayList<>();
			ArrayList<Integer> centerList = new ArrayList<>();
			ArrayList<Integer> largeList = new ArrayList<>();
			
			//中间元素
			Integer center = list.get(list.size()/2);
			
			//分类
			for(Integer i : list) {
				if(i < center) {
					//比中间元素小
					smallerlist.add(i);
				}else if (i > center) {
					//比中间元素大
					largeList.add(i);
				}else {
					//与中间元素相等
					centerList.add(i);
				}
			}
			
			//分组排序
			quickSort(smallerlist);
			quickSort(largeList);
			
			//清空
			list.clear();
			//合并
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




























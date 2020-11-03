import java.util.Scanner;

/**
 * @ClassName Sort
 * @Author MeiQx
 * @Description 冒泡排序
 * @Create_date 2020/7/16 14:29
 * @Version 1.0
 */
public class Sort {

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j]>arr[j+1]){
                    arr[j+1] += arr[j];
                    arr[j] = arr[j+1]-arr[j];
                    arr[j+1] -= arr[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,5,4,7,2};

//        Scanner scanner = new Scanner(System.in);
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print("请输入第"+(i+1)+"个数    ");
//            arr[i] = scanner.nextInt();
//        }

        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

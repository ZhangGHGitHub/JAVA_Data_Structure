package Java.October;
import java.util.Arrays;

/**
 * @author: 张国豪
 * @date: 2020/10/30 8:02
 * FileName: TestBinarySearch
 * @version: 1.0
 * Description: 二分法查找
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr= {30,20,50,10,80,9,7,12,100,40,8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(myBinarySearch(arr,40));
    }

    public static int myBinarySearch(int[] arr,int value) {
        int low = 0;
        int high = arr.length-1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(value==arr[mid]) {
                return mid;
            }
            if(value>arr[mid]) {
                low = mid+1;
                //关于+1-1的解释
                //https://blog.csdn.net/qq_24629159/article/details/88630655
            }
            if(value<arr[mid]) {
                high = mid-1;
            }
        }
        //没有找到返回-1
        return -1;
    }

}

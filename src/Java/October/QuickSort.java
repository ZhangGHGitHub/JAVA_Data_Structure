package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/12/4 14:45
 * FileName: QuickSort
 * @version: 1.0
 * Description: 快速排序（升序）
 */
public class QuickSort {
    public static void quickSort(int [] keys)
    {
        quickSort(keys,0,keys.length-1);
    }
    private static void quickSort(int []keys, int begin, int end)
    {
        if(begin>=0 && begin<end && end<keys.length)
        {
            int i = begin,j = end;
            int x = keys[i];
            while(i!=j)
            {
                while(i<j && keys[j]>=x)
                {
                    j--;
                }
                if(i<j)
                {
                    keys[i++] = keys[j];
                }
                while (i<j && keys[i]<=x)
                {
                    i++;
                }
                if(i<j)
                {
                    keys[j--] = keys[i];
                }
            }
            keys[i] = x;
            for (int key : keys) {
                System.out.print(key + " ");
            }
            System.out.println();
            quickSort(keys,begin,j-1);
            quickSort(keys,i+1,end);
        }
    }

    public static void main(String[] args) {
        int [] array={39,39,97,75,61,19,26,49};
        quickSort(array);
    }
}

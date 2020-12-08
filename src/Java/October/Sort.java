package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/11/27 14:37
 * FileName: Sort
 * @version: 1.0
 * Description: 排序
 */
public class Sort {
    public static void insertSort(int []keys,boolean asc)
    {
        for(int i=1 ;i<keys.length;i++)
        {
            int x=keys[i],j;
            for(j=i-1;j>=0 && (asc ? x<keys[j] : x>keys[j]); j--)
            {
                keys[j+1]=keys[j];
            }
            keys[j+1]=x;
        }
    }

    /**希尔排序*/
    public static void shellSort(int []keys)
    {
        for(int delta=keys.length/2;delta>0;delta/=2)
        {
            for(int i=delta;i<keys.length;i++)
            {
                int x = keys[i],j;
                for(j=i-delta; j>=0 && x<keys[j];j-=delta)
                {
                    keys[j+delta] = keys[j];
                }
                keys[j+delta] = x;
            }
            System.out.print("第几趟："+delta+" :");
            for(int i=0;i<keys.length;i++) {
                System.out.print(keys[i]+" ");
            }
            System.out.println();
        }
    }
    /**冒泡升序*/
    public static void bubbleSort(int[] keys)
    {
        boolean exchange = true;
        int temp = 0;
        for(int i=1;i<keys.length && exchange; i++)
        {
            exchange = false;
            for(int j=0;j<keys.length-i; j++)
            {
                if(keys[j]>keys[j+1])
                {
                    temp = keys[j+1];
                    keys[j+1]=keys[j];
                    keys[j]=temp;
                    exchange = true;
                }
            }
        }
    }
/*冒泡降序**/

    public static void bubbleSortDown(int[] keys){
        boolean exchange = true;
        int temp = 0;
        int min = keys[keys.length-1];
        for(int i=1;i<keys.length && exchange; i++)
        {
            exchange = false;
            for(int j=keys.length-1;j>0; j--)
            {
                if(keys[j]<keys[j-1])
                {
                    temp = keys[j-1];
                    keys[j-1]=keys[j];
                    keys[j]=temp;
                    for(int f=0;f<keys.length;f++) {
                        System.out.print(keys[f]+" ");
                    }
                    exchange = true;
                }
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        int [] array={19,28,37,46,55,64,13,22,41};
//         insertSort(array,true);
//        shellSort(array);
        bubbleSortDown(array);
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
    }
}
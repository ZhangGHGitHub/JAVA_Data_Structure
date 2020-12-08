package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/12/4 16:39
 * FileName: heapSort
 * @version: 1.0
 * Description: 堆排序
 */
public class heapSort {

    public static void heapSort(int []keys)
    {
        for(int i=keys.length/2-1; i>=0; i--)
        {
            sift(keys, i , keys.length-1);
        }
        for(int i=keys.length-1; i>0; i--)
        {
            swap(keys, 0, i);
            sift(keys, 0, i-1);
        }
    }
    public static void sift(int [] keys, int parent, int end)
    {
        int child = 2*parent+1;
        int x = keys[parent];
        while (child<=end)
        {
            if(child<end && keys[child+1]<keys[child])
            {
                child++;
            }
            if(x>keys[child])
            {
                keys[parent] = keys[child];
                parent = child;
                child = 2*parent+1;
            }
            else
            {
                break;
            }
        }
        keys[parent] = x;
    }
    public static void swap(int [] keys, int i, int j) {
        int temp = keys[j];
        keys[j] = keys[i];
        keys[i] = temp;
    }

    public static void heapSort2(int[] keys) {
        for (int i = keys.length / 2 - 1; i >= 0; i--) {
            sift2(keys, i, keys.length - 1);
        }

        for (int i = keys.length - 1; i > 0; i--) {
            swap(keys, 0, i);       //头与尾置换
            for (int a : keys) {
                System.out.print(a + "\t");
            }
            System.out.println();

            sift2(keys, 0, i - 1);
        }
    }

    public static void sift2(int[] keys, int parent, int end) {
        int child = 2 * parent + 1;
        //左孩子
        int x = keys[parent];
        //存储父亲节点的值
        while (child <= end) {
            //为true说明还有孩子，为false说明没有孩子了
            if (child < end && keys[child + 1] > keys[child])
                //child < end 表示父节点有右孩子， 如果有孩子比左孩子大，child就变成右孩子
            {
                child++;
            }
            if (x < keys[child]) {
                //如果父节点比孩子节点小，就让父子节点值交换
                keys[parent] = keys[child];
                parent = child;
                child = 2 * parent + 1;
                //继续往下找，知道路径走到头
            } else {
                break;
            }
        }
        keys[parent] = x;
    }


}


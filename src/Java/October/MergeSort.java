package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/12/8 10:39
 * FileName: MergeSort
 * @version: 1.0
 * Description: 归并排序
 */
public class MergeSort {
    private static void merge(int[] X, int[] Y, int begin1, int begin2, int n) {
        int i = begin1, j = begin2, k = begin1;
        while (i < begin1 + n && j < begin2 + n && j < X.length) {
            if (X[i] <= X[j]) {
                Y[k++] = X[i++];
            } else {
                Y[k++] = X[j++];
            }
        }
        while (i < begin1 + n && i < X.length) {
            Y[k++] = X[i++];
        }
        while (j < begin2 + n && j < X.length) {
            Y[k++] = X[j++];
        }
    }

    //一趟归并
    private static void mergepass(int[] X, int[] Y, int n) {
        for (int i = 0; i < X.length; i += 2 * n) {
            merge(X, Y, i, i + n, n);
        }

        for (int a : Y) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }

    //归并排序
    public static void mergeSort(int[] X) {
        int[] Y = new int[X.length];
        int n = 1;
        while (n < X.length) {
            mergepass(X, Y, n);
            n *= 2;
            if (n < X.length) {
                mergepass(Y, X, n);
                n *= 2;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr8 = {97, 75, 53, 26, 85, 32, 17, 61, 75, 65, 12};
        mergeSort(arr8);
        for(int f=0;f<arr8.length;f++) {
            System.out.print(arr8[f]+", ");
        }
        System.out.println();
    }
}

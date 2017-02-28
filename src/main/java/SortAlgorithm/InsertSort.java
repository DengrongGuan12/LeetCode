package SortAlgorithm;

/**
 * Created by dengrongguan on 2017/2/28.
 */
public class InsertSort {
    // 直接插入算法

    static int data[] = { 9, 2, 7, 19, 100, 97, 63, 208, 55, 78 };

    public static void insertSort() {
        int tmp, j = 0;
        for (int k = 0; k < data.length; k++) {//-----1-----
            tmp = data[k];
            j = k - 1;
            while (j >= 0 && tmp < data[j]) {//-----2-----
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = tmp;//------3-------
        }
    }

    public static void main(String[] args) {
        print();
        System.out.println();
        insertSort();
        System.out.println();
        print();
    }

    static void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

}

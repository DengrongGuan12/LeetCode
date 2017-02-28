package SortAlgorithm;

/**
 * Created by dengrongguan on 2017/2/28.
 */
public class SelectSort {

    static int data[] = { 9, 2, 7, 19, 100, 97, 63, 208, 55, 78 };

    public static void selectSort() {
        int i, j, k, tmp = 0;
        for (i = 0; i < data.length - 1; i++) {
            k = i;
            for (j = i + 1; j < data.length; j++)
                if (data[j] < data[k])
                    k = j;
            if (k != i) {
                tmp = data[i];
                data[i] = data[k];
                data[k] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        print();
        System.out.println();
        selectSort();
        System.out.println();
        print();
    }

    static void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

}

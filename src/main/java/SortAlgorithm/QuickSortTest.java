package SortAlgorithm;

/**
 * Created by dengrongguan on 2017/2/28.
 */
public class QuickSortTest {

    static class QuickSort {

        public int data[];

        private int partition(int array[], int low, int high) {
            int key = array[low];
            while (low < high) {
                while (low < high && array[high] >= key)
                    high--;
                array[low] = array[high];
                while (low < high && array[low] <= key)
                    low++;
                array[high] = array[low];
            }
            array[low] = key;
            return low;
        }

        public int[] sort(int low, int high) {
            if (low < high) {
                int result = partition(data, low, high);
                sort(low, result - 1);
                sort(result + 1, high);
            }
            return data;
        }
    }

    static void print(int data[]) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void main(String[] args) {
        int data[] = { 20, 3, 10, 9, 186, 99, 200, 96, 3000 };
        print(data);
        System.out.println();
        QuickSort qs = new QuickSort();
        qs.data = data;
        qs.sort(0, data.length - 1);
        print(data);
    }
}

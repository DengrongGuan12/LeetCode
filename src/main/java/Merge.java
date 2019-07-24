import java.util.*;

public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0]:o1[1]-o2[1];
            }
        });
        Stack<int[]> results = new Stack<int[]>();
        for (int[] interval: intervals) {
            while(!results.isEmpty()){
                int[] tmpInterval = results.peek();
                if (tmpInterval[1] >= interval[0]){
                    interval[0] = Math.min(interval[0], tmpInterval[0]);
                    results.pop();
                }else{
                    break;
                }
            }
            results.push(interval);
        }
        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.merge(new int[][]{

        });
    }
}

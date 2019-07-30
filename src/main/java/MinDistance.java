import java.util.PriorityQueue;
import java.util.Queue;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        Queue<String> queue = new PriorityQueue<String>();
        int res = 0;
        queue.add(word1);
        while (!queue.isEmpty()){
            String tmp = queue.poll();
            if (tmp.equals(word2)){
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {

    }
}

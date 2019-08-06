import java.util.*;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<Integer>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
                1,2,3
        };
        SubSets subSets = new SubSets();
        subSets.subsets(nums);
    }
}

class SubSetsNoDup{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<Integer>(tmp));
        Set<Integer> set = new HashSet<Integer>();
        for (int j = i; j < nums.length; j++) {
            if (set.contains(nums[j])){
                continue;
            }
            set.add(nums[j]);
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
                1,2,2
        };
        SubSetsNoDup subSets = new SubSetsNoDup();
        subSets.subsetsWithDup(nums);
    }
}
class ExistOnBoard{
    int[][] d = new int[][]{
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (backtracking(0, i,j, word, board, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtracking(int cur, int x, int y, String word, char[][] board, int[][] visited){
        if (cur == word.length()){
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length  || visited[x][y] > 0 ||board[x][y] != word.charAt(cur)){
            return false;
        }
        visited[x][y] = 1;
        boolean res = false;
        for (int i = 0 ;i < d.length;i++){
            if (backtracking(cur +1, x + d[i][0], y + d[i][1], word, board, visited)){
                return true;
            }
        }
        visited[x][y] = 0;
        return res;


    }
    public static void main(String[] args) {
        ExistOnBoard existOnBoard = new ExistOnBoard();
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(existOnBoard.exist(board, "SFCSECBAS"));
    }
}

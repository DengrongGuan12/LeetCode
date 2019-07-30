import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n){
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
//        int i = n - 2,j = m - 2;
//        for (;i != 0 && j != 0;i--,j--){
//            res[i][j] = res[i-1][j-1] + 2;
//        }
//        return res[i][j] + 2;
//        return unique(m, n, 0, 0);
    }

    private int unique(int col, int row, int startX, int startY){

        if (startX == row - 1 || startY == col - 1){
            return 1;
        }
        return unique(col, row, startX + 1, startY) + unique(col, row, startX, startY + 1);
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(7, 3));
    }
}

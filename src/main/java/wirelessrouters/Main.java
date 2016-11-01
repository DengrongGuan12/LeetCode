package wirelessrouters;

import java.util.Scanner;

/**
 * Created by dengrong on 2016/9/30.
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int roomNum = scanner.nextInt();
        int routerNum = scanner.nextInt();
        int[][] points = new int[roomNum][roomNum];
        for(int i = 0;i<roomNum;i++){
            points[i][i] = scanner.nextInt();
        }
        for(int i=0;i<roomNum-1;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = Math.min(a,b);
            int d = Math.max(a,b);
            points[c-1][d-1] = points[d-1][d-1];
            points[d-1][c-1] = points[c-1][c-1];
        }
        int maxIndex = 0;
        int maxPoint = -1;
        int result = 0;
        for(int i = 0;i<routerNum;i++){
            for(int j=0;j<roomNum;j++){
                int tmpPoint = 0;
                for(int k=0;k<roomNum;k++){
                    tmpPoint+=points[j][k];
                }
                if(tmpPoint > maxPoint){
                    maxIndex = j;
                    maxPoint = tmpPoint;
                }
            }
            result+=maxPoint;
            for(int j=0;j<roomNum;j++){
                points[maxIndex][j] = 0;
                points[j][maxIndex] = 0;
            }
        }
        System.out.println(result);
    }
}

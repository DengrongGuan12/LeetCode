package magicCube;

import java.util.Scanner;

/**
 * Created by dengrong on 2016/10/1.
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int[][][] bigCube = new int[m][m][m];
        for(int i = 0;i<m;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    bigCube[i][j][k] = scanner.nextInt();
                }
            }
        }
        int[][][][] smallCubes = new int[n][][][];
        for(int i=0;i<n;i++){
            int length = scanner.nextInt();
            smallCubes[i] = new int[length][length][length];
            for (int j=0;j<length;j++){
                for(int k=0;k<length;k++){
                    for(int z=0;z<length;z++){
                        smallCubes[i][j][k][z] = scanner.nextInt();
                    }
                }
            }
        }
    }
}

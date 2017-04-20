package com.huaweifx.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dengrongguan on 2017/4/20.
 */
public class Main {
    static int[][] hours = {{0,0,0,0,0,0,0},{0,0,2,10,5,3,-1},{0,-1,0,12,-1,-1,10},{0,-1,-1,0,-1,7,-1},
            {0,2,-1,-1,0,2,-1},{0,4,-1,-1,1,0,-1},{0,3,-1,1,-1,2,0}};
    static int[] visited = new int[7];//0表示未访问过，1表示访问过
    static List<Integer> path = new ArrayList<Integer>();
    static int x = 0;
    static int y = 0;
    public static void main(String[] args){
//        1 2 3 4 5 6
//        1 0h 2h 10h 5h 3h M
//        2 M 0h 12h M M 10h
//        3 M M 0h M 7h M
//        4 2h M M 0h 2h M
//        5 4h M M 1h 0h M
//        6 3h M 1h M 2h 0h

        System.out.println(path.toString());
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        path.add(5);
        visited[5] = 1;
        int dis = visit(0,5);
        System.out.println( dis >= 1000?1000:dis);
        path.add(x);
        if (dis >= 1000){
            path.clear();
        }
        System.out.println(path.toString());

    }
    public static int visit(int hour,int from){
        if(from == x){
//            path.add(from);
            return hour;
        }else{
            int min  = 1000;
            int tmpPosition = 0;
            for(int i=1;i<=6;i++){
                if(i == from){
                    continue;
                }else if(i == y){
                    continue;
                }else if(hours[from][i] == -1){
                    continue;
                }else{
                    if(visited[i] == 0){
                        visited[i] = 1;
                        int tmp = visit(hour+hours[from][i],i);
                        visited[i] = 0;
                        if(tmp < min){
                            min = tmp;
                            tmpPosition = i;
                        }
                    }
                }
            }
            if(tmpPosition != 0 && tmpPosition != x){
                path.add(tmpPosition);
            }
            return min;
        }
    }
}

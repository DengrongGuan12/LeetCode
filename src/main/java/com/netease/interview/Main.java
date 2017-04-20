package com.netease.interview;

import java.util.Scanner;

/**
 * Created by dengrongguan on 2017/3/25.
 */
public class Main {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] taxiPos = new int[n][2];
//        int startX=0,startY = 0;
//        for(int i = 0;i<n;i++){
//            int x = sc.nextInt();
//            taxiPos[i][0] = x;
//        }
//        for(int i = 0;i<n;i++){
//            int y = sc.nextInt();
//            taxiPos[i][1] = y;
//        }
//        int endX = sc.nextInt();
//        int endY = sc.nextInt();
//        int walkTime = sc.nextInt();
//        int taxiTime = sc.nextInt();
//        int minTime = getTime(startX,endX,startY,endY,walkTime);
//        for(int i=0;i<n;i++){
//            int tmp = getTime(startX,taxiPos[i][0],startY,taxiPos[i][1],walkTime)+getTime(taxiPos[i][0],endX,taxiPos[i][1],endY,taxiTime);
//            if(tmp<minTime){
//                minTime = tmp;
//            }
//        }
//        System.out.println(minTime);
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        char[] chars1 = s.toCharArray();
//        char[] chars2 = s.toCharArray();
//        // B > G
//        int count1 = 0;
//        for(int i = chars1.length-1;i>0;i--){
//            boolean ex = false;
//            for(int j=0;j<i;j++){
//                if(chars1[j] == 'B' && chars1[j+1] == 'G'){
//                    // exchange
//                    char tmp = chars1[j];
//                    chars1[j] = chars1[j+1];
//                    chars1[j+1] = tmp;
//                    count1++;
//                    ex = true;
//                }
//            }
//            if(!ex){
//                break;
//            }
//        }
//
//        // B < G
//        int count2 = 0;
//        for(int i = chars2.length-1;i>0;i--){
//            boolean ex = false;
//            for(int j=0;j<i;j++){
//                if(chars2[j] == 'G' && chars2[j+1] == 'B'){
//                    // exchange
//                    char tmp = chars2[j];
//                    chars2[j] = chars2[j+1];
//                    chars2[j+1] = tmp;
//                    count2++;
//                    ex = true;
//                }
//            }
//            if(!ex){
//                break;
//            }
//        }
//        System.out.println(count1<count2?count1:count2);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] ints = new int[n];
        for(int i = 0;i<n;i++){
            ints[i] = scanner.nextInt();
        }
        for(int i = 0;i<k;i++){
            int tmp = ints[0];
            for(int j=0;j<n;j++){
                if(j == n-1){
                    ints[j] = ints[j]+tmp;
                }else{
                    ints[j] = ints[j]+ints[j+1];
                }
                if(ints[j]>=100){
                    ints[j] = ints[j]%100;
                }
            }
        }
        for(int i=0;i<n-1;i++){
            System.out.print(ints[i]+" ");
        }
        System.out.println(ints[n-1]);

    }
    private static int getTime(int x1,int x2,int y1,int y2,int pTime){
        int x = x1-x2;
        int y = y1-y2;
        if(x < 0){
            x = 0-x;
        }
        if(y < 0){
            y = 0-y;
        }
        return (x+y)*pTime;
    }
}

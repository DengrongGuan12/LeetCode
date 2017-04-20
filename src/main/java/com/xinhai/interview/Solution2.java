package com.xinhai.interview;

/**
 * Created by dengrongguan on 2017/3/14.
 */
public class Solution2 {
    private int numSquares(int n){
        if(n == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1;i*i<=n;i++){
            int count = 1+numSquares(n-i*i);
            if(count < min){
                min = count;
            }
        }
        return min;
    }
    public static void main(String args[]){
        System.out.println(new Solution2().numSquares(13));
    }
}

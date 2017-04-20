package com.ali.interview;

/**
 * Created by dengrongguan on 2017/3/2.
 */
public class Main {
    public static void main(String[] args){

    }
    private static final int MIN_LENGTH = 7;
    public static void jiabi(){
        int[] ints = {2,5,1,1,1,1,4,1,7,3,7};
        int length = ints.length;
        if(length < MIN_LENGTH){
            return;
        }
        int head = 1,tail = length-2, middle = 3;
        int[] sums = new int[length];
        sums[0] = ints[0];
        for (int i = 1;i<length;i++){
            sums[i] = sums[i-1]+ints[i];
        }

        while(true){
            int sum1 = sums[head] - ints[head];
            int sum2 = sums[middle] - sums[head] - ints[middle];
            int sum3 = sums[tail] - sums[middle] - ints[tail];
            int sum4 = sums[length-1] - sums[tail];
            if(sum1 == sum4){

            }
        }
    }
    public static void sum(){
        //        int[] ints = {2,5,1,1,1,1,4,1,7,3,7};
        int[] A={10,2,11,13,1,1,1,1,1};
        int length = A.length;
        if(length < 7){
            return;
        }
        int[] ps = {1,3,length-2};
        int[] sums = new int[length];
        sums[0] = A[0];
        for (int i = 1;i<length;i++){
            sums[i] = sums[i-1]+A[i];
        }
        while(true){
            int[] s = new int[4];
            s[0] = sums[ps[0]]-A[ps[0]];
            s[1] = sums[ps[1]]-sums[ps[0]]-A[ps[1]];
            s[2] = sums[ps[2]]-sums[ps[1]]-A[ps[2]];
            s[3] = sums[length-1]-sums[ps[2]];
            int sum = sums[length-1]-A[ps[0]]-A[ps[1]]-A[ps[2]];
            int minPosition = minPosition(s);
            if(s[minPosition]*4 == sum){
                System.out.println(true);
                break;
            }else if(minPosition == 2){
                System.out.println(false);
                break;
            }else if(minPosition == 3){
                ps[2]--;
            }else{
                ps[minPosition]++;
            }
        }
    }
    public static int minPosition(int ...sum){
        int position = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<sum.length;i++){
            if(sum[i]<min){
                min = sum[i];
                position = i;
            }
        }
        return position;
    }
}

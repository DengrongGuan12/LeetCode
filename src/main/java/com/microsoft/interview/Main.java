package com.microsoft.interview;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by dengrongguan on 2017/3/31.
 */
public class Main {
    static int p;
    static int q;
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        p = in.nextInt();
        q = in.nextInt();
        n = in.nextInt();
//        p = p1/100;
//        q = q1/100;
        double result = calculate(p,0,0,0);
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(result));

    }
    private static double calculate(double tmpP,int get,int tmpN,int h){
        if(tmpN == n){
//            double result = h;
//            while(h > 0){
//                result = result/100;
//                h--;
//            }
            return h/Math.pow(100,h);
        }else{
            if(get == 1){
                double tmp = p/Math.pow(2,tmpN);
//                for(int i = 0;i<tmpN;i++){
//                    tmp = tmp/2;
//                }
                return tmp*calculate(tmp,1,tmpN+1,h+1)+(100-tmp)*calculate(100-tmp,2,tmpN,h+1);
            }else if(get == 2){
                tmpP = tmpP+q;
                if(tmpP >= 100){
                    return 100*calculate(100,1,tmpN+1,h+1);
                }else{
                    return tmpP*calculate(tmpP,1,tmpN+1,h+1)+(100-tmpP)*calculate((100-tmpP),2,tmpN,h+1);
                }

            }else if(get == 0){
                // root
                return p*calculate(p,1,tmpN+1,h+1)+(100-p)*calculate(100-p,2,tmpN,h+1);
            }
        }
        return 0;
    }
}

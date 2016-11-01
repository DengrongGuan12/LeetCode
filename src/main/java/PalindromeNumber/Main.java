package PalindromeNumber;

import java.util.Scanner;

/**
 * Created by dengrong on 2016/10/31.
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String num = number+"";
        boolean isPalindrome = true;
        for(int i = 0,j=num.length()-1;i<=j;i++,j--){
            if(num.charAt(i) == num.charAt(j)){
                continue;
            }else{
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome){
            System.out.println("1");
        }
    }
}

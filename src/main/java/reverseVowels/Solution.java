package reverseVowels;

/**
 * Created by I322233 on 4/26/2016.
 */
public class Solution {
    String vowels = "AaEeIiOoUu";
    public String reverseVowels(String s){

        int len = s.length();
        int i = 0;
        int j = len-1;
        char[] origins = s.toCharArray();
        while(i < j){
            while(i<j && !isVowel(origins[i]))i++;
            while(i<j && !isVowel(origins[j]))j--;
            if(i == j)break;
            char tmp = origins[i];
            origins[i] = origins[j];
            origins[j] = tmp;
            i++;
            j--;
        }
        return new String(origins);
    }
    public boolean isVowel(char c){
        if(vowels.contains(c+"")){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String a = "OE";
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels(a));
    }
}

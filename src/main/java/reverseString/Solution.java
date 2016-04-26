package reverseString;

/**
 * Created by I322233 on 4/26/2016.
 */
public class Solution {
    public String reverseString(String s){

        int len = s.length();
        int i = 0;
        int j = len-1;
        char[] origins = s.toCharArray();
        while(i < j){
            char tmp = origins[i];
            origins[i] = origins[j];
            origins[j] = tmp;
            i++;
            j--;
        }
        return new String(origins);
    }
    public static void main(String[] args){
        String a = "Osdfsdfsdf";
        Solution solution = new Solution();
        System.out.println(solution.reverseString(a));
    }
}

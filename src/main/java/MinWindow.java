import java.util.ArrayList;
import java.util.List;

public class MinWindow {
    public String minWindow(String s, String t){
        int[] charCount = new int[128];
        for (int i = 0; i < t.length(); i++){
            charCount[t.charAt(i)] ++;
        }
        List<Integer> ids = new ArrayList<Integer>();
        for (int i = 0;i < s.length();i++){
            if (charCount[s.charAt(i)] > 0){
                ids.add(i);
            }
        }
        int minLen = Integer.MAX_VALUE;
        String res = "";
        for (int k = 0; k < t.length() - 1; k++){
            if (charCount[s.charAt(ids.get(k))] > 0){
                charCount[s.charAt(ids.get(k))] --;
            }
        }
        for (int i = 0;i <= ids.size() - t.length();i++){
            int j = i + t.length() - 1;
            while (j < ids.size()){
                if (charCount[s.charAt(ids.get(j))] > 0){
                    charCount[s.charAt(ids.get(j))]--;
                }
                if (sum(charCount) == 0){
                    if (minLen > (ids.get(j) - ids.get(i))){
                        minLen = ids.get(j) - ids.get(i);
                        res = s.substring(ids.get(i), ids.get(j)+1);
                    }
                    break;
                }
                j++;

            }
            charCount[s.charAt(ids.get(i))] ++;
        }
        return res;
    }

    public int sum(int[] arr){
        int sum = 0;
        for (int s : arr){
            sum+=s;
        }
        return sum;
    }
    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.print(minWindow.minWindow("ADOBECODEBANC", "ABC"));
    }
}

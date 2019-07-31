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
        for (int i = 0;i < ids.size();i++){
            int sum = sum(charCount);
            for (int k = i; k <=  i + t.length() - 1; k++){
                sum --;
            }
            for (int j = i + t.length(); j < ids.size() ; j++){
                if (sum == 0){

                    break;
                }
                sum--;
            }
        }
        int l=0,h = 0;

        while (h < s.length()){
            while(l < s.length() && charCount[s.charAt(l)] == 0) l++;
            if (l > (s.length() - t.length())) break;
            charCount[s.charAt(l)]--;
            h = l+1;
            while(sum(charCount) > 0 && h < s.length()){
                if (charCount[s.charAt(h)] > 0){
                    charCount[s.charAt(h)] --;
                }
                h++;
            }
            if (sum(charCount) == 0){
                if (h - l < minLen){
                    minLen = h - l;
                    res = s.substring(l, h);
                }
                charCount[s.charAt(l)]++;
                l++;
            }
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

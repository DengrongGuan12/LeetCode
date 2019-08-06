import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinWindow {

    public String minWindow(String s, String t){
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        Map<Character, Integer> tmpCharCount = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++){
            charCount.put(t.charAt(i), charCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        List<Integer> ids = new ArrayList<Integer>();
        for (int i = 0;i < s.length();i++){
            if (charCount.containsKey(s.charAt(i))){
                ids.add(i);
            }
        }
        int left = 0, right = 0;
        String res = "";
        int minLen = Integer.MAX_VALUE;
//        String tmp = "";
        while (right < ids.size()){
            while(right < ids.size()){
//                tmpCharCount[s.charAt(ids.get(right))]++;
                tmpCharCount.put(s.charAt(ids.get(right)), tmpCharCount.getOrDefault(s.charAt(ids.get(right)), 0)+1);
//                tmp = s.substring(ids.get(left), ids.get(right) + 1);
                if (contain(tmpCharCount, charCount)){
                    break;
                }
                right++;
            }
            while(left <= right){
//                tmp = s.substring(ids.get(left), ids.get(right) + 1);
                if (contain(tmpCharCount,charCount)){
                    String tmpRes = s.substring(ids.get(left), ids.get(right) + 1);
                    if (tmpRes.length() < minLen){
                        res = tmpRes;
                        minLen = tmpRes.length();
                    }
                }else{
                    break;
                }
//                tmpCharCount[s.charAt(ids.get(left))]--;
                tmpCharCount.put(s.charAt(ids.get(left)), tmpCharCount.get(s.charAt(ids.get(left))) - 1);
                left++;
            }
            right++;
        }
        return res;
    }

    public boolean contain(Map<Character, Integer> map1,  Map<Character, Integer> map2){
        // 判断map1 是否包含 map2
        for (Character c: map2.keySet()){
            if (map1.containsKey(c) && map1.get(c) >= map2.get(c)){
                continue;
            }
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(minWindow.minWindow("acbbaca", "aba")); //baca
//        System.out.println(minWindow.minWindow("cabwefgewcwaefgcf", "cae"));
//        System.out.println(minWindow.minWindow("a", "aa"));
    }
}

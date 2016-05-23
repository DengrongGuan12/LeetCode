import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DengrongGuan on 2016/4/30.
 * Given a list of unique words.
 * Find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]


 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

 */
public class PalindromPairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
//        int i = 0;
//        for (String word:
//             words) {
//            for(int j=i+1;i<words.length;j++){
//                if(judgePal(word+words[j])){
//                    List<Integer> l = new ArrayList<Integer>();
//                    l.add(i);
//                    l.add(j);
//                    results.add(l);
//                }
//                if(judgePal(words[j]+word)){
//                    List<Integer> l = new ArrayList<Integer>();
//                    l.add(j);
//                    l.add(i);
//                    results.add(l);
//                }
//            }
//            i++;
//
//        }
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        int i = 0;
        for(String word:words){
            map.put(word,i);
            i++;
        }
        i = 0;
        for(String word:words){
            if(word.length() <=1){
                continue;
            }
            if(judgePal(word)){
                if(map.containsKey("")){
                    int j = map.get("");
                    List<Integer> l1 = new ArrayList<Integer>();
                    l1.add(i);
                    l1.add(j);
                    results.add(l1);
                    List<Integer> l2 = new ArrayList<Integer>();
                    l2.add(j);
                    l2.add(i);
                    results.add(l2);
                }
            }
            String revert = revertString(word);
            if(map.containsKey(revert)){
                int j = map.get(revert);
                if(i != j){
                    List<Integer> l1 = new ArrayList<Integer>();
                    l1.add(i);
                    l1.add(j);
                    results.add(l1);
                }
            }
            for(int leftPal = 0;leftPal<word.length()-1;leftPal++){
                if(judgePal(word.substring(0,leftPal+1))){
                    String r = word.substring(leftPal+1,word.length());
                    revert = revertString(r);
                    if(map.containsKey(revert)){
                        int j = map.get(revert);
                        List<Integer> l1 = new ArrayList<Integer>();
                        l1.add(j);
                        l1.add(i);
                        results.add(l1);
                    }
                }

            }
            for(int rightPal = word.length()-1;rightPal>0;rightPal--){
                if(judgePal(word.substring(rightPal,word.length()))){
                    String l = word.substring(0,rightPal);
                    revert = revertString(l);
                    if(map.containsKey(revert)){
                        int j = map.get(revert);
                        List<Integer> l1 = new ArrayList<Integer>();
                        l1.add(i);
                        l1.add(j);
                        results.add(l1);
                    }
                }
            }

            i++;
        }
        return results;
    }
    public boolean judgePal(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<=j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    public String revertString(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public int maxLeftPal(String str){
        //左边的最大回文字符串的结尾位置
        int j = str.length()-1;
        int i = 0;
        while(j >= 0){
            if(str.charAt(i) == str.charAt(j)){
                int tmp = j;
                boolean isPal = true;
                j--;
                i++;
                while(j >= i){
                    if(str.charAt(j) == str.charAt(i)){
                        j--;
                        i++;
                    }else{
                        isPal = false;
                        break;
                    }
                }
                if(isPal){
                    return tmp;
                }else{
                    j = tmp;
                    i = 0;
                }
            }
            j--;
        }
        return j;
    }
    public int maxRightPal(String str){
        //右边的最大回文字符串的开始位置
        int j = str.length()-1;
        int i = 0;
        while(i <= j){
            if(str.charAt(i) == str.charAt(j)){
                int tmp = i;
                boolean isPal = true;
                j--;
                i++;
                while(j >= i){
                    if(str.charAt(j) == str.charAt(i)){
                        j--;
                        i++;
                    }else{
                        isPal = false;
                        break;
                    }
                }
                if(isPal){
                    return tmp;
                }else{
                    j = str.length()-1;
                    i = tmp;
                }
            }
            i++;
        }
        return i;
    }
    public static void  main(String[] args){
        PalindromPairs pa = new PalindromPairs();
        System.out.println(pa.maxLeftPal("sssll"));
    }
}

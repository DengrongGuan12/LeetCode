import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        Map<Character, List<Integer>> charLoc = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < chars.length; i ++){
            List<Integer> list = null;
            if (charLoc.containsKey(chars[i])){
                list = charLoc.get(chars[i]);
            }else{
                list = new ArrayList<Integer>();
            }
            list.add(i);
            charLoc.put(chars[i], list);
        }
        int max = 1;
        String res = chars[0]+"";
        for (int i = 0;i < chars.length; i++){
            List<Integer> list = charLoc.get(chars[i]);
            if (list.size() <= 1){
                continue;
            }else{
                for (int j = list.size() - 1; j > 0; j--){
                    int r = list.get(j) + 1;
                    if((r - i)>max && judgePalindrome(s.substring(i, r))){
                        max = r - i;
                        res = s.substring(i, r);
                    }
                }
            }
        }
        return res;
    }

    public String v2(String s){
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        // abcdedcba
        //   j   i
        // 如果 dp[j,i] = true 那么 dp[j+1,i-1] 也一定为 true
        // [j + 1,i - 1] 一定要构成至少两个元素额区间（ 1 个元素的区间，s.charAt(i)==s.charAt(j) 已经判断过了）
        // 即 j + 1 < i - 1，即 i > j + 2 (不能取等号，取到等号，就退化成 1 个元素的情况了)
        // 应该反过来写
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                // 区间应该慢慢放大
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > longestPalindrome) {
                        longestPalindrome = i - j + 1;
                        longestPalindromeStr = s.substring(j, i + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

    public boolean judgePalindrome(String s){
        if (s.length() < 2){
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r){
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abacab";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome(a));
    }
}

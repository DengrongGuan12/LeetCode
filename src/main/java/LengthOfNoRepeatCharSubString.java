import java.util.HashSet;
import java.util.Set;

public class LengthOfNoRepeatCharSubString {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> characterSet = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int i = 0;
        while(i + max < chars.length){
            if (i > 0){
                characterSet.remove(chars[i - 1]);
            }
            for (int j = i + characterSet.size();j < chars.length; j ++){
                if (characterSet.contains(chars[j])){
                    break;
                }else{
                    characterSet.add(chars[j]);
                }
            }
            if (characterSet.size() > max){
                max = characterSet.size();
            }
            i++;
        }
        return max;
    }
}

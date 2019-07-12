import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinitions {
    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    List<String> coms = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        combine("", digits);
        return coms;
    }

    private void combine(String res, String digits){
        if (digits == null || digits.length() == 0){
//            System.out.println(res);
            coms.add(res);
            return;
        }
        char f = digits.charAt(0);
        String letters = phone.get(f);
        for(int i = 0;i<letters.length();i++){
            combine(res+letters.charAt(i), digits.substring(1));
        }
    }

    public static void main(String[] args) {
        LetterCombinitions letterCombinitions = new LetterCombinitions();
        letterCombinitions.letterCombinations("23");
    }
}

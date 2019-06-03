import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */

public class InvalidParentheses {
    public List<String> removeInvalidParentheses(String s){
        Stack<ErrorChar> characters = new Stack<ErrorChar>();
        char[] chars = s.toCharArray();
        List<Integer> startIndexes = new ArrayList<Integer>();
        List<Integer> endIndexes = new ArrayList<Integer>();
        for (int i = 0;i < chars.length ; i++){
            if (chars[i] == '('){
                startIndexes.add(i);
            }else if (chars[i] ==')'){
                endIndexes.add(i);
            }
            if (characters.size() > 0){
                ErrorChar errorChar = characters.peek();
                if (errorChar.c == '(' && chars[i] == ')'){
                    characters.pop();
                    continue;
                }
            }
            if (chars[i] == '(' || chars[i] == ')'){
                ErrorChar errorChar = new ErrorChar();
                errorChar.c = chars[i];
                errorChar.index = i;
                characters.push(errorChar);
            }

        }
        List<Integer> errorStartIndexIds = new ArrayList<Integer>();
        List<Integer> errorEndIndexIds = new ArrayList<Integer>();
        while (!characters.empty()){
            ErrorChar errorChar = characters.pop();
            if (errorChar.c == '('){
                errorStartIndexIds.add(startIndexes.indexOf(errorChar.index));
            }else{
                errorEndIndexIds.add(endIndexes.indexOf(errorChar.index));
            }
        }
        if (errorStartIndexIds.size() > 0){
            int startLastIndexId = startIndexes.size() - 1;
        }
        List<String> results = new ArrayList<String>();
        return results;
    }

    public static void main(String[] args) {

    }
    class ErrorChar{
        char c;
        int index;
    }
}

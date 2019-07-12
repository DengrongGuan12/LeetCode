import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        gen(0, "", n, n);
        return res;
    }

    public void gen(int stackSize, String str, int pairNum, int n){
        if (pairNum == 0){
            res.add(str);
//            System.out.println(str);
            return;
        }
        if(stackSize == 0){
            gen(stackSize+1, str+"(", pairNum, n-1);
        }else{
            if(n > 0){
                gen(stackSize+1, str+"(", pairNum, n-1);
            }
            gen(stackSize - 1, str+")", pairNum - 1, n);

        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.gen(0, "", 3, 3);
    }
}

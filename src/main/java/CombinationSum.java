import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, "");
        return res;
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    private void combinationSum(int[] candidate, int target, String tmp){
        if (target == 0){
            String[] tmps = tmp.split(",");
            if (tmps.length > 0){
                List<Integer> integers = new ArrayList<Integer>();
                for (String t:tmps) {
                    if (!t.equals("")){
                        integers.add(Integer.parseInt(t));
                    }
                }
                res.add(integers);
            }
            return;
        }else if (target < 0){
            return;
        }else{
            for (int c: candidate
                 ) {
                combinationSum(candidate, target - c, tmp + "," + c);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new int[]{
                2,3,6,7
        }, 7);
    }
}

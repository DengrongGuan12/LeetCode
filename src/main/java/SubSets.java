import java.util.*;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<Integer>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
                1,2,3
        };
        SubSets subSets = new SubSets();
        subSets.subsets(nums);
    }
}

class SubSetsNoDup{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<Integer>(tmp));
        Set<Integer> set = new HashSet<Integer>();
        for (int j = i; j < nums.length; j++) {
            if (set.contains(nums[j])){
                continue;
            }
            set.add(nums[j]);
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
                1,2,2
        };
        SubSetsNoDup subSets = new SubSetsNoDup();
        subSets.subsetsWithDup(nums);
    }
}

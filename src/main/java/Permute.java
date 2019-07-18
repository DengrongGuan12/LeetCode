import java.util.*;

public class Permute {
//    public List<List<Integer>> permute(int[] nums) {
//        boolean[] visited = new boolean[nums.length];
//        findPermute(nums, visited, new Stack<Integer>());
//        return res;
//    }
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public void findPermute(int[] nums, boolean[] visited, Stack<Integer> list){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            list.push(nums[i]);
            findPermute(nums, visited, list);
            visited[i] = false;
            list.pop();
        }

    }

    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        permute.permute(new int[]{
                1,2,3
        });
    }
}

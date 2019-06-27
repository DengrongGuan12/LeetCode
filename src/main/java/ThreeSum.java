import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length > 0 && (nums[0] > 0 || nums[nums.length - 1] < 0)){
            return res;
        }
        for (int i = 0;i < nums.length - 2;i++){
            if (nums[i] > 0)continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                if (nums[i] + nums[l] + nums[r] == 0){
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);tmp.add(nums[l]);tmp.add(nums[r]);
                    res.add(tmp);
                    while(l<r&&nums[l]==nums[++l]);
                    while(l<r&&nums[r]==nums[--r]);
                }else if (nums[i] + nums[l] + nums[r] < 0){
                    while(l < r && nums[l] == nums[++l]);
                }else{
                    while (l < r && nums[r] == nums[--r]);
                }
            }
            while(i < nums.length - 3 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                -2,0,0,2,2
        };
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(nums);
    }
}

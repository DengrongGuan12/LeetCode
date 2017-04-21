package MinimumSizeSubarraySum;

/**
 * Created by dengrongguan on 2017/4/21.
 */
public class Main {
    public static void main(String[] args){
        Main main = new Main();
        int[] a = {2,3,1,2,4,3};
        System.out.println(main.minSubArrayLen(7,a));
    }
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int min = nums.length+1;
        for(int i = 0;i<nums.length;i++){
            int n = 1;
            int sum = nums[i];
            int j = i+1;
            while(sum < s && j < nums.length){
                sum += nums[j++];
                n++;
            }
            if(n == nums.length && sum < s){
                return 0;
            }
            if(j == nums.length && sum < s){
                n = min;
            }
            if(n<min){
                min = n;
            }
        }
        return min;
    }
}

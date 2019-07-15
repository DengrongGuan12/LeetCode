public class MaxSubArray {
    //[-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums){
        int tmp = nums[0];
        int max = nums[0];
        for (int i = 1;i<nums.length;i++){
//            if(tmp + nums[i] <= 0 || (tmp < 0 && nums[i] > 0)){
//                tmp = nums[i];
//            }else{
//                tmp += nums[i];
//            }
            if (tmp > 0){
                tmp += nums[i];
            }else{
                tmp = nums[i];
            }
            if(tmp > max){
                max = tmp;
            }
        }
        return max;
//        int ans = nums[0];
//        int sum = 0;
//        for(int num: nums) {
//            if(sum > 0) {
//                sum += num;
//            } else {
//                sum = num;
//            }
//            ans = Math.max(ans, sum);
//        }
//        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
//                -2,1,-3,4,-1,2,1,-5,4
//                -2,-3,-1, 1, -5
//                -1,1,2,1
                2,-4,5
        };
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));

    }
}

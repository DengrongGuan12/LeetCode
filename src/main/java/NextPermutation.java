public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i>=1 && nums[i-1] > nums[i]){
            i--;
        }
        if (i == 0){
            // 全部颠倒
            for (int j=0;j<nums.length/2;j++){
                int t = nums[j];
                nums[j] = nums[nums.length - 1 - j];
                nums[nums.length - 1 - j] = t;
            }
        }else{
            int minNumLargerThanI = i;
            int tmp = nums[i];
            for (int j=i+1;j<nums.length;j++){
                if (nums[j] > nums[i-1] && nums[j] < tmp){
                    minNumLargerThanI = j;
                    tmp = nums[j];
                }
            }
            nums[minNumLargerThanI] = nums[i-1];
            nums[i-1] = tmp;
            for(int j = nums.length - 1;j > i;j--){
                if (nums[j] < nums[j-1]){
                    int t = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = t;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
                2,3,1
        };
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        System.out.println(nums);
    }
}

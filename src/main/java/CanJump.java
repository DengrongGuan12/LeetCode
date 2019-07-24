public class CanJump {
    public boolean canJump(int[] nums){
        return canJump(nums, 0);
    }
    private boolean canJump(int[] nums, int start){
        if (start >= nums.length - 1){
            return true;
        }
        if (nums[start] == 0){
            return false;
        }
        for (int i = nums[start]; i >= 1 ; i--){
            if(canJump(nums, start + i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{
                2,3,1,1,4
        }));
    }
}

public class SearchRange {
//    public int[] searchRange(int[] nums, int target) {
//        if (nums.length == 0){
//            return new int[]{-1, -1};
//        }
//        return searchRange(nums, target, 0, nums.length -1);
//    }

    public int[] searchRange(int[] nums, int target, int l, int r){
        if (l == r){
            if (target == nums[l]){
                return new int[]{l,l};
            }else{
                return new int[]{-1, -1};
            }
        }
        int mid = (l+r)/2;
        if (nums[mid] < target){
            return searchRange(nums, target, mid+1, r);
        }else if (nums[mid] > target){
            return searchRange(nums, target, l, mid);
        }else{
            if (nums[mid + 1] == target){
                return new int[]{
                        searchRange(nums,target, l , mid)[0],
                        searchRange(nums, target, mid+1, r)[1]
                };
            }else{
                return searchRange(nums, target, l ,mid);
            }
        }
    }
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
                5,7,7,8,8,10
        };
        SearchRange searchRange = new SearchRange();
        int[] res = searchRange.searchRange(nums, 8);
        System.out.println(res);
    }
}

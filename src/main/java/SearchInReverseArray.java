public class SearchInReverseArray {
    public int search(int[] nums, int target) {
        if (nums.length > 0){
            return search(nums, target, 0, nums.length - 1);
        }
        return -1;
    }

    private int search(int[] nums, int target, int l, int r){
        if (l == r && nums[l] == target){
            return l;
        }else if (l == r && nums[l] != target){
            return -1;
        }
        int mid = l + (r-l)/2;
        if (nums[l] < nums[r]){
            if(nums[mid] >= target){
                return search(nums, target, l, mid);
            }else{
                return search(nums, target, mid + 1, r);
            }
        }else{
            if(nums[mid] < nums[l]){
                if (target >= nums[mid+1] && target <= nums[r]){
                    return search(nums, target, mid+1, r);
                }else{
                    return search(nums, target, l, mid);
                }
            }else{
                if(target >= nums[l] && target <= nums[mid]){
                    return search(nums, target, l, mid);
                }else{
                    return search(nums, target, mid+1, r);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{
          4,5,6,7,0,1,2
        };
        SearchInReverseArray searchInReverseArray = new SearchInReverseArray();
        System.out.println(searchInReverseArray.search(nums, 3));
    }
}

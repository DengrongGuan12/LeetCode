import java.util.PriorityQueue;

public class FindLastKthNum {

    public int findKth1(int[] nums, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int num: nums){
            if (priorityQueue.size() >= k){
                priorityQueue.poll();
            }
            priorityQueue.add(num);
        }
        return priorityQueue.peek();
    }

    public int findKth2(int[] nums, int k){
        int l=0, h = nums.length-1;
        k = nums.length - k;
        while(l < h){
            int m = partition(nums, l, h);
            if ( m == k){
                return nums[k];
            }
            if (m > k){
                h = m - 1;
            }else{
                l = m + 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] arr, int low, int high){
        int temp=arr[low];
        while(low<high){
            while(arr[high]>=temp&&high>low)
                high--;
            arr[low]=arr[high];
            while(arr[low]<=temp&&low<high)
                low++;
            arr[high]=arr[low];
        }
        arr[high]=temp;
        return high;
    }

    public static void main(String[] args) {
        FindLastKthNum findLastKthNum = new FindLastKthNum();
        System.out.println(findLastKthNum.findKth2(new int[]{
               5,3,2,1,4
        }, 3));
    }
}

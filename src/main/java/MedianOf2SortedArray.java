public class MedianOf2SortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        double res = 0;
        int i1 = 0, i2 = 0;
        if(length % 2 == 0){
            int mv = 0;
            double tmp1 = 0;
            double tmp2 = 0;
            while(i1 < nums1.length || i2 < nums2.length){
                while (i1<nums1.length && i2 < nums2.length && nums1[i1] == nums2[i2]){
                    mv ++;
                    if (mv == length/2){
                        return nums1[i1];
                    }
                    mv ++;
                    if (mv == length/2){
                        tmp1 = nums2[i2];
                        tmp2 = Math.min(nums1[i1+1], nums2[i2+1]);
                        return (tmp1 + tmp2)/2;
                    }
                    i1 ++;
                    i2 ++;
                }
                while (i1 < nums1.length && (i2 >= nums2.length || nums1[i1] < nums2[i2])){
                    mv ++;
                    if (mv == length/2){
                        tmp1 = nums1[i1];
                    }else if (mv == length/2 + 1){
                        tmp2 = nums1[i1];
                        return (tmp1+tmp2)/2;
                    }
                    i1 ++;
                }
                while(i2 < nums2.length && (i1 >= nums1.length || nums1[i1] > nums2[i2])){
                    mv ++;
                    if (mv == length/2){
                        tmp1 = nums2[i2];
                    }else if (mv == length/2 + 1){
                        tmp2 = nums2[i2];
                        return (tmp1+tmp2)/2;
                    }
                    i2 ++;
                }
            }
        }else{
            int mv = 0;
            while(i1 < nums1.length || i2 < nums2.length){
                while (i1<nums1.length && i2 < nums2.length && nums1[i1] == nums2[i2]){
                    mv++;
                    if (mv == length/2 + 1){
                        return nums1[i1];
                    }
                    mv++;
                    if (mv == length/2 + 1){
                        return nums1[i1];
                    }
                    i1 ++;
                    i2 ++;
                }
                while (i1 < nums1.length && (i2 >= nums2.length || nums1[i1] < nums2[i2])){
                    mv ++;
                    if (mv == length/2 + 1){
                        return nums1[i1];
                    }
                    i1 ++;
                }
                while(i2 < nums2.length && (i1 >= nums1.length || nums1[i1] > nums2[i2])){
                    mv ++;
                    if (mv == length/2 + 1){
                        return nums2[i2];
                    }
                    i2 ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{
                1,2
        };
        int[] num2 = new int[]{
                1,2,3
        };
        MedianOf2SortedArray medianOf2SortedArray = new MedianOf2SortedArray();
        System.out.println(medianOf2SortedArray.findMedianSortedArrays(num1, num2));
    }
}

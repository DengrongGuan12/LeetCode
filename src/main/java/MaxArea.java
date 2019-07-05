public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxarea = 0;
        while(i < j){

            while(i < j && height[i] <= height[j]){
                maxarea = Math.max(maxarea, (j-i)*height[i]);
                i++;
            }
            if (i < j && height[i] > height[j]){
                maxarea = Math.max(maxarea, (j-i) * height[j]);
                j--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        maxArea.maxArea(new int[]{2,3,10,5,7,8,9});
    }
}

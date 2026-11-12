class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int maxArea=Integer.MIN_VALUE;
        int left=0;
        int right=n-1;
        while(left<=right){
            int curr=Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(maxArea,curr);
            if(height[left]<height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}
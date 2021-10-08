package array;

/*
* https://leetcode.com/problems/container-with-most-water/
* 11. Container With Most Water
* Medium
*   Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
    Example 2:

    Input: height = [1,1]
    Output: 1
    Example 3:

    Input: height = [4,3,2,1,4]
    Output: 16
* */
public class MaxWaterStore {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int maxAreaCount = 0;

        while(i < j){
            int leftPointer = height[i];
            int rightPointer = height[j];
            int area = (j - i) * Math.min(leftPointer, rightPointer);
            if(area > maxAreaCount) maxAreaCount = area;
            if(leftPointer < rightPointer){
                i++;
            }else{
                j--;
            }
        }

        return maxAreaCount;
    }

    public int maxAreaBrouteForce(int[] height) {
        int len = height.length;
        int maxArea = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int area = (j - i) * Math.min(height[i], height[j]);
                if(area > maxArea) maxArea = area;
            }
        }

        return maxArea;
    }
}

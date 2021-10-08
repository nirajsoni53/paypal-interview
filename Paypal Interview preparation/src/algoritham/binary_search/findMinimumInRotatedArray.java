package algoritham.binary_search;

/*
* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*153. Find Minimum in Rotated Sorted Array
* Medium
 * */
public class findMinimumInRotatedArray {

    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] < nums[nums.length - 1]) return nums[0];
        int peak = findPeak(nums);
        return nums[peak + 1];
    }
    private int findPeak(int[] nums){
        int len = nums.length;
        if(len == 0) return -1;
        if(nums[0] < nums[len-1]) return len-1;

        int start = 0;
        int end = len - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            } else if(mid > start && nums[mid] < nums[mid - 1]){
                return mid -1;
            } else if(nums[mid] <= nums[end]){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }
}

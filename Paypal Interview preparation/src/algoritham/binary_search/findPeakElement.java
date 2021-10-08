package algoritham.binary_search;

/*
* https://leetcode.com/problems/find-peak-element/
* 162. Find Peak Element
* Medium
*
* https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/
* 852. Peak Index in a Mountain Array
* Easy
 * */
public class findPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;

            if(nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}

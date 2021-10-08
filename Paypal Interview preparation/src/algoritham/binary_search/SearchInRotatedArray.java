package algoritham.binary_search;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
* 33. Search in Rotated Sorted Array
* Medium
* */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int peak = findPeak(nums);
        if(peak == -1) return -1;
        int result = binarySearch(nums, target, 0, peak);
        if(result != -1) return result;
        return binarySearch(nums, target, peak + 1, nums.length-1);
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
            } else if(nums[mid] < nums[start]){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }

    private int findPeakWithDuplicate(int[] nums){
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
            }
            /* e.g. 2 1 1 2 2 2 2 2
                    s     m       e
               e.g  1 1 1 1 1 1 2 1
                    s     m       e
            */
            else if(nums[start] == nums[mid] && nums[end] == nums[mid]){
                if(nums[start] > nums[start+1]) return start;
                start++;
                if(nums[end] < nums[end-1]) return end - 1;
                end--;
            }
            /*
                e.g  1 1 1 1 1 1 2 0
                     s     m       e
            * */
            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[end] < nums [mid])){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return start;
    }

    private int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target) start = mid + 1;
            else if (nums[mid] > target) end = mid - 1;
            else return mid;
        }
        return -1;
    }
}

package algoritham.sliding_window;

/*
* https://leetcode.com/problems/sliding-window-maximum/submissions/
* 239. Sliding Window Maximum
  Hard

* You are given an array of integers nums,
* there is a sliding window of size k which is moving from the
* very left of the array to the very right.
* You can only see the k numbers in the window.
* Each time the sliding window moves right by one position.

  Return the max sliding window.
*
*
*   Example 1:
    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]

    Example 2:
    Input: nums = [1], k = 1
    Output: [1]

    Example 3:
    Input: nums = [1,-1], k = 1
    Output: [1,-1]

    Example 4:
    Input: nums = [9,11], k = 2
    Output: [11]

    Example 5:
    Input: nums = [4,-2], k = 2
    Output: [4]


  Explanation:
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
* */
public class maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        int maxResult = Integer.MIN_VALUE;
        int index = Integer.MIN_VALUE;
        int i = 0;
        int j = i + k - 1;

        while(j < nums.length){
            if(index < i){
                int[] arr = findMax(nums, i, j);
                maxResult = arr[0];
                index = arr[1];
            }else if(i <= index && index <= j){
                if(nums[j] >= maxResult){
                    maxResult = nums[j];
                    index = j;
                }
            }
            result[i] = maxResult;
            i++;
            j++;
        }

        return result;
    }

    int[] findMax(int[] nums, int i, int j){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int k = i; k <= j; k++){
            if(max <= nums[k]) {
                max = nums[k];
                index = k;
            }
        }
        return new int[]{max, index};
    }
}

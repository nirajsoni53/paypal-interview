package array;

/*
* https://leetcode.com/problems/next-permutation/
* 31. Next Permutation
* Medium
*
    Example 1:
    Input: nums = [1,2,3]
    Output: [1,3,2]

    Example 2:

    Input: nums = [3,2,1]
    Output: [1,2,3]
    Example 3:

    Input: nums = [1,1,5]
    Output: [1,5,1]
* */
public class nextPermutaion {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) return;

        int idx = -1;

        //Find the element which is greter then its previous number.
        for(int i = n - 1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                idx = i;
                break;
            }
        }
        // if all are in decending order return reverse means asending order.
        if(idx == -1) reverse(nums, 0, n -1);
        else{
            int prev = idx;
            for(int i = idx + 1; i < n; i++){
                if(nums[i] > nums[idx - 1] && nums[i] <= nums[prev]){
                    prev = i;
                }
            }

            swap(nums, idx - 1, prev);
            reverse(nums, idx, n-1);
        }
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}

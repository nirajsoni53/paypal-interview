package array;

import java.util.HashSet;
import java.util.Set;


/*
* https://leetcode.com/problems/longest-consecutive-sequence/
* 128. Longest Consecutive Sequence
* Medium
* It Has 3 solutions O(n)^3, O(1) || O(nLogN), O(1) || O(n), O(n)
*
*
* Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

* You must write an algorithm that runs in O(n) time.

    Example 1:

    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
    Therefore its length is 4.

    Example 2:

    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9


    Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
*
*
* */
public class LongestConsicutiveSequnce {

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) return len;
        Set<Integer> numbers = new HashSet<>();
        for(int number : nums) numbers.add(number);

        int maxConsucutiveSequence = 0;
        for(int number :nums){
            if(!numbers.contains(number - 1)){
                maxConsucutiveSequence  = Math.max(maxConsucutiveSequence , findTheMaxSequence(number,                                                                                                          numbers));
            }
        }
        return maxConsucutiveSequence;
    }

    private int findTheMaxSequence(int number,  Set<Integer> numbers){
        int count = 0;
        while(numbers.contains(number)){
            number++;
            count++;
        }
        return count;
    }

}

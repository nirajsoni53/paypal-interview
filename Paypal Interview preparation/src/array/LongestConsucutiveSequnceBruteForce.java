package array;

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
public class LongestConsucutiveSequnceBruteForce {

    public int longestConsecutive(int[] A)
    {
        int max = 0;

        for (int n : A)
        {
            int count = 0;

            while(arrayContains(A, n++))
                count++;

            max = Math.max(max, count);
        }
        return max;
    }

    private boolean arrayContains(int[] A, int n)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] == n)
                return true;
        }
        return false;
    }
}

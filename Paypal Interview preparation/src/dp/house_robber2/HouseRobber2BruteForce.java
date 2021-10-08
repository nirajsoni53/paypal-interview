package dp.house_robber2;

/*
* Time: 2 * O(2 ^ n)
* Space: O(1)
*
* https://leetcode.com/problems/house-robber-ii/
* 213. House Robber II
* Medium
* Circular problem
*
* e.g 1,2,3,1
*
* Here we separate this problem into two sub part
* 1. start idx 0 to n-2  = [1,2,3] 1 is ignor at idx 3
* 2. start idx 1 to n-1 = [2,3,1] 1 is ignor at idx 0
* find max(1, 2);
*
* */
public class HouseRobber2BruteForce {
    public int rob(int[] nums) {
        int len = nums.length;

        if(len == 0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);

        return Math.max(rob(nums, 0, len-1), rob(nums, 1, len));
    }

    private int rob(int[] nums, int start, int end){
        if(start >= end) return 0;

        int take = nums[start] + rob(nums, start + 2, end);
        int skip = rob(nums, start + 1, end);

        return Math.max(take, skip);
    }

    public static void main(String[] args) {
        new HouseRobber2BruteForce().rob(new int[]{1,2,3});
        new HouseRobber2BruteForce().rob(new int[]{1,2,3,1});
        new HouseRobber2BruteForce().rob(new int[]{2,3,2});
    }
}

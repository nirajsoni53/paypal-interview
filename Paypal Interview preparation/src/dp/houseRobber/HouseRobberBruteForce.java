package dp.houseRobber;

/*
* O(2^n) Time
*
*
* https://leetcode.com/problems/house-robber/
* 198. House Robber
* Medium
* You are a professional robber planning to rob houses along a street.
* Each house has a certain amount of money stashed, the only constraint
* stopping you from robbing each of them is that adjacent houses have
* security systems connected and it will automatically contact the police
* if two adjacent houses were broken into on the same night.
  Given an integer array nums representing the amount of money of each house,
  return the maximum amount of money you can rob tonight without alerting the police.

    Example 1:

    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.

    Example 2:

    Input: nums = [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
    Total amount you can rob = 2 + 9 + 1 = 12.
* */
public class HouseRobberBruteForce {
    public int rob(int[] nums) {
        return rob(nums, 0);
    }

    private int rob(int[] nums, int currentIdx) {
        if(currentIdx >= nums.length) return 0;

        /*
        * here if we choose 2 then we go for next sub array skipping 1.
        * that's why we consider currentIdx + 2 and nums[currentIdx] is for add current
        * number value.
        *
        *
        * e.g if we choose 2 then remaining part is 9,3,1 so, our ans will be 2 + ans(9,3,1)
        *     but if we choose 7 then remaining part would be either choose 3,1 or choose 9.
        * */
        int choose = nums[currentIdx] + rob(nums, currentIdx + 2);
        int skip = rob(nums, currentIdx + 1);

        //after make all decisions return max of number we get after choose or skip elements.
        return Math.max(choose, skip);
    }

    public static void main(String[] args) {
        new HouseRobberBruteForce().rob(new int[]{1,2,3,1});
        new HouseRobberBruteForce().rob(new int[]{2,7,9,3,1});
    }
}

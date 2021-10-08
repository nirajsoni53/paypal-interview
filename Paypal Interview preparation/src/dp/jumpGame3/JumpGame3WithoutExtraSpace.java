package dp.jumpGame3;

/*
   TIME: O(N)
   Space: O(1)
 * https://leetcode.com/problems/jump-game-iii/
 * 1306. Jump Game III
 * Medium
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 * */
public class JumpGame3WithoutExtraSpace {
    public boolean canReach(int[] arr, int start) {
        int len = arr.length;
        if(len == 1) return arr[0] == 0;

        return canReachHelper(arr, start, len);
    }

    public boolean canReachHelper(int[] nums, int start, int len) {
        if(start > len - 1 || start < 0 || nums[start] < 0) return false;
        if(nums[start] == 0) return true;
        nums[start] = -nums[start];

        return canReachHelper(nums, start + nums[start], len) ||                                  canReachHelper(nums, start - nums[start], len);
    }

    public static void main(String[] args) {
        new JumpGame3BruteForce().canReach(new int[]{4,2,3,0,3,1,2}, 5);
        new JumpGame3BruteForce().canReach(new int[]{4,2,3,0,3,1,2}, 0);
        new JumpGame3BruteForce().canReach(new int[]{3,0,2,1,2}, 2);
    }
}

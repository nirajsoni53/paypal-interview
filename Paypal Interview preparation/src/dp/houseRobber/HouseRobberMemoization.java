package dp.houseRobber;


/*
* O(n) Time
* O(n) Space
* */
public class HouseRobberMemoization {

    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return rob(nums, 0, dp);
    }

    private int rob(int[] nums, int currentIdx, Integer[] dp) {
        if(currentIdx >= nums.length) return 0;

        if(dp[currentIdx] != null){
            return dp[currentIdx];
        }

        int choose = nums[currentIdx] + rob(nums, currentIdx + 2, dp);
        int skip = rob(nums, currentIdx + 1, dp);

        return dp[currentIdx] = Math.max(choose, skip);
    }

    public static void main(String[] args) {
        new HouseRobberBruteForce().rob(new int[]{1,2,3,1});
        new HouseRobberBruteForce().rob(new int[]{2,7,9,3,1});
    }
}

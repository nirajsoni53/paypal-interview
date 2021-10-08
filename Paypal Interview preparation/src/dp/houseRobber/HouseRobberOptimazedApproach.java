package dp.houseRobber;

public class HouseRobberOptimazedApproach {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;

        if(len == 1) return nums[0];

        if(len == 2) return Math.max(nums[0], nums[1]);

        Integer[] dp = new Integer[len];
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
        new HouseRobberOptimazedApproach().rob(new int[]{1,2,3,1});
        new HouseRobberOptimazedApproach().rob(new int[]{2,7,9,3,1});
    }
}

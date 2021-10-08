package dp.houseRobber;

/*
* O(n)
* O(n)
* */
public class HouseRobberOptimized2 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;

        if(len == 1) return nums[0];

        if(len == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        /*
        * here dp made like.
        *
        * e.g 2, 7, 9, 3, 1
        *
        *    0  1  2  3  4
        * dp[2, 7, 11, 11, 12]
        * */
        for(int i = 2; i < len; i++){
            // here we are check
            // idx 3 -> max(nums[3] + nums[1], nums[2])
            // we always try to compute new dp value by comparing
            // previous possible answers.
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        new HouseRobberOptimized2().rob(new int[]{1,2,3,1});
        new HouseRobberOptimized2().rob(new int[]{2,7,9,3,1});
    }
}

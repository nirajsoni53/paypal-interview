package dp.houseRobber;

/*
* O(n) Time
* O(1) Space
* */
public class HouseRobberMostOptimized {
    public int rob(int[] nums) {
        int len = nums.length;

        //Base case
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);

        //rather then use dp array we can use two variables to update
        //i -2 & i - 1 value.
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        /*it's optimized version of HouseRobberOptimized2.java dp problem*/
        for(int i = 2; i < len; i++){
            int temp = Math.max(nums[i] + first, second);
            first = second;
            second = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        new HouseRobberMostOptimized().rob(new int[]{1,2,3,1});
        new HouseRobberMostOptimized().rob(new int[]{2,7,9,3,1});
    }
}

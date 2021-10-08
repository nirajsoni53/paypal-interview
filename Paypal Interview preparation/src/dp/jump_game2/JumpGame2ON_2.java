package dp.jump_game2;

/*
* Greedy approach
* O(n)
* https://leetcode.com/problems/jump-game-ii/submissions/
* Medium
* */
public class JumpGame2ON_2 {
    public int jump(int[] nums) {
        if(nums.length == 1 || nums[0] == 0)
            return 0;
        int maxReach = nums[0];
        int jump = 0;
        int currentMax = 0;
        for(int i = 0; i < nums.length -1; i++)
        {
            int maxJumpFromCurr = i + nums[i];
            if(maxJumpFromCurr > currentMax) currentMax = maxJumpFromCurr;

            /*
            * Update the max reach if i == maxReach
            * Step 1: maxReach = 2
            * i = 0, current max = 2
            * i = 1, current max = 4
            * i = 2, current max = 3
            *
            * i == maxReach = then maxReach = 4
            * jump = 1
            *
            * i = 3, current max = 4
            * i = 4, current max = 8
            *
            * i == maxReach = then maxReach = 8
            * jump = 2
            *
            * So, we can say that we can reach 4 from 2 jumps.
            * */
            if(i == maxReach){
                jump++;
                maxReach = currentMax;
            }
        }
        return jump + 1;
    }
}

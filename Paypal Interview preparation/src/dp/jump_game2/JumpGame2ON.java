package dp.jump_game2;

import dp.jump_game.JumpGameIsPossibleON;

/* 0 1 2 3 4
* [2,3,1,1,4]
*  l   r
* start moving from left to right and find max distance from
* any location.
*
* max = 0;, max = 2 (0 + 2), max = 4 (1 + 3) , max = 3 (2 + 1)
* round 1 max is 4 which is our output.
*
* steps = 1;
*[2,3,1,1,4]
*     l   r
* if(r == lastIdx) return steps + 1; which is 2
*
* [7,0,9,6,9,6,1,7,9,0,1,2,9,0,3]
*  l             r
* after perform round 1 max = 14(7(index) + 7(value))
* if(r == lastIdx) return steps + 1; which is 2
* */
public class JumpGame2ON {
    public int jump(int[] nums) {
        if(nums.length == 1 || nums[0] == 0)
            return 0;
        //java BFS Solution.
        int steps = 0;
        int left = 0;
        int right = nums[0]; // value of left index set as right index.
        while(right < nums.length-1)
        {
            int max = 0;
            //iterate through left to right and calculate max distance.
            for(int i=left;i<=right;i++)
                max = Math.max(max,(i + nums[i]));
            left = right;
            right = max;
            steps++;
        }
        return steps+1;
    }

    public static void main(String[] args) {
        //new JumpGameIsPossibleON().canJump(new int[]{1,2});
        //new JumpGame2ON().jump(new int[]{2,3,1,1,4});
        //new JumpGame2ON().jump(new int[]{2,2,0,0,4});
        new JumpGame2ON().jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3});
        //new JumpGameIsPossibleON().canJump(new int[]{3,2,1,0,4});
    }
}

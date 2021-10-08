package dp.jump_game2;

/*
 * O(n^2)
 * https://leetcode.com/problems/jump-game-ii/submissions/
 * Medium
 * */
public class JumpGameBruteForce {
    public int jump(int[] nums) {
        return canJump(0, nums);
    }

    private int canJump(int index, int[] nums){
        if(index >= nums.length-1) {
            return 0;
        }
        int current = nums[index];
        if (current == 0) return Integer.MAX_VALUE;

        /*
        * Here we check every possibilities like
        * e.g. 2,3,1,1,4
        *
        * start from current = 2
        * so from index 0 we can take 2 jumps, so we iterate loop and
        * got for possible jumps and do recursive call for others.
        *
        * idx 0 -> 2 jumps -> 3(idx 1), 1(idx 2)
        * idx 1 -> 3 jumps -> 1(idx 2), 1(idx 3), 4(idx 4)
        * idx 2 -> 1 jumps -> 1(idx 2)
        *
        * these all are sub recursive call of idx 0.
        * same we can iterate for others.
        * */
        int total = Integer.MAX_VALUE;
        for(int i = 1; i <= current; i++){
            int steps = canJump(index + i, nums);
            if (steps != Integer.MAX_VALUE){
                total = Math.min(total, steps+1);
            }
        }
        return total;
    }


    public static void main(String[] args) {
        new JumpGameBruteForce().jump(new int[]{2,3,1,1,4});
    }
}

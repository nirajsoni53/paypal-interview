package dp.jump_game;

public class JumpGameIsPossible {
    public boolean canJump(int[] nums) {
        return canJump(0, nums);
    }

    private boolean canJump(int start, int[] nums){
        if(start == nums.length-1) return true;
        int current = nums[start];
        for(int i = 1; i <= current; i++){
            if(canJump(start + i, nums)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new JumpGameIsPossible().canJump(new int[]{2,3,1,1,4});
        new JumpGameIsPossible().canJump(new int[]{3,2,1,0,4});
    }
}

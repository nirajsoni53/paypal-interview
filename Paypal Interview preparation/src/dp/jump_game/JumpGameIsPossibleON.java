package dp.jump_game;

public class JumpGameIsPossibleON {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        if(nums[0] == 0) return false;
        int maxIdxJump = 0;
        int minJumps = 0;

        for(int i = 0; i < nums.length; i++){
            int currentIdx = i + nums[i];
            if(i > maxIdxJump) return false;
            if(maxIdxJump >= nums.length-1) return true;
            if(currentIdx > maxIdxJump){
                maxIdxJump = currentIdx;
                minJumps++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new JumpGameIsPossibleON().canJump(new int[]{1,2});
        //new JumpGameIsPossibleON().canJump(new int[]{2,3,1,1,4});
        //new JumpGameIsPossibleON().canJump(new int[]{3,2,1,0,4});
    }
}

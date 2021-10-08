package array;

public class CanBeIncresing {

    public static boolean canBeIncreasing(int[] nums) {
        int len = nums.length;

        int first = 0; // 0, 1, 0
        int next = 1;  // 1, 2, 3
        boolean isMountainBreak = false;
        if(nums[first] >= nums[next]) {
            first++;
            next++;
            isMountainBreak = true;
        }
        // 0,1,2
        while(next < len){ //  1,1,1
            if(nums[first] >= nums[next]){
                if(isMountainBreak) return false;
                isMountainBreak = true;
                first = first - 1;
                continue;
            }
            first = next;
            next++;
        }
        return true;
    }

    public static void main(String[] args) {
        canBeIncreasing(new int[]{105,924,32,968});
    }
}

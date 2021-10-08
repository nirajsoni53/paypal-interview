package array;

/*
* https://leetcode.com/problems/find-the-duplicate-number/submissions/
* 287. Find the Duplicate Number
* Medium
* */
public class findDuplicate2 {
    public int findDuplicate(int[] nums) {
        if(nums.length == 0) return -1;
        for(int i = 0; i < nums.length; i++){
            int number = Math.abs(nums[i]);
            if(nums[number] < 0) return number;
            else nums[number] = -nums[number];
        }
        return -1;
    }
}

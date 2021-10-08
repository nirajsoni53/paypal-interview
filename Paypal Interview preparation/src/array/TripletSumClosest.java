package array;

import java.util.Arrays;

public class TripletSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int distance = Integer.MAX_VALUE;
        int currentClosestSum = 0;
        for(int i = 0; i < nums.length; i++){ //-1,2,1,-4
            int left = i + 1;
            int right = nums.length -1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int absSum = Math.abs(sum - target);
                if(absSum < distance){
                    distance = absSum;
                    currentClosestSum = sum;
                }
                if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return currentClosestSum;
    }
}

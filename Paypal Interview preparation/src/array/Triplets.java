package array;

import java.util.*;

public class Triplets {

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums); // -4, -1, -1, 0, 1, 2
                           //  i   l            r
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> store = new HashSet<>();
        for (int i = 0; i < nums.length-3; i++){
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                int target = 0 - nums[i];//4
                int l = nums[left];
                int r = nums[right];
                if (left > i + 1 && nums[left] == nums[left - 1]) { // pass duplicates for j
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right+1]) { // pass duplicates for k
                    right--;
                    continue;
                }

                if(l + r == target){
                    List<Integer> list = Arrays.asList(nums[i],l, r);
                    result.add(list);
                    left++;
                    right--;
                }else if(l + r < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));

    }
}

package algoritham.binary_search;

public class CeilingNumber {
    int ceilingOfNumber(int[] nums, int target){
        if(nums.length == 0) return -1;
        if(target > nums[nums.length - 1]) return -1;
        if(target < nums[0]) return nums[0];

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            } else return nums[mid];
        }
        return nums[start];
    }


    int floorOfNumber(int[] nums, int target){
        if(nums.length == 0) return -1;
        if(target > nums[nums.length - 1]) return nums[nums.length - 1];
        if(target < nums[0]) return -1;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            } else return nums[mid];
        }
        return nums[end];
    }

    public static void main(String[] args) {
        System.out.println(new CeilingNumber()
                .ceilingOfNumber(new int[]{2, 3, 5, 9, 14, 16, 18}, 6));
        System.out.println(new CeilingNumber()
                .floorOfNumber(new int[]{2, 3, 5, 9, 14, 16, 18}, 5));
    }
}

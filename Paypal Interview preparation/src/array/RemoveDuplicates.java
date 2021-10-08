package array;

import java.util.Arrays;

public class RemoveDuplicates {

    int remove_duplicate(int A[],int N){
        if(N == 0 || N == 1) return N;
        int currentNumber = A[0];
        int currentSwapPosition = 0;
        int count = 1;
        for(int i=1; i<N; i++){
            if(currentNumber != A[i]){ //1, 2, 3, 4, 2, 3, 4
                currentNumber = A[i];
                count++;
                currentSwapPosition++;
                if(currentSwapPosition != i){
                    A[currentSwapPosition] = A[i];
                }
            }
        }
        return count;
    }

    static int remove_duplicate_two_pointer(int A[],int N){
        if(N == 0 || N == 1) return N;
        int cPointer = 0;
        int nPointer = 1;

        while(nPointer < N){
            if(A[cPointer] != A[nPointer]){ //112223
                cPointer++;
                if(cPointer != nPointer) A[cPointer] = A[nPointer];
            }
            nPointer++;
        }
        return cPointer + 1;
    }

    public int removeDuplicates2(int[] nums) { // 112223
        if(nums == null || nums.length == 0) return 0;
        //int[] arr = new int[nums.length];
        int currentNumber = Integer.MIN_VALUE;
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            if(currentNumber != nums[i]){
                currentNumber = nums[i];
                nums[counter] = currentNumber;
                counter++;
            }
        }
        //System.arraycopy(arr,0, nums, 0 , nums.length);
        return counter;
    }

    public static int removeDuplicates(int[] nums) { // 112223
        if(nums == null || nums.length == 0) return 0;
        int[] arr = new int[nums.length];
        int currentNumber = Integer.MIN_VALUE;
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            if(currentNumber != nums[i]){
                currentNumber = nums[i];
                arr[counter] = currentNumber;
                counter++;
            }
        }
        System.arraycopy(arr,0, nums, 0 , nums.length);
        return counter;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,1,2,2,2,3};
        //removeDuplicates(a);
        remove_duplicate_two_pointer(a, 6);
        System.out.println(a);
    }
}

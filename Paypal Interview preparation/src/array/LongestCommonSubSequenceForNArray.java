package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubSequenceForNArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4,5,6}, {2,3,5,6}, {5,6,7}};
        int[] ans = findLongestSubsequenceInArrays(arr);

        System.out.println(Arrays.toString(ans));
        //print

    }

    public static int[] findLongestSubsequenceInArrays(int[][] arrays){
        //List<Integer> ans = new ArrayList<>();

        if(arrays.length == 0 || arrays[0].length == 0) return new int[]{};
        if(arrays.length == 1) return arrays[0];

        int[] first = arrays[0];
        int[] second = arrays[1];


        // [
        //  [1,2,3,4,5,6],
        //  [2,3,5,6],
        //  [5,6,7]
        // ]



        first = mergingArrays(first, second);

        if(first.length > 0){
            for(int k = 2; k < arrays.length; k++){
                if(first.length == 0){
                    return first;
                }
                second = arrays[k];
                first = mergingArrays(first, second);
            }
        }

        return first;
    }



    // 2, 3, 5, 6
    private static int[] mergingArrays(int[] first, int[] second){
        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();
        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                i++;
            }else if(first[i] > second[j]){
                j++;
            }else{
                ans.add(first[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[ans.size()];

        for(int p = 0; p < ans.size(); p++){
            result[p] = ans.get(p);
        }
        return result;
    }
}

package array;

import java.util.HashSet;

public class FirstDuplicate {

    static int firstDuplicateBruteForce(int[] a){
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++){
            for (int j = i+1; j< a.length; j++){
                if(a[i] == a[j]){
                    minIndex = Math.min(minIndex, j);
                }
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : a[minIndex];
    }

    static int firstDuplicateBySpaceComplexity(int[] a){
        HashSet<Integer> set = new HashSet<>();
        for (int input : a){
            if(set.contains(input)){
                return input;
            }
            set.add(input);
        }
        return -1;
    }

    static int firstDuplicateWithoutSpaceComplexity(int[] a){
        for (int i = 0; i< a.length; i++){
            int number = a[Math.abs(a[i])- 1];
            if(number < 0){
                return Math.abs(a[i]);
            }else{
                a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //firstDuplicateBruteForce(new int[]{1, 2, 3, 2, 1});
        //firstDuplicateBySpaceComplexity(new int[]{1, 2, 3, 4, 5});
        firstDuplicateWithoutSpaceComplexity(new int[]{1, 2, 3, 2, 1});
    }
}

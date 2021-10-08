package array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {
    // 0  1  2  3  4  5  6
    // 1, 2, 3, 4, 5, 1, 4
    static List<Integer> findDuplicateFromArray(int[] a){
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < a.length){
            int num = a[i];
            if(num-1 == i) {
                i++;
                continue;
            }

            if(a[num-1]== num) {
                if(!list.contains(num))
                    list.add(num);
                i++;
            }else{
                swap(a, i, num - 1);
            }
        }
        return list;
    }

    static  List<Integer> findDuplicateFromArray2(int[] a){
        if(a.length == 0 || a.length == 1) new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            int index = Math.abs(a[i]) -1;
            if(a[index] < 0){
                list.add(Math.abs(a[i]));
            }
            a[index] = -a[index];
        }
        return list;
    }


    static void swap(int[] a, int index, int moveIndex){
        int temp = a[index];
        a[index] = a[moveIndex];
        a[moveIndex] = temp;
    }


    public static void main(String[] args) {
        //findDuplicateFromArray(new int[]{1, 2, 3, 4, 5, 1, 4});
        //findDuplicateFromArray(new int[]{1, 5, 2, 4, 1, 3, 4});
        findDuplicateFromArray2(new int[]{1, 5, 2, 4, 1, 3, 4});
    }
}

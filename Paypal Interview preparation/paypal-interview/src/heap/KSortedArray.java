package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KSortedArray {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(4,5,6));
        list.add(Arrays.asList(7,8,9));

        System.out.println(findKSortedArrayByMerging(list));
        System.out.println(findKSortedArrayByDivideAndConcour(list));
    }

    private static List<Integer> findKSortedArrayByMerging(List<List<Integer>> list) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> l: list){
            result.addAll(l);
        }
        Collections.sort(result);
        return result;
    }

    private static List<Integer> findKSortedArrayByDivideAndConcour(List<List<Integer>> list){
        if(list == null || list.isEmpty()) return null;
        return divideAndConcurHelper(list, 0, list.size()-1);
    }

    private static List<Integer> divideAndConcurHelper(List<List<Integer>> list, int start, int end){
        if(start == end) return list.get(start);
        int mid = (start + (end - start)) / 2;
        List<Integer> left = divideAndConcurHelper(list, start, mid);
        List<Integer> right = divideAndConcurHelper(list, mid+1, end);

        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int indexLeft = 0;
        int indexRight = 0;
        while (left.size() != indexLeft || right.size() != indexRight){
            if(left.size() == indexLeft){
                result.add(right.get(indexRight));
                indexRight++;
            }else if(right.size() == indexRight){
                result.add(left.get(indexLeft));
                indexLeft++;
            }else if(left.get(indexLeft) <= right.get(indexRight)){
                result.add(left.get(indexLeft));
                indexLeft++;
            }else if(left.get(indexLeft) > right.get(indexRight)){
                result.add(right.get(indexRight));
                indexRight++;
            }
        }
        return result;
    }
}

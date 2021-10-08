package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KSortedArrayByMerging {

    /* O(N logN) where n is length of elements after merge all array */
    private static List<Integer> findKSortedArrayByMerging(List<List<Integer>> list) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> l: list){
            result.addAll(l);
        }
        Collections.sort(result);
        return result;
    }
}

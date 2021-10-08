package dp.pascal_triangle;

import java.util.ArrayList;
import java.util.List;

/*
* Time : O(N * k), n = no of rows and k = no of modification in particular row.
* Space: O(N) if we consider result other wise O(1)
* */
public class PascalTriangle2Improved {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            result.add(1);
        }

        // 1 3 1 1 1
        // 0 1 2 3 4
        for(int i = 2; i <= rowIndex; i++){
            int prevK = 0;//2
            for(int k = 1; k < i ; k++){
                int prev = k == 1 ? result.get(k - 1) : prevK; //1
                int current =  result.get(k); //2
                prevK = result.get(k);
                result.set(k, (prev + current));
            }
        }
        return result;
    }
}

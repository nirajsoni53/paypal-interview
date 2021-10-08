package dp.pascal_triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Time: O(n2)
* Space: O(N)
*
* Here we can use pascal triangle 1 solution which is
* Time: O(n2) and Space: O(n2) but we are using slightly
* improved solution.
*
* Here we cal calculate value every column for every row.
* and first and last value is 1
*
*        1
*       1 1
*      1 2 1
*     1 3 3 1
* */
public class PascalTriangle2BruteForce {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = null, prev = null;
        for(int i = 0; i <= rowIndex; i++){
            row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(prev.get(j-1) + prev.get(j));
                }
            }
            if(i == rowIndex) return row;
            prev = row;
        }
        return row;
    }

    public static void main(String[] args) {
        new PascalTriangle2BruteForce().getRow(3);
    }
}

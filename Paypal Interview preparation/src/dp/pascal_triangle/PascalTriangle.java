package dp.pascal_triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Time: O(n2)
* Space: O(n2)
*
* Pascal Triangle formula for find value at particular row and column.
*
* r = row
* c = col
*
* Formula: (r-1) * C * (c-1)
*
* if row is 4 and column is 3 then formula will be
* (4 - 1) * C * (3 - 1) = 3C2 = (3 * 2) / (2 * 1)
* Here, (3 * 2) is 3! up to 2 numbers because in division part is
* 2! which is (2 * 1) so we stop by 2 numbers for (3 * 2).
*
*
* e.g if formula is 5C4 = (5 * 4 * 3 * 2)/ (4 * 3 * 2 * 1)
* both have same length because of below part factorial total
* elements is 4.
*
*
* https://leetcode.com/problems/pascals-triangle/
* 118. Pascal's Triangle
* Easy
*
* Input: numRows = 5
* Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
*
*          1
*         1 1
*        1 2 1
*       1 3 3 1
*      1 4 6 4 1
*
* Here we are iterate j == i because for ith row we have to print
* i numbers.
* e.g i = 3 then j will iterate 0 to 3 which means 4 times.
* and print 1 3 3 1
*
 * */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result =  new ArrayList<>();
        /* Create row for current row and prev row data
        * to compute new row data.
        * */
        List<Integer> row, prev = null;
        for(int i = 0; i < numRows; i++){
            row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                // if column is 1st and last then its value is always 1.
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    //for compute next row we use previous row left and right element sum.
                    /*  1 1
                       # 2 #
                    */
                    row.add(prev.get(j-1) + prev.get(j));
                }
            }
            prev = row;
            result.add(row);
        }
        return result;
    }
}

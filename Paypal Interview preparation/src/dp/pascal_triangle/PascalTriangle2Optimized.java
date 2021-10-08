package dp.pascal_triangle;

import java.util.Arrays;
import java.util.List;

/*
* Time: O(n)
* Space: O(n) if consider result;
*
* https://leetcode.com/problems/pascals-triangle-ii/submissions/
* 119. Pascal's Triangle II
* Easy
* */
public class PascalTriangle2Optimized {
    /*
     The Base formula is NCR = row* C *col = (row! up to col / col!)
     e.g. 3C2 = (3! upto 2 no / 2!) = (3 * 2 / 2 * 1) = 3
     but for better under stand we can say.
     R! = R * (R - 1)!

     If i want find NCR for 4C2 = (4C1(prev) * (4(row) - 2(col) + 1)) / 2(col) ;

           4C0 = 1 always for 0 col.
     for   4C1 = (4CO * (4 - 1 + 1)) / 2 =  (1 * (4)) / 1 = 4;
     for   4C2 = (4C1 * (4 - 2 + 1)) / 2 = (4 * (3)) / 2 = 6;
     for   4C3 = (4C2 * (4 - 3 + 1)) / 3 = (6 * (2)) / 3 = 4;
     etc...

   */
    public List<Integer> getRow(int rowIndex){
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;
        for(int i = 1; i <= rowIndex; i++){
            long value = ((long)result[i - 1] * (rowIndex - i + 1));
            result[i] = (int)(value / i);
        }
        return Arrays.asList(result);
    }
}

package dp.uniquePaths2;

/*
* Time : O(m*n)
* Space : O(m*n)
*
* https://leetcode.com/problems/unique-paths-ii/
* 63. Unique Paths II
* Medium
*
* Algorithm here is first update 1st row and col
* and if found obsticles in 1st row or col after obsticles don't update the value.
*
* After that start loop from i = 1, j = 1 and check if obsticles found then make it 0.
* So, for in summation it will not count.
 * */
public class UniquePathOptimized {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if(row == 0 || col == 0 || obstacleGrid[0][0] == 1) return 0;

        int[][] cache = new int[row][col];


        /*
          For every column

          if found obstacles in first column then after obstacles don't change
          column value to 1.

          e.g Before 0                  After 1
                     0                        1
                     1                        0
                     0                        0
        */
        for(int i = 0; i < row; i++){
            if(obstacleGrid[i][0] == 1) break;
            cache[i][0] = 1;
        }


        /*
          For every row

          if found obstacles in first row then after obstacles don't change
          row value to 1.

          e.g
          Before: 0 0 1 0 0   After: 1 1 0 0 0
        */
        for(int i = 0; i < col; i++){
            if(obstacleGrid[0][i] == 1) break;
            cache[0][i] = 1;
        }


        /*
           if obstacles found in other row then make it 0 so it will not use in
           addition.

           e.g

           0  0  0  0
           0  1  0  0
           0  0  1  0

           Here there are 2 obstacles so after run above loops result will be.

           1  1  1  1
           1  1  0  0
           1  1  1  0

           After run this loop from i = 1, j = 1 matrix look like
           first obstacles found at index(1,1) so make it 0.
           and for find current cell value  = (i - 1, j) + (i, j - 1)
           which one step left and up.

           1  1  1  1
           1  0  1  2
           1  1  2  4

           here our answer will be 4.
        */
        for(int i = 1; i < cache.length; i++){
            for(int j = 1; j < cache[0].length; j++){
                if(obstacleGrid[i][j] == 1) cache[i][j] = 0;
                else cache[i][j] = cache[i-1][j] + cache[i][j - 1];
            }
        }
        return cache[row - 1][col - 1];
    }
}

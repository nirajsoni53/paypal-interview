package dp.uniquePaths2;


/*
  https://leetcode.com/problems/unique-paths-ii/
  63. Unique Paths II
  Medium

* Time: O(m * n)
* Time: O(m * n)
*
* S  0  0
* 0  1  0
* 0  0  E
*
* 1 indicate obstacle

                        Story :

  A robot is located at the top-left corner of a m x n grid
  (marked 'Start' in the diagram below).
  The robot can only move either down or right at any point in time.
  The robot is trying to reach the bottom-right corner of the grid
  (marked 'Finish' in the diagram below).

  Now consider if some obstacles are added to the grids. How many unique paths would there be?

  An obstacle and space is marked as 1 and 0 respectively in the grid.

    Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
    Output: 2
    Explanation: There is one obstacle in the middle of the 3x3 grid above.
    There are two ways to reach the bottom-right corner:
    1. Right -> Right -> Down -> Down
    2. Down -> Down -> Right -> Right
* */
public class UniquePath2BruteForceOptimized {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, cache);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int[][] cache) {
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) return 0;

        else if(cache[i][j] != 0) return cache[i][j];
        else if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) return 1;

        return cache[i][j] = uniquePathsWithObstacles(obstacleGrid, i, j + 1, cache) +
                uniquePathsWithObstacles(obstacleGrid, i + 1, j, cache);
    }
}

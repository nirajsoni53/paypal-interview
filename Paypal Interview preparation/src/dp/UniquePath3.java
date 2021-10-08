package dp;

/*
* https://leetcode.com/problems/unique-paths-iii/
* 980. Unique Paths III
* Hard
*
* Time: O(3^N) because every time we check 3 paths from
* every cell except it self.
*
*     1
*   / | \
*  2  3  4
* Space: O(N)
 * */
public class UniquePath3 {

    int paths = 0;
    public int uniquePathsIII(int[][] grid) {
        int row = grid.length;
        int col = 0;
        if(row == 0) return 0;
        col = grid[0].length;
        if(col == 0) return 0;

        /* Here we count empty space and starting position*/
        int totalEmpty = 0;
        int[] startPos = new int[2];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0) totalEmpty++;
                else if(grid[i][j] == 1){
                    startPos[0] = i;
                    startPos[1] = j;
                }
            }
        }

        // Make a call in 4 direction fromm starting point;
        dfs(grid, startPos[0] + 1, startPos[1], totalEmpty);
        dfs(grid, startPos[0] - 1, startPos[1], totalEmpty);
        dfs(grid, startPos[0], startPos[1] + 1, totalEmpty);
        dfs(grid, startPos[0], startPos[1] - 1, totalEmpty);

        return paths;
    }

    private void dfs(int[][] grid, int i, int j, int totalEmpty){
        // first 4 is boundry condition.
        // grid[i][j] == -1 is for check stone
        // grid[i][j] == 3 is for already visited cell.
        // grid[i][j] == 1 for starting position should not visit again.
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1
                || grid[i][j] == 3 || grid[i][j] == 1) return;

        // Cheking for end and if at the same time totalEmpty == 0 then we reach the path.
        if(grid[i][j] == 2){
            if(totalEmpty == 0) paths++;
            return;
        }

        grid[i][j] = 3;

        // direction call
        dfs(grid, i + 1, j, totalEmpty - 1);
        dfs(grid, i - 1, j, totalEmpty - 1);
        dfs(grid, i, j + 1, totalEmpty - 1);
        dfs(grid, i, j - 1, totalEmpty - 1);

        grid[i][j] = 0;
    }
}

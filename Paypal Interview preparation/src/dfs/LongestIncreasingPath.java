package dfs;

/*
* https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
* 329. Longest Increasing Path in a Matrix
* Hard
* */
public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 0 || col == 0) return 0;
        int[][] cache = new int[row][col];
        int longestPath = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int currentPath = dfs(matrix, cache, i, j, Integer.MIN_VALUE);
                longestPath = Math.max(currentPath, longestPath);
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int[][] cache, int i, int j, int prev){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length){
            return 0;
        }
        if(matrix[i][j] <= prev) return 0;
        if(cache[i][j] > 0) return cache[i][j];

        int r = dfs(matrix, cache, i + 1, j, matrix[i][j]);
        int l = dfs(matrix, cache, i - 1, j, matrix[i][j]);
        int t = dfs(matrix, cache, i, j + 1, matrix[i][j]);
        int b = dfs(matrix, cache, i, j - 1, matrix[i][j]);

        cache[i][j] = Math.max(Math.max(t,b), Math.max(l,r)) + 1;

        return Math.max(Math.max(t,b), Math.max(l,r)) + 1;
    }
}

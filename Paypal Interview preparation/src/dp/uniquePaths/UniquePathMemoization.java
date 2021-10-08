package dp.uniquePaths;

/*
* Time: O(n * m)
* Time: O(n * m)
* */
public class UniquePathMemoization {
    public int uniquePaths(int m, int n) {
        return uniquePaths(m, n, 0, 0, new int[m][n]);
    }

    public int uniquePaths(int m, int n, int i, int j, int[][] cache) {
        if(i >= m || j >= n) return 0;

        if(i == m - 1 && j == n - 1) return 1;

        if(cache[i][j] != 0) return cache[i][j];

        return cache[i][j] = uniquePaths(m, n, i, j + 1, cache) +
                             uniquePaths(m, n, i + 1, j, cache);
    }
}

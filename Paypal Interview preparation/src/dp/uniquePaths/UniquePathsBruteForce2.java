package dp.uniquePaths;

/*
 * Time: O(2^n)
 * Space: O(1)
 * */
public class UniquePathsBruteForce2 {

    public int uniquePaths(int m, int n) {
        return uniquePaths(m, n, 0, 0);
    }

    public int uniquePaths(int m, int n, int i, int j) {
        if(i >= m || j >= n) return 0;

        if(i == m - 1 && j == n - 1) return 1;

        return uniquePaths(m, n, i, j + 1) +
                  uniquePaths(m, n, i + 1, j);
    }
}

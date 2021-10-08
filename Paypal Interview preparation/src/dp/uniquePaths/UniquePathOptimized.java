package dp.uniquePaths;

public class UniquePathOptimized {
    /*
      Here if we have 2 * 3 matrix
           0  1  2
        0  S  0  0
        1  0  0  E

        here to reach the end we have to take m right(2) and n down(1) steps

        m - 1 = 2
        n - 1 = 1

        N = (m - 1) + (n -1) = m + n - 2 = 3(row) + 2(col) - 2;
        R = m - 1 or n - 1; either got down or right.

        Time: O(M - 1) OR O(N -1) = R
        Space: O(1)
    */
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int R = m - 1;// also we can choose n-1;
        long res = 1;

        for(int i = 1; i <= R; i++){
            res = (res * (N - R + i)) / i;
        }

        return (int)res;
    }
}

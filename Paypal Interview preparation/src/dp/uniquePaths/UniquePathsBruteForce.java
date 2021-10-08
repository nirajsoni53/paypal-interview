package dp.uniquePaths;


/*
* Time: O(2^n)
* Space: O(n)
* */
public class UniquePathsBruteForce {

    int result = 0;
    public int uniquePaths(int m, int n) {
        boolean[][] paths = new boolean[m][n];
        uniquePaths(paths, 0, 0);
        return result;
    }

    public void uniquePaths(boolean[][] paths, int i, int j) {
        if(i >= paths.length || j >= paths[0].length) return;

        if((i == paths.length - 1 && j == paths[0].length - 1) || paths[i][j]){
            result++;
            return;
        }
        paths[i][j] = true;

        //move right side
        uniquePaths(paths, i, j + 1);
        //move down side
        uniquePaths(paths, i + 1, j);

        paths[i][j] = false;
    }

    public static void main(String[] args) {
        new UniquePathsBruteForce().uniquePaths(3, 7);
    }
}

package array.set_matrix_zeroes;

public class SetMatrixZerosBruteforce {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 0 || col == 0) return;

        boolean[][] cache = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    dfs(cache, i - 1, j, "UP");
                    dfs(cache, i + 1, j, "DOWN");
                    dfs(cache, i, j + 1, "LEFT");
                    dfs(cache, i, j - 1, "RIGHT");
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(cache[i][j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void dfs(boolean[][] cache, int i, int j, String direction){
        if(i < 0 || j < 0 || i >= cache.length || j >= cache[0].length)
            return;
        if(!cache[i][j])
            cache[i][j] = true;
        if(direction == "UP"){
            dfs(cache, i - 1, j, direction);
        }else if(direction == "DOWN"){
            dfs(cache, i + 1, j, direction);
        }else if(direction == "LEFT"){
            dfs(cache, i, j + 1, direction);
        }else{
            dfs(cache, i, j - 1, direction);
        }
    }
}

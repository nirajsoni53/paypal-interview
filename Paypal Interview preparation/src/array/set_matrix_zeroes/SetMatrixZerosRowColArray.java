package array.set_matrix_zeroes;

public class SetMatrixZerosRowColArray {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 0 || col == 0) return;

        boolean[] rowArr = new boolean[row];
        boolean[] colArr = new boolean[col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0) rowArr[i] = colArr[j] =  true;
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if((rowArr[i] || colArr[j]) && matrix[i][j] != 0) matrix[i][j] = 0;
            }
        }
    }
}

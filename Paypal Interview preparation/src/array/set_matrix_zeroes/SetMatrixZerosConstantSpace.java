package array.set_matrix_zeroes;

public class SetMatrixZerosConstantSpace {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 0 || col == 0) return;

        boolean isFirstColZero = false;

        for(int i = 0; i < row; i++){
            if(!isFirstColZero && matrix[i][0] == 0)
                isFirstColZero = true;
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }

        for(int i = row - 1; i >= 0; i--){
            for(int j = col-1; j >= 1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(isFirstColZero) matrix[i][0] = 0;
        }
    }


    public static void main(String[] args) {
        //int[][] arr = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][] arr = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        new SetMatrixZerosConstantSpace().setZeroes(arr);
    }
}

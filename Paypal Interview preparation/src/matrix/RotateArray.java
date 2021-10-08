package matrix;

/*
* https://leetcode.com/problems/rotate-image/
* 48. Rotate Image
* Medium
*
* Step 1: transpose the array
*
* Original     Transpose
* 1 2 3        1 4 7
* 4 5 6        2 5 8
* 7 8 9        3 6 9
*
* swap every matrix[i][j] to matrix[j][i]
* e.g index 0,1 will swap with index 1,0
*
*      0 1         0 1
* 0 -> 1 2   to    1 4
* 1 -> 4           2
*
* After this swap column 1st element with last
* 0 will swap with 2
* 1 will swap with 1
*
* Transpose    Rotated
* 1 4 7        7 4 1
* 2 5 8        8 5 2
* 3 6 9        9 6 3
* */
public class RotateArray {

    public void rotate(int[][] matrix){

        /* Transpose matrix */
        for(int i = 0; i < matrix.length; i++){
            /* We start j same as i to avoid swap processed data
            * e.g if 0,1 swap with 1,0
            * but when come at 1,0 then it will again swap 1,0 with 0,1.
            * which is same as previous array.
            * */
            for (int j = i; j < matrix.length; j++){
                /* Take current number as temp and swap
                [row][col] to [col][row]*/
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        /* Create rotated array by Swap the element */
        for (int i = 0; i < matrix.length; i++){
            /*
            * here we lopping (matrix.length / 2) because we have to swap half of column
            * e.g : 1 2 3 4
            * output:4 3 2 1 here 1 swap with 4 and 2 swap with 3
            * so, there are only n/2 iterations.
            * */
            for (int j = 0; j < matrix.length/2; j++){
                int temp = matrix[i][j];
                /*
                * matrix.length - 1 - j will use to find out last element.
                * */
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        new RotateArray().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        new RotateArray().rotate(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
}

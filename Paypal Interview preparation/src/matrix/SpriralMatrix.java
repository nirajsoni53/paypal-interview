package matrix;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/spiral-matrix/
* 54. Spiral Matrix
* Medium
*
* Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
* Output: [1,2,3,6,9,8,7,4,5]
*
* Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
* Output: [1,2,3,4,8,12,11,10,9,5,6,7]
* */
public class SpriralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int dir = 0;

        List<Integer> result = new ArrayList<>();

        while(left <= right && top <= down){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    result.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top; i <= down; i++){
                    result.add(matrix[i][right]);
                }
                right--;
            } else if(dir == 2){
                for(int i = right; i >= left; i--){
                    result.add(matrix[down][i]);
                }
                down--;
            }else if(dir == 3){
                for(int i = down; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
            dir++;
            dir = dir % 4;
        }
        return result;
    }
}

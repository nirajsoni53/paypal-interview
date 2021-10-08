package dfs;

public class NumberOfIsland {

    //space : 0(1)
    //Tine : O(row*col)
    public static int numberOfIsland(int[][] grid){
        int count = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    gridHelper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void gridHelper(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i>=grid.length || j>=grid[0].length
        || grid[i][j] != 1){
            return;
        }
        grid[i][j] = 2;

        //Horizontal
        gridHelper(grid, i, j-1);
        gridHelper(grid, i, j+1);

        //vertical
        gridHelper(grid, i-1, j);
        gridHelper(grid, i+1, j);

        //diagonal
        gridHelper(grid, i-1, j-1);
        gridHelper(grid, i+1, j+1);
        gridHelper(grid, i-1, j+1);
        gridHelper(grid, i+1, j-1);
    }

    public static void main(String[] args) {
        int[][] grid = new int[5][5];
        grid[0][0] = 1;
        grid[0][1] = 0;
        grid[0][2] = 1;
        grid[0][3] = 0;
        grid[0][4] = 1;

        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;
        grid[1][3] = 0;
        grid[1][4] = 0;

        grid[2][0] = 0;
        grid[2][1] = 0;
        grid[2][2] = 0;
        grid[2][3] = 0;
        grid[2][4] = 1;

        grid[3][0] = 0;
        grid[3][1] = 0;
        grid[3][2] = 1;
        grid[3][3] = 0;
        grid[3][4] = 0;

        grid[4][0] = 0;
        grid[4][1] = 1;
        grid[4][2] = 1;
        grid[4][3] = 0;
        grid[4][4] = 1;

        numberOfIsland(grid);
    }
}

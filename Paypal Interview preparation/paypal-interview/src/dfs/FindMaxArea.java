package dfs;

public class FindMaxArea {
    public static int findMaxArea(int[][] grid)
    {
        int largestRegion = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                largestRegion = Math.max(largestRegion, gridHelper(grid, i ,j, 0));
            }
        }
        return largestRegion;
    }

    private static int gridHelper(int[][] grid, int i, int j, int count){
        if(i<0 || j<0 || i>=grid.length || j>= grid[i].length || grid[i][j] != 1){
            return 0;
        }

        count++;
        grid[i][j] = 0;

        //Horizontal
        count += gridHelper(grid, i, j-1, 0);
        count += gridHelper(grid, i, j+1, 0);

        //vertical
        count += gridHelper(grid, i-1, j, 0);
        count += gridHelper(grid, i+1, j, 0);

        //diagonal
        count += gridHelper(grid, i-1, j-1, 0);
        count += gridHelper(grid, i+1, j+1, 0);
        count += gridHelper(grid, i-1, j+1, 0);
        count += gridHelper(grid, i+1, j-1, 0);

        return count;
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

        System.out.println(findMaxArea(grid));
    }
}

package dfs;

public class SurroundedRegion {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        if (row == 0 || col == 0) return;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    //isValid = true;
                    dfs(board, visited, i, j, true);
                }
            }
        }
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, boolean isValid) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j] || board[i][j] == 'X') return true;
        visited[i][j] = true;

        isValid = dfs(board, visited, i + 1, j, isValid) && isValid;
        isValid = dfs(board, visited, i - 1, j, isValid) && isValid;
        isValid = dfs(board, visited, i, j + 1, isValid) && isValid;
        isValid = dfs(board, visited, i, j - 1, isValid) && isValid;

        if (isValid) {
            board[i][j] = 'X';
        }
        return isValid;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new SurroundedRegion().solve(arr);
    }
}

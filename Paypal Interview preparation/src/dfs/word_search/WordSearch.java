package dfs.word_search;

/*
* https://leetcode.com/problems/word-search/
* 79. Word Search
* Medium
*
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
*
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
*
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
* */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(word.charAt(0) ==  board[i][j] &&
                        dfs(board, visited, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index){
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;
        }
        if(word.charAt(index) !=  board[i][j] || visited[i][j]) return false;
        visited[i][j] = true;
        boolean result = dfs(board, visited, i-1, j, word, index+1) ||
                dfs(board, visited, i+1, j, word, index+1) ||
                dfs(board, visited, i, j-1, word, index+1) ||
                dfs(board, visited, i, j+1, word, index+1);

        visited[i][j] = false;
        return result;
    }
}

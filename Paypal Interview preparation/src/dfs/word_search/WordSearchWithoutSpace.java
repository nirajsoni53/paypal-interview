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
public class WordSearchWithoutSpace {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) ==  board[i][j] &&
                        dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index){
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;
        }
        if(word.charAt(index) !=  board[i][j]) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean result = dfs(board, i-1, j, word, index+1) ||
                dfs(board, i+1, j, word, index+1) ||
                dfs(board, i, j-1, word, index+1) ||
                dfs(board, i, j+1, word, index+1);

        board[i][j] = temp;
        return result;
    }
}

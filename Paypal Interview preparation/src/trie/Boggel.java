package trie;

import java.util.ArrayList;
import java.util.List;

public class Boggel {

    public static void main(String[] args) {
        char boggle[][] = { { 'G', 'I', 'Z' },
                { 'U', 'E', 'K' },
                { 'Q', 'S', 'E' } };
        wordBoggle(boggle, new String[]{ "GEEKS", "FOR", "QUIZ", "GUQ", "EE" });
    }

    public static String[] wordBoggle(char board[][], String[] dictionary)
    {
        List<String> list = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<dictionary.length; i++){
            String word = wordBoggleHelper(board, visited, dictionary[i], "", 0, 0);
            if(!word.isEmpty())
            {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }

    public static String wordBoggleHelper(char board[][], boolean[][] visited, String word, String str,
                                   int i, int j){
        if(i < 0 || j < 0 || visited[i][j]){
            return "";
        }

        visited[i][j] = true;
        str = str + board[i][j];

        if(word.equals(str)){
            return word;
        }


        //Horizontal
        wordBoggleHelper(board, visited, word, str, i, j-1);
        wordBoggleHelper(board, visited, word, str, i, j+1);

        //vertical
        wordBoggleHelper(board, visited, word, str, i-1, j);
        wordBoggleHelper(board, visited, word, str, i+1, j);

        //diagonal
        wordBoggleHelper(board, visited, word, str, i-1, j-1);
        wordBoggleHelper(board, visited, word, str, i+1, j+1);
        wordBoggleHelper(board, visited, word, str, i-1, j+1);
        wordBoggleHelper(board, visited, word, str, i+1, j-1);


        str = "";
        visited[i][j] = false;
        return str;
    }
}

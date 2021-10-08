package trie.word_search2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int row = board.length;
        if(row == 0) return result;
        int col = board[0].length;
        if(col == 0) return result;

        //Initialize points map
        Map<Character, List<Point>> map = initizePointsMap(board);

        for(String word : words){
            if(map.containsKey(word.charAt(0))){
                List<Point> points = map.get(word.charAt(0));
                for(Point point : points){
                    if(dfs(board, word, point.getI(), point.getJ(), 0)){
                        result.add(word);
                        break;
                    }
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index){
        if(word.length() == index) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;
        }
        if(word.charAt(index) != board[i][j]) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean result =
                dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);
        board[i][j] = temp;
        return result;
    }



    private Map<Character, List<Point>> initizePointsMap(char[][] board){
        Map<Character, List<Point>> map = new HashMap<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                List<Point> points;
                if(map.containsKey(c)){
                    points = map.get(c);
                }else{
                    points = new ArrayList<>();
                }
                points.add(new Point(i, j));
                map.put(c, points);
            }
        }
        return map;
    }

    class Point{
        private int i;
        private int j;

        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }

        public void setI(int i){
            this.i = i;
        }

        public void setJ(int j){
            this.j = j;
        }

        public int getI(){
            return this.i;
        }

        public int getJ(){
            return this.j;
        }
    }
}

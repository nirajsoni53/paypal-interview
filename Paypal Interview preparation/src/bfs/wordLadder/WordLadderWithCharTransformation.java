package bfs.wordLadder;

import java.util.*;

public class WordLadderWithCharTransformation {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //sanity check
        if (beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        for(String word: wordList){
            visited.add(word);
        }

        //BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.remove();
                char[] wordArr = word.toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    char temp = wordArr[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == temp) continue;
                        wordArr[j] = c;
                        String newWord = new String(wordArr);
                        if(newWord.equals(endWord)) return count + 1;
                        if(visited.contains(newWord)){
                            queue.add(newWord);
                            visited.remove(newWord);
                        }
                    }
                    wordArr[j] = temp;
                }
            }
            count++;
        }
        return 0;
    }
}

package bfs.wordLadder;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //sanity check
        if (beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }

        //build a map for quick lookup possible next word
        Map<String, List<String>> wordMap = new HashMap<>();
        for (String word : wordList) {
            char[] wordArr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char temp = wordArr[i];
                wordArr[i] = '*';
                String key = new String(wordArr);
                if (!wordMap.containsKey(key)) {
                    wordMap.put(key, new ArrayList<>());
                }
                wordMap.get(key).add(word);
                wordArr[i] = temp;  //restore original char for next loop
            }
        }

        //BFS
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.remove();
                visited.add(word);
                char[] wordArr = word.toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    char temp = wordArr[j];
                    wordArr[j] = '*';
                    String key = new String(wordArr);
                    if (wordMap.containsKey(key)) {
                        List<String> words = wordMap.get(key);
                        for (String nextWord : words) {
                            if (!visited.contains(nextWord)) {
                                if (nextWord.equals(endWord)) {
                                    return count + 1;
                                }
                                queue.add(nextWord);
                            }
                        }
                    }
                    wordArr[j] = temp; //restore original char for next loop
                }
            }
            count++;
        }
        return 0;
    }
}

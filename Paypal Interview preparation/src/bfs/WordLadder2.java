package bfs;

import java.util.*;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.isEmpty() || !wordList.contains(endWord)) new ArrayList<>();
        Map<String, Integer> visited =  new HashMap<>();
        Map<String, List<String>> adj = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);

        Queue<String> queue =  new LinkedList<>();
        queue.add(beginWord);
        visited.put(beginWord, 0);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String currentWord = queue.poll();
                char[] wordArr = currentWord.toCharArray();
                for(int j = 0; j < wordArr.length; j++){
                    char currentChar = wordArr[j];
                    for(char c = 'a'; c < 'z'; c++){
                        if(currentChar == c) continue;
                        wordArr[j] = c;
                        String newWord = String.valueOf(wordArr);
                        if(dict.contains(newWord)){
                            if(!visited.containsKey(newWord)){
                                visited.put(newWord, visited.get(currentWord) + 1);
                                queue.add(newWord);
                                List<String> list = adj.get(currentWord) == null ? new ArrayList<>() :                                                                                              adj.get(currentWord);
                                list.add(newWord);
                                adj.put(currentWord, list);
                            }else if(visited.get(currentWord) + 1 == visited.get(newWord)){
                                List<String> list = new ArrayList<>();
                                list.add(newWord);
                                adj.put(currentWord, list);
                            }
                        }
                    }
                    wordArr[j] = currentChar;
                }
            }
        }
        List<List<String>> result =new ArrayList<>();
        dfs(beginWord, endWord, adj, result, new ArrayList<>());
        return result;
    }

    private void dfs(String beginWord, String endWord, Map<String, List<String>> adj, List<List<String>> result, List<String> list){
        list.add(beginWord);

        if(beginWord.equals(endWord)){
            result.add(list);
            //new ArrayList<>(list).remove(beginWord);
            return;
        }
        else {
            if (adj.containsKey(beginWord)) {
                for (String word : adj.get(beginWord)) {
                    dfs(word, endWord, adj, result, new ArrayList<>(list));
                }
            }
        }
        new ArrayList<>(list).remove(beginWord);
    }

    public static void main(String[] args) {
        /*new WordLadder2().findLadders("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log","cog"));*/
/*
        new WordLadder2().findLadders("a", "c",
                Arrays.asList("a","b","c"));
*/

        new WordLadder2().findLadders("qa", "sq",
                Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
    }
}

package bfs.wordladder2;

import bfs.WordLadder2;

import java.util.*;

public class Wordladder2Full {
    public List<List<String>> findLadders(String beginWord, String endWord,
                                          List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashMap<String, Integer> d = new HashMap<>();
        d.put(beginWord, 0);
        HashMap<String, ArrayList<String>> neighbors = new HashMap<>();

        bfs(d, neighbors, wordSet, beginWord, endWord);
        List<List<String>> res = new ArrayList<>();
        List<String> store = new ArrayList<>();
        dfs(d, neighbors, store, res, beginWord, endWord);
        return res;
    }
    private void bfs(HashMap<String, Integer> d, HashMap<String, ArrayList<String>> neighbors,HashSet<String> wordSet, String beginWord, String endWord) {
        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);
        neighbors.put(beginWord, new ArrayList<>());
        for (String w: wordSet) neighbors.put(w, new ArrayList<>());
        while (!queue.isEmpty()) {
            String w = queue.poll();
            int dist = d.get(w);
            char[] chars = w.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == temp) continue;
                    chars[i] = c;
                    String next = String.valueOf(chars);
                    if (!wordSet.contains(next)) continue;
                    neighbors.get(w).add(next);
                    if (!d.containsKey(next)) {
                        d.put(next, dist + 1);
                        if (w.equals(endWord)) return;
                        queue.add(next);
                    }
                }
                chars[i] = temp;
            }
        }
    }
    private void dfs(HashMap<String, Integer> d,
                     HashMap<String, ArrayList<String>> neighbors,
                     List<String> store,
                     List<List<String>> res, String word, String endWord) {
        store.add(word);
        if (word.equals(endWord)) {
            res.add(new ArrayList<>(store));
        } else {
            for (String next: neighbors.get(word)) {
                if (d.get(next) == d.get(word) + 1) {
                    dfs(d, neighbors, store, res, next, endWord);
                }
            }
        }
        store.remove(store.size() - 1);
    }

    public static void main(String[] args) {
        new Wordladder2Full().findLadders("qa", "sq",
                Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
    }
}

package algoritham.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibleAnagram {

    static void findAnagramsBruteForce(String input, String key){
        Set<Character> map = new HashSet<>();
        for (int i = 0; i < key.length(); i++){
            map.add(key.charAt(i));
        }

        for(int i = 0; i <= input.length() - key.length(); i++){
            if(!map.contains(input.charAt(i))){
                continue;
            }
            String anagram = "" + input.charAt(i);
            for(int j = i+1; j < i + key.length();  j++){
                if(!map.contains(input.charAt(j))){
                    break;
                }
                anagram += input.charAt(j);
            }
            if(anagram.length() == key.length()){
                System.out.println(anagram);
            }
        }
    }

    static void findAnagramsTwoHashMap(String input, String key){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else map.put(c, 1);
        }

        int keyLength = key.length();
        Map<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i <= input.length() - key.length(); i++){
            char c = key.charAt(i);
            if(i < keyLength){
                if(map.containsKey(c)){
                    map1.put(c, map1.get(c) + 1);
                }else map1.put(c, 1);
            }else {
                if(map.containsKey(c)){

                }
            }
        }
    }

    public static void main(String[] args) {
        //findAnagramsBruteForce("forxxorfoxxxfro", "for");
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1 , 2);

        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1 , 3);

        System.out.println(map.equals(map1));
    }
}

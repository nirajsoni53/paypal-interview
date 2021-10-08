package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumSlidingwindows {
    public String minWindow(String s, String t) {
        int firstLen = s.length();
        int secondLen = t.length();
        String result = "";
        if(firstLen == 0 || secondLen == 0 || firstLen < secondLen) return result;
        if(firstLen == secondLen && s.equals(t)) return s;

        Set<Character> set = new HashSet<>();
        for(char c : t.toCharArray()){
            set.add(c);
        }

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        Map<Character, Integer> frequency = new HashMap<>();
        while(j < firstLen){ // A D O B E C O D E B A N C
            //i       j
            if(frequency.size() == set.size()){
                if(minLength > (j - i))  // 5 - 0 = 5
                {
                    start = i;
                    end = j;
                    minLength = (j - i);
                    if((j - i + 1) == set.size()) break;
                }
                i++;
                char prev = s.charAt(i - 1);
                if(frequency.containsKey(prev)){
                    frequency.put(prev, frequency.get(prev) - 1);
                    if(frequency.get(prev) == 0) frequency.remove(prev);
                }
                if(frequency.size() < set.size()) j++;
            }else if(frequency.size() < set.size()){
                char c = s.charAt(j);
                if(set.contains(c)){
                    if(frequency.containsKey(c))
                        frequency.put(c, frequency.get(c) + 1);
                    else frequency.put(c, 1);
                }
                if(frequency.size() == set.size()) continue;
                j++;
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        new MinimumSlidingwindows().minWindow("ADOBECODEBANC", "ABC");
    }
}

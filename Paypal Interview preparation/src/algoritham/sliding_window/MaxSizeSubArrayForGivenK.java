package algoritham.sliding_window;

import java.util.HashMap;

public class MaxSizeSubArrayForGivenK {

    static int maxSizeSubArray(String s, int k){
        if(s == null || s.isEmpty()) return 0;
        if(k == 0) return 0;
        int size = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0,j = 0;
        int maxSize = 0;
        while(j < size){
            char c = s.charAt(j);
            if(map.size() < k){
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                }else{
                    map.put(c, 1);
                }
                j++;
            } else if(map.size() == k){
                maxSize = Math.max(j-i, maxSize);
                j++;

                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                }else{
                    map.put(c, 1);
                }
                if(j == size && map.size() == k){
                    maxSize = Math.max(j-i, maxSize);
                }
            } else {
                if(map.get(s.charAt(i)) == 1){
                    map.remove(s.charAt(i));
                }else{
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                }
                i++;
            }
        }
        System.out.println(maxSize);
        return maxSize;
    }

    public static void main(String[] args) {
        maxSizeSubArray("aaadccbbbbbb", 0);
    }
}

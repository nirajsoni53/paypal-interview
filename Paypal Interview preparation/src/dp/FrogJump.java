package dp;

import java.util.HashMap;
import java.util.HashSet;

/*
* Time O(n * j), where n = total number of stones and j = number of jumps.
* Space O(n * j), where n = total number of stones and j = number of jumps.
* */
public class FrogJump {
    public boolean canCross(int[] stones) {

        if (stones == null || stones.length == 0) {
            return true;
        }
        if (stones.length == 1) {
            return stones[0] == 0;
        }
        if (stones.length == 2) {
            return stones[0] == 0 && stones[1] == 1;
        }
        if (stones[0] != 0 || stones[1] != 1) {
            return false;
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int i = 0; i< stones.length; i++){
            map.put(stones[i], new HashSet<>());
        }

        map.get(stones[0]).add(1);
        for(int stone : stones){
            HashSet<Integer> jumps = map.get(stone);
            for(int jump : jumps){
                int reachedStone = stone + jump;
                if(reachedStone == stones[stones.length -1]) return true;
                if(map.containsKey(reachedStone)){
                    HashSet<Integer> set = map.get(reachedStone);
                    if(jump - 1 > 0) set.add(jump - 1);
                    set.add(jump);
                    set.add(jump + 1);
                    map.put(reachedStone, set);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new FrogJump().canCross(new int[]{0,1,2,3,6,7,8,11});
    }
}

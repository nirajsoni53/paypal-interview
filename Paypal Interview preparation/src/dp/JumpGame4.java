package dp;

import java.util.*;


/*
* Jump Game
* Time: O(n)
* Space: O(n)
* https://leetcode.com/problems/jump-game-iv/
* 1345. Jump Game IV
* Hard
*
* Example 1:
* Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
* Output: 3
* Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
*
* Example 2:
* Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
* Output: 3
* */
public class JumpGame4 {
    public int minJumps(int[] arr) {
        int len = arr.length;

        // Check the base case
        if(len == 1) return 0;

        // Fill the map
        Map<Integer, List<Integer>> map =  new HashMap<>();
        for(int i = 0; i < len; i++)
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int steps = 0;
        while(!queue.isEmpty()){
            steps++;
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int j = queue.poll();

                //Check for j -1.
                if(j - 1 >= 0 && map.containsKey(arr[j - 1])){
                    queue.offer(j - 1);
                }

                //Check for j + 1.
                if(j + 1 < len && map.containsKey(arr[j + 1])){
                    if(j + 1 == len-1) return steps;
                    queue.offer(j + 1);
                }

                //Check for a[i] == a[j].
                if(map.containsKey(arr[j])){
                    for(int value : map.get(arr[j])){
                        if(value != j){
                            if(value == len - 1) return steps;
                            queue.offer(value);
                        }
                    }
                }
                map.remove(arr[j]);
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        /*new JumpGame4().minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404});
        new JumpGame4().minJumps(new int[]{7});
        new JumpGame4().minJumps(new int[]{7});
        new JumpGame4().minJumps(new int[]{7,6,9,6,9,6,9,7});*/
        new JumpGame4().minJumps(new int[]{11,22,7,7,7,7,7,7,7,22,13});
    }
}

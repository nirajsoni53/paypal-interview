package firstRound;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfTwoNumber {

    public static void sumOfTwoNumbers(int[] a, int n, int target){
        if(a == null || a.length ==0 || a.length == 1){
            System.out.println("No Pair found");
        }
        else{
            Set<Integer> set = new HashSet<>();
            for (int i =0; i<n; i++){
                int requiredNumber = target - a[i];
                if(set.contains(requiredNumber)){
                    System.out.println("Pair is " + requiredNumber+ " and "+a[i]);
                }
                if(!set.contains(a[i])){
                    set.add(a[i]);
                }
            }
        }
    }

    static void findNonRepeatativeCharacter(String s){
        if(s == null || s.isEmpty()){
            System.out.println("No data found");
        }
        else if(s.length() == 1){
            System.out.println("The answer is = "+s.charAt(0));
        } else {
            Map<Character, Integer> map = new HashMap<>();
            for (int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                }else {
                    map.put(c, 1);
                }
            }
            boolean isFound = false;
            for (Map.Entry<Character,Integer> entry :  map.entrySet()){
                if(entry.getValue() == 1){
                    System.out.println("The answer is = "+ entry.getKey());
                    isFound = true;
                    break;
                }
            }
            if (!isFound){
                System.out.println("No character found");
            }
        }

    }

    public static void main(String[] args) {
        sumOfTwoNumbers(new int[]{-3,-2,0,2,3}, 5, 0);
        findNonRepeatativeCharacter("a");
    }

}

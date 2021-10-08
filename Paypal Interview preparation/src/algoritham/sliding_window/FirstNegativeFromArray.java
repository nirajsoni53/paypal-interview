package algoritham.sliding_window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeFromArray {

    // -1, -2, 3, 4, -6, 5, -8, 7
    static void findFirstNegativeForGivenWindowBruteForce(int[] a, int k){
        for(int i = 0; i <= a.length - k; i++){
            if (a[i] < 0) System.out.print(a[i]+", ");
            else{
                boolean flag = false;
                for(int j = i + 1; j < i + k; j++){
                    if (a[j] < 0){
                        System.out.print(a[j]+", ");
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    System.out.print("0, ");
            }
        }
    }

    // -1, -2, 3, 4, -6, 5, -8, 7
    static void findFirstNegativeForGivenWindowWithoutBruteForce(int[] a, int k){
        if(a.length == 0) {
            System.out.println(0);
            return;
        }
        Queue<Integer> q
                = new LinkedList<>();
        for (int i = 0; i < k -1 ; i++){
            if(a[i] < 0)
                q.add(a[i]);
        }
        for (int i = k - 1; i < a.length; i++){
            if(a[i] < 0) {
                q.add(a[i]);
            }
            if(q.isEmpty()){
                System.out.print("0, ");
            }else{
                int peek = q.peek();
                System.out.print(peek +", ");
                if(a[i - k + 1] == peek){
                    q.poll();
                }
            }
        }
    }

    public static void main(String[] args) {
        findFirstNegativeForGivenWindowBruteForce(
                new int[]{-1, -2, 3, 4, -6, 5, -8, 7 }, 2);
        System.out.println();
        findFirstNegativeForGivenWindowWithoutBruteForce(
                new int[]{-1, -2, 3, 4, -6, 5, -8, 7 }, 2);
    }
}

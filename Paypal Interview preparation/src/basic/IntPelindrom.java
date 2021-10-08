package basic;

import java.util.HashSet;
import java.util.Set;

public class IntPelindrom {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;
        int x1 = x;
        int ans = 0;
        while(x != 0){
            int rem = x % 10; //3->2->1
            x /= 10; //12 -> 1 -> 0
            ans = ans*10 +rem;
        }

        return x1 == ans;
    }

    public static void main(String[] args) {

    }
}

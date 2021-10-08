package dp;

public class NumWays {

    public static long numWays(int n){
        if(n == 0 || n == 1 || n == 2) return n;
        long dp[] = new long[n+1];
        dp[0] =1; dp[1] =1; dp[2] =2;
        if(n > 2) {
            for (int i =3; i<= n; i++){
                dp[i] = dp[i-1]% 1000000007 + dp[i-2]% 1000000007 + dp[i-3]% 1000000007;
            }
        }
        return dp[n] % 1000000007;
    }

    public static int numWays2(int n){
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;

        return numWays2(n - 1) + numWays2(n - 2) + numWays2(n-3);
    }

    public static void main(String[] args) {
        System.out.println(numWays(80));
        System.out.println(numWays2(5));
    }
}

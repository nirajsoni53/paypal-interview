package array;

public class JumpGame {

    static int canReach(int[] A, int N) {
        int len = A.length; // 6
        if(len == 0 || A[0] == 0) return 0;

        int maxReachable = 0;// 0, 1
        for(int i = 0; i < len; i++){ //3 0 1 2 0 0 1
            if(i > maxReachable) return 0;
            maxReachable = Math.max(i + A[i], maxReachable);
        }
        return 1;
    }

    public static void main(String[] args) {
        canReach(new int[]{3, 0, 1, 2, 0, 0, 1}, 7);
    }
}

package dp;

public class SumOfSubSet {
    int[] result = new int[3];
    boolean isFound = false;
    public int[] recoverArray(int n, int[] sums) {
        if(n == 0 || sums.length == 0) return result;
        recoverArray(n, sums, 0, 0, new int[3]);
        return result;
    }

    private void recoverArray(int n, int[] sums, int idx, int sum, int[] ansArr){
        if(n == 0){
            if(sum == 0) {
                result = ansArr;
                isFound = true;
            }
            return;
        }

        if(idx >= sums.length) return;

        ansArr[ansArr.length - n] = sums[idx];
        if(!isFound)
            recoverArray(n-1, sums, idx + 1, sum+sums[idx], ansArr);
        if(!isFound)
            recoverArray(n, sums, idx + 1, sum, ansArr);
    }

    public static void main(String[] args) {
        new SumOfSubSet().recoverArray(3, new int[]{-3,-2,-1,0,0,1,2,3});
    }
}

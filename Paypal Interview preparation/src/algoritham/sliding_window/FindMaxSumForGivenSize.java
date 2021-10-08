package algoritham.sliding_window;

public class FindMaxSumForGivenSize {

    static int findMaxSumForGivenSize(int[] a, int size){
        int maxSum = 0;
        int sum = 0;
        for (int i =0; i < a.length; i++){
            if(i < size){
                sum += a[i];
            }else{
                sum = sum - a[i - size] + a[i];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    static int findMaxSumForGivenSizeBroutForce(int[] a, int size){
        int maxSum = 0;
        for (int i =0; i <= a.length-size; i++){
            int sum = a[i];
            for (int j = i +1; j < i + size; j++)
            {
                sum += a[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        //findMaxSumForGivenSizeBroutForce(new int[]{1, 2, 3, 16, 5, 6}, 3);
        findMaxSumForGivenSize(new int[]{1, 2, 3, 4, 5, 6}, 3);
    }
}

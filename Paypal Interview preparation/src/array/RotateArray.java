package array;

public class RotateArray {
    static int[] roatateArray(int[] a, int k) {
        k = k % a.length;
        while (k > 0) {
            int temp = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = temp;
            k--;
        }
        return a;
    }

    static int[] rorateArray(int[] a, int k){
        k = k % a.length;
        while(k > 0){
            int temp = a[a.length -1];
            for (int i = a.length-2; i>=0; i--){
                a[i+1] = a[i];
            }
            a[0] = temp;
            k--;
        }
        return a;
    }

    static int[] rotateArrayByK(int[] a, int k){
        int len = a.length;
        k = k % len;

        reverse(0, len-k-1, a);
        reverse(len-k, len-1, a);
        reverse(0, len-1, a);
        return a;
    }

    private static void reverse(int start, int end, int[] a) {
        while (start < end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end --;
        }
    }

    public static void main(String[] args) {
        //Time : O(n*k), Space : O(1)
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 2;
        //a = roatateArray(a, k);
        //a = rotateArrayByK(a, k);
        a = rorateArray(a, 81);

        for (int input : a){
            System.out.print(input +" ");
        }
    }
}

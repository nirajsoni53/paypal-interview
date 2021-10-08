package array;

public class SquareSortedArray {
    static int[] squareSortedArray(int[] a){ // -6, -4, -2, 1, 3, 5
        int left = 0;
        int right = a.length - 1;
        int counter = a.length -1;
        int arr[] = new int[a.length];

        while(left < right){
            if(Math.abs(a[left]) >= a[right]){
                arr[counter] = a[left] *  a[left];
                left++;
            }else{
                arr[counter] = a[right] *  a[right];
                right--;
            }
            counter--;
        }
        arr[0] = a[left];

        return arr;
    }

    public static void main(String[] args) {
        squareSortedArray(new int[]{-6, -5, -4, -3, -2, -1});
    }
}

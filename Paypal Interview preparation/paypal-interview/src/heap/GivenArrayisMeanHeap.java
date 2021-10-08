package heap;

public class GivenArrayisMeanHeap {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        // start with index 0 (the root of the heap)
        int index = 0;
        System.out.println(checkMinHeap(A, index));

        int[] A1 = {6,6,5,4,3,2,1};
        System.out.println(checkMaxHeap(A1, index));
    }

    private static boolean checkMinHeap(int[] a, int index) {
        if(index * 2 + 2 > a.length)  return true;

        boolean left = (a[index] <= a[index * 2 + 1]) && checkMinHeap(a, index*2+1);
        boolean right = (index * 2 + 2 == a.length) || ((a[index] <= a[index * 2 + 2]) && checkMinHeap(a, index*2+2));

        return left && right;
    }
    private static boolean checkMaxHeap(int[] a, int index) {
        if(index * 2 + 2 > a.length)  return true;

        boolean left = (a[index] >= a[index * 2 + 1]) && checkMaxHeap(a, index*2+1);
        boolean right = (index * 2 + 2 == a.length) || ((a[index] >= a[index * 2 + 2]) && checkMaxHeap(a, index*2+2));

        return left && right;
    }
}

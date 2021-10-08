package algoritham.binary_search;

public class NumberOfRotation {
    public static void main(String[] args) {
        new NumberOfRotation().findTheNumberOfRotation(new int[]{15, 18, 2, 3, 5, 12});
    }

    int findTheNumberOfRotation(int[] a){
        int peak = findPeak(a);
        System.out.println(peak);
        return peak;
    }

    int findPeak(int[] a){
        int start = 0;
        int end = a.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(mid < end && a[mid] > a[mid + 1])
                return mid;
            else if(mid > start && a[mid] < a[mid - 1])
                return mid - 1;
            else if(a[mid] < a[start])
                end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}

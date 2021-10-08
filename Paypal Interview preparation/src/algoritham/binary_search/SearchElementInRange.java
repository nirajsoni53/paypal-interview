package algoritham.binary_search;

public class SearchElementInRange {
    int[] findElementInRange(int[] a, int target){
        if(a.length == 0) return new int[]{-1, -1};
        int start = binarySearch(a, target, true);
        if(start == -1) return new int[]{-1, -1};
        int end  = binarySearch(a, target, false);
        return new int[]{start,end};
    }

    int binarySearch(int[] a, int target, boolean isForStart){
        int start = 0;
        int end = a.length - 1;
        int element = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(a[mid] > target) end = mid -1;
            else if (a[mid] < target) start = mid +1;
            else{
                element = mid;
                if(isForStart) end = mid -1;
                else start = mid + 1;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        new SearchElementInRange().findElementInRange(new int[]{1,2,3,7,7,8,9,9}, 7);
    }
}

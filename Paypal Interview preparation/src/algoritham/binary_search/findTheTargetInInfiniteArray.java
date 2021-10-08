package algoritham.binary_search;

public class findTheTargetInInfiniteArray {

    public static void main(String[] args) {
        System.out.println(new findTheTargetInInfiniteArray().ans(new int[]{2,3,5,6,7,8,10,11,12,15,20,23,30}, 15));
    }

    int ans(int[] a, int target){
        int start = 0;
        int end = 1;

        while (target > a[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(a, start, end, target);
    }

    int binarySearch(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) /2;
            if(arr[mid] < target){
                start = mid + 1;
            } else if(arr[mid] > target){
                end = mid - 1;
            } else return mid;
        }
        return -1;
    }
}

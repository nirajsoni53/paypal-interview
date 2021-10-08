package algoritham.binary_search;


/*https://leetcode.com/problems/find-in-mountain-array/
* 1095. Find in Mountain Array
* Hard
*/
public class findMountainOfArray {
    public int findInMountainArray(int target, int[] mountainArr) {
        int peak = findPeak(mountainArr);
        int result = binarySearch(target, 0, peak, mountainArr);
        if(result != -1) return result;
        return binarySearch(target, peak + 1, mountainArr.length - 1, mountainArr);
    }

    private int binarySearch(int target, int start, int end, int[] mountainArr){
        boolean isASC = false;
        if(mountainArr[start] < mountainArr[end]){
            isASC = true;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mountainArr[mid] < target){
                if(isASC) start = mid + 1;
                else end = mid -1;
            }else if(mountainArr[mid] > target){
                if(isASC) end = mid - 1;
                else start = mid + 1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    private int findPeak(int[] mountainArr){
        int start = 0;
        int end = mountainArr.length-1;

        while(start < end){
            int mid = start + (end - start) /2;
            if(mountainArr[mid] < mountainArr[mid + 1]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}

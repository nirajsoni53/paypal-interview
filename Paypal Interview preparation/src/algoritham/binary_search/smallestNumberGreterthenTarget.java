package algoritham.binary_search;

/*
* https://leetcode.com/problems/find-smallest-letter-greater-than-target/
* 744. Find Smallest Letter Greater Than Target
* Easy
* */
public class smallestNumberGreterthenTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        //if(target < letters[start] || target >= letters[end]) return letters[0];

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(letters[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return letters[start % letters.length];
    }
}

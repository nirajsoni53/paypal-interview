package array;

import java.util.Arrays;
import java.util.List;

public class SampleAmazon {

    public static List<Integer> reverseArray(List<Integer> a) {
        int length = a.size();
        for(int i = 0; i < length/2; i++){
            swap(a, i, length - i - 1);
        }
        return a;
    }

    private static void swap(List<Integer> a, int start, int end){
        int temp = a.get(start);
        a.set(start, a.get(end));
        a.set(end, temp);
    }

    public static String decodeString(int numberOfRows, String encodedString) {
        int numberOfColumn = encodedString.length() / numberOfRows;
        char[][] matrix = new char[numberOfRows][numberOfColumn];
        int i = 0;
        int j = 0;
        for (int k = 0; k < encodedString.length(); k++) {
            char c = encodedString.charAt(k);
            matrix[i][j] = c;
            j++;
            if (j == numberOfColumn) {
                i++;
                j = 0;
            }
        }
        i = 0;
        j = 0;
        int previousJ = 0;
        StringBuilder originalString = new StringBuilder();
        while(i != numberOfRows-1 || j != numberOfColumn){
            char c = matrix[i][j];
            if(c != '_'){
                originalString.append(c);
            }else{
                originalString.append(" ");
            }
            if(i == numberOfRows-1){
                i=0;
                j = previousJ +1;
                previousJ++;
            }else{
                i++;
                j++;
            }
        }

        return originalString.toString().trim();
    }

    public static void main(String[] args) {

        System.out.println(decodeString(3, "mnes__ya_____mi"));
        System.out.println(decodeString(3, "mnesij__ya__r____mina"));
        System.out.println(reverseArray(Arrays.asList(new Integer[]{1,4,3,2})));
    }
}

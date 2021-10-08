package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackHeight {

    private static int sum(List<Integer> list){
        int sum = 0;
        for(int value: list){
            sum+=value;
        }
        return sum;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int h1Sum = sum(h1);
        int h2Sum = sum(h2);
        int h3Sum = sum(h3);
        int minSize = Math.min(Math.min(h1Sum, h2Sum), h3Sum);
        while(h1Sum != h2Sum || h2Sum != h3Sum){
            if(h1Sum > minSize){
                int value = h1.remove(0);
                h1Sum -= value;
                if(h1Sum < minSize) minSize = h1Sum;
            }
            if(h2Sum > minSize){
                int value = h2.remove(0);
                h2Sum -= value;
                if(h2Sum < minSize) minSize = h2Sum;
            }
            if(h3Sum > minSize){
                int value = h3.remove(0);
                h3Sum -= value;
                if(h3Sum < minSize) minSize = h3Sum;
            }
        }
        return minSize;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(4,2,1,1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3,1,2));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(3,2,1,1,1));
        System.out.println(equalStacks(a,b,c));
    }
}

package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/*

Time : O(N log k)
       j
       0  1  2  3
       ----------
* i 0| 1, 2, 3, 4
*   1| 2, 2, 3, 4
*   2| 5, 5, 6, 6
*   3| 7, 8, 9, 9
  i = 0, j = 0 == 1
  i = 0, j = 1 == 2
  i = 1, j = 0 == 2
  i = 1, j = 1 == 2
  so on...

  get current index i,j and go to next index of arr[i][j]
  and add it into the heap node and get lowest one.
* */
public class KSortedArrayByHeap {
    private static class QueueNode implements Comparable<QueueNode>{
        int i, j, value;
        public QueueNode(int i , int j, int value){
            this.i = i;
            this.j = j;
            this.value = value;
        }

        public int compareTo(QueueNode node){
            return Integer.compare(this.value, node.value);
        }
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K)
    {
        PriorityQueue<QueueNode> queue = new PriorityQueue<>();
        int size = 0;
        for(int i=0; i<K; i++){
            size+=arr[i].length;
            if(arr[i].length > 0){
                queue.add(new QueueNode(i, 0, arr[i][0]));
            }
        }

        ArrayList<Integer> result = new ArrayList<>(size);
        while(!queue.isEmpty()){
            QueueNode node = queue.poll();
            result.add(node.value);

            int newJIndex = node.j + 1;
            if(newJIndex < arr[node.i].length){
                queue.add(new QueueNode(node.i, newJIndex, arr[node.i][newJIndex]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(4,5,6));
        list.add(Arrays.asList(7,8,9));

        int[][] arr = new int[4][4];
        arr[0] = new int[]{1,2,3,4};
        arr[1] = new int[]{2,2,3,4};
        arr[2] = new int[]{5,5,6,6};
        arr[3] = new int[]{7,8,9,9};

        System.out.println(mergeKArrays(arr, 4));
    }
}

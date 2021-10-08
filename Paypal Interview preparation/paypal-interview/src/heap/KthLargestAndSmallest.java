package heap;

import java.util.*;
import java.util.function.Predicate;

public class KthLargestAndSmallest {
    public static int findKthLargest(List<Integer> ints, int k)
    {
        // create a min-heap using the `PriorityQueue` class and insert
        // the first `k` array elements into the heap
        Queue<Integer> pq = new PriorityQueue<>(ints.subList(0, k));

        // do for remaining array elements
        for (int i = k; i < ints.size(); i++)
        {
            // if the current element is more than the root of the heap
            if (ints.get(i) > pq.peek())
            {
                // replace root with the current element
                pq.poll();
                pq.add(ints.get(i));
            }
        }

        // return the root of min-heap
        return pq.peek();
    }

    public static int kThSmallestElement(List<Integer> list , int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(list.subList(0, k));

        for (int i = k; i< list.size(); i++){
            if(list.get(i) < queue.peek()){
                queue.poll();
                queue.add(list.get(i));
            }
        }
        return queue.peek();
    }

    public static void kThLargestNumberFromStream(List<Integer> list, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(list.subList(0, k));

        for(int i = k; i<list.size(); i++){
            System.out.print(queue.poll() + " ");
            queue.add(list.get(i));
        }
    }

    public static void kThLargestNumberFromStreamBySort(List<Integer> list, int k){
        Collections.sort(list);
        int i = 0;
        for(int data:list){
            if(i == list.size() - 2){
                break;
            }
            System.out.print(data + " ");
            i++;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>();
        q.add(5);
        q.add(2);
        q.add(3);
        q.add(8);
        q.add(1);

        //List<Integer> list = Arrays.asList(5,2,3,8,1);
        List<Integer> list = Arrays.asList(4,5,12,8,9,10,20,42);
        //System.out.println(findKthLargest(list, list.size()-2+1));
        //System.out.println(kThSmallestElement(list, 2));
        kThLargestNumberFromStream(list, 3);
        /*while(q.size() > 0){
            System.out.print(q.poll() + " ");
        }*/
        //System.out.println(integers);
    }
}

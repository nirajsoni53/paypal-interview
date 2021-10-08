package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int key;
    int value;

    Node(int key, int value){
        this.key =  key;
        this.value =  value;
    }

    public int compareTo(Node o){
        if(this.value > o.value) return -1;
        else if(this.value < o.value) return 1;
        else return 0;
    }
}

public class TopKFrequencyElement {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = calculateFrequency(nums);

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];
        int i = 0;
        while(k > 0){
            Node node = queue.poll();
            result[i] = node.key;
            i++;
            k--;
        }

        return result;
    }


    private HashMap<Integer, Integer> calculateFrequency(int[] nums){
        HashMap<Integer, Integer> freq =  new HashMap<>();
        for(int no : nums){
            if(freq.containsKey(no)){
                freq.put(no, freq.get(no) + 1);
            } else freq.put(no, 1);
        }
        return freq;
    }
}

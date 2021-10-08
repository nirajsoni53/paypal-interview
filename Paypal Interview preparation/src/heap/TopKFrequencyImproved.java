package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequencyImproved {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = calculateFrequency(nums);

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(queue.size() < k){
                queue.add(new Node(entry.getKey(), entry.getValue()));
            }else {
                Node node = queue.peek();
                if(node.value < entry.getValue()){
                    queue.poll();
                    queue.add(new Node(entry.getKey(), entry.getValue()));
                }
            }
        }

        int[] result = new int[k];
        int i = -1;
        while(!queue.isEmpty()){
            Node node  = queue.poll();
            i++;
            result[i] = node.key;
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

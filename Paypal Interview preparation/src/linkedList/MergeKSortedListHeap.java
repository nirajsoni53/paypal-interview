package linkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode implements Comparable<ListNode>{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }

    @Override
    public int compareTo(ListNode o) {
        return Integer.compare(this.val, o.val);
    }
}

public class MergeKSortedListHeap {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq=new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        ListNode res=new ListNode(0);
        ListNode pointer=res;

        for(int i=0;i<lists.length;i++){

            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }

        while(!pq.isEmpty()){

            ListNode node=pq.poll();
            if(node.next!=null) pq.offer(node.next);

            pointer.next=node;
            pointer=pointer.next;

        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);

        ListNode second =  new ListNode(2);
        second.next = new ListNode(2);
        second.next.next = new ListNode(3);
        second.next.next.next = new ListNode(4);

        ListNode third =  new ListNode(5);
        third.next = new ListNode(5);
        third.next.next = new ListNode(6);
        third.next.next.next = new ListNode(7);


        ListNode[] nodes = new ListNode[]{second, third, first};
        new MergeKSortedListHeap().mergeKLists(nodes);
    }
}

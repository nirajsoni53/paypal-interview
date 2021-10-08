package linkedList;

import java.util.ArrayList;
import java.util.List;

public class ReorderLinkedList {
    private static Node reOrderLinkedList(Node head){
        Node prev = null;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;

        Node secondHead = reverse(slow);

        return merge(head, secondHead);
    }

    private static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = head;

        while(next != null){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node merge(Node first, Node second){
        Node node = new Node();
        Node temp = node;

        boolean flag = false;

        while(first != null || second != null){
            if(first == null) {
                temp.next = second;
                second = second.next;
            }else if(second == null){
                temp.next = first;
                first = first.next;
            }else if(!flag){
                temp.next = first;
                first = first.next;
                flag = true;
            }else{
                temp.next = second;
                second = second.next;
                flag = false;
            }
            temp = temp.next;
        }
        return node.next;
    }

    /* PART 2*/

    public void reorderList(Node head) {
        Node node = head;
        List<Integer> arr = new ArrayList<>(); //1,2,3,4,5
        while(node != null){
            arr.add(node.data);
            node = node.next;
        }

        int size = arr.size();
        if(size > 2){
            node = head;
            for(int i = 0; i < size / 2; i++){
                if(node == null) break;
                node.data = arr.get(i);
                node.next.data = arr.get(size - 1 - i);
                node = node.next.next;
            }
            if(size % 2 != 0){
                node.data = arr.get(size / 2);
            }
        }
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.data = 1;

        node.next = new Node();
        node.next.data = 2;

        node.next.next = new Node();
        node.next.next.data = 3;

        node.next.next.next = new Node();
        node.next.next.next.data = 4;

        node.next.next.next.next = new Node();
        node.next.next.next.next.data = 5;

        node.next.next.next.next.next = new Node();
        node.next.next.next.next.next.data = 6;

        Node lis = reOrderLinkedList(node);
        System.out.println(lis);
    }
}

package linkedList;

public class ReverseLinkListForKGroup {

    public static Node reverse(Node head, int k)
    {
        Node prev = null;
        Node curr = head;
        Node next = null;
        int c = 0;

        while(curr != null && c < k){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            c++;
        }

        if(next != null) head.next = reverse(curr, k);
        return prev;
    }
}

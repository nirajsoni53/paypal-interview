package linkedList;

public class MergeTwoSortedLinkedList {

    //0 ->
    static Node mergeTwoSortedLinkList(Node first, Node second){
        if(first == null) return second;
        if (second == null) return first;
        Node result = new Node();
        Node temp = result;
        while(first != null || second != null){
            if(first == null){
                temp.next = second;
                second = second.next;
            }
            else if(second == null){
                temp.next = first;
                second = first.next;
            }
            else if (first.data <= second.data){
                temp.next = first;
                first = first.next;
            } else{
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Node first = new Node();
        first.data = 1;
        first.next = new Node();
        first.next.data = 3;
        first.next.next = new Node();
        first.next.next.data = 5;

        Node second = new Node();
        second.data = 2;
        second.next = new Node();
        second.next.data = 4;
        second.next.next = new Node();
        second.next.next.data = 6;

        mergeTwoSortedLinkList(first, second);
    }
}

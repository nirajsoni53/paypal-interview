package linkedList;

public class SortLinkedList {
    Node first = null;
    int size = 0;
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void sortLinkedList(){
        int[] a = new int[3];
        Node node = first;
        while(node != null){
            a[node.data]++;
            node = node.next;
        }

        node = first;
        int i = 0;
        while (node != null){
            if(a[i] == 0){
                i++;
            }else {
                node.data = i;
                node = node.next;
                a[i]--;
            }
        }
    }

    public void insertAtFirst(int value){
        Node node = new Node(value);
        Node f = first;
        if(f == null){
            first = node;
        }else{
            node.next = f;
            first = node;
        }
        size++;
    }

    public static void main(String[] args) {
        SortLinkedList s = new SortLinkedList();
        s.insertAtFirst(0);
        s.insertAtFirst(1);
        s.insertAtFirst(0);
        s.insertAtFirst(2);
        s.insertAtFirst(1);

        s.sortLinkedList();
        System.out.println(s);
    }
}

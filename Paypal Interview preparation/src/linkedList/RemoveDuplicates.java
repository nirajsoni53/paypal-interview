package linkedList;

public class RemoveDuplicates {
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
    public Node removeDuplicates(Node root){
        // 1 -> 2 -> 2 -> 3 -> 3
        Node node = root;
        while(node != null && node.next != null){
            if(node.data == node.next.data){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return root;
    }

    public void insertAtLast(int value){
        Node newNode = new Node(value);

        if(first == null){
            first = newNode;
        }else {
            Node node = findNodeByIndex(size);
            node.next = newNode;
        }
        size++;
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

    void insertAtPosition(int pos, int value){
        if(pos > size) throw new RuntimeException("No position available");
        if(pos == 0){
            insertAtFirst(value);
        }
        else if (pos == size-1){
            insertAtLast(value);
        } else {
            Node node = findNodeByIndex(pos);
            Node newNode = new Node(value);
            newNode.next = node.next;
            node.next = newNode;
            size++;
        }
    }

    Node findNodeByIndex(int index){
        if(first == null) throw new RuntimeException("No position available");
        Node f = first;
        for (int i =0; i<index-1; i++){
            f = f.next;
        }
        return f;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.insertAtLast(1);
        removeDuplicates.insertAtLast(2);
        removeDuplicates.insertAtLast(2);
        removeDuplicates.insertAtLast(3);
        removeDuplicates.insertAtLast(3);
        removeDuplicates.removeDuplicates(removeDuplicates.first);
    }

}

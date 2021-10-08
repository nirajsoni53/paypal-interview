package linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
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


    /*public Node reverse(){
        Node node = first;
        Node newNode = new Node(node.data);
        return reverseHelper(node.next, newNode);
    }*/

    Node reverse()
    {
        Node node = first;
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    private Node reverseHelper(Node node, Node newNode){
        if(node == null) return null;// 1 - 2 - 3
        node.next = newNode;
        newNode = node;
        reverseHelper(node.next, newNode);
        return newNode;
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

    void removeFirst(){
        if(first == null) throw new RuntimeException("No node available");
        first = first.next;
        size--;
    }

    void removeLast(){
        if(first == null) throw new RuntimeException("No node available");
        if(size == 1) first = null;
        else {
            Node node = findNodeByIndex(size-1);
            node.next = null;
        }
        size--;
    }

    void remove(int index){
        if (index == 0) removeFirst();
        else if(index == size-1) removeLast();
        else{
            Node node = findNodeByIndex(index);
            node.next = node.next.next;
            size--;
        }
    }

    void detectLoop()
    {
        Node slow_p = first, fast_p = first;
        int flag = 0;
        while (slow_p != null && fast_p != null
                && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Loop found");
        else
            System.out.println("Loop not found");
    }

    static boolean hasCycle(Node head) {
        Set<Node> cycleDetectionStorage = new HashSet<>();
        Node node = head;
        while(node != null){
            if(cycleDetectionStorage.contains(node)){
                return true;
            }

            cycleDetectionStorage.add(node);
            node = node.next;
        }
        return false;
    }

    Node removeCycle(){
        Node currentNode = first;
        Node prevNode = null;

        Set<Node> nodes = new HashSet<>();

        while(currentNode != null){
            if(nodes.contains(currentNode)){
                prevNode.next = null;
                return first;
            }
            nodes.add(currentNode);
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        return first;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.insertAtFirst(10);
        l.insertAtLast(20);
        l.insertAtLast(20);
        l.insertAtLast(30);
        l.insertAtLast(25);
        l.first.next.next.next.next = l.first.next;
        /*l.insertAtLast(40);
        l.insertAtLast(50);
        l.insertAtLast(60);
        l.insertAtPosition(3, 15);*/
        /*l.removeFirst();
        l.removeLast();
        l.remove(1);
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();
        l.removeFirst();*/
        l.detectLoop();
        l.removeCycle();
        //l.reverse();
        //l.deleteNode(20);
        /*l.print();*/
        System.out.println(l);
    }
}

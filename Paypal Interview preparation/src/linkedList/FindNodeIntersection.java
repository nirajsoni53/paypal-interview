package linkedList;

import java.util.HashSet;
import java.util.Set;

class Node
{
    int data;
    Node next;
}
public class FindNodeIntersection {


    public static Node push(Node head, int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = head;
        return node;
    }

    // Function to find the intersection point of two linked lists using hashing
    public static Node findIntersection(Node first, Node second)
    {
        // maintain a set to store list nodes
        Set<Node> nodes = new HashSet<>();

        // traverse the first list and insert the address of each node into the set
        while (first != null)
        {
            nodes.add(first);
            first = first.next;
        }

        // now traverse the second list and find the first node that is
        // already present in the set
        while (second != null)
        {
            // return the current node if it is found in the set
            if (nodes.contains(second)) {
                return second;
            }
            second = second.next;
        }

        // we reach here if lists do not intersect
        return null;
    }

    static Node findInterSectionWithoutStorage(Node loop, Node head){
        Node currentNode = loop;
        while(head != null && currentNode != null && head != currentNode){
            head = head.next;
            currentNode = currentNode.next;
        }
        return currentNode == head ? currentNode : null;
    }

    public static void main(String[] args)
    {
        // construct the first linked list (1 —> 2 —> 3 —> 4 —> 5 —> null)
        Node first = null;
        for (int i = 5; i > 0; i--) {
            first = push(first, i);
        }

        // construct the second linked list (1 —> 2 —> 3 —> null)
        Node second = null;
        for (int i = 3; i > 0; i--) {
            second = push(second, i);
        }

        // link tail of the second list to the fourth node of the first list
        second.next.next.next = first.next.next.next;

        Node addr = findIntersection(first, second);
        if (addr != null) {
            System.out.println("The intersection point is " + addr.data);
        }
        else {
            System.out.println("The lists do not intersect.");
        }

        addr = findInterSectionWithoutStorage(first, second);
        if (addr != null) {
            System.out.println("The intersection point is " + addr.data);
        }
        else {
            System.out.println("The lists do not intersect.");
        }
    }
}

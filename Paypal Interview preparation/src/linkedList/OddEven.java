package linkedList;

class Node1
{
    int data;
    Node1 next;

    Node1(int data){
        this.data = data;
        this.next = null;
    }
}
public class OddEven {

    public static Node1 oddEven(Node1 node){// 1 -> 3 -> 5 -> 2 -> 4
                                            // 1 -> 5 -> 2 -> 4 -> 3
                                            // 1 -> 2 -> 4 -> 3 -> 5
        if(node == null) return null;
        Node1 end = node;
        int counter = 0;
        while(end.next != null){
            end = end.next;
            counter++;
        }
        counter = counter % 2 == 0 ? (counter /2)+1 : counter/2;

        Node1 temp = node;
        while (counter != 0){
            end.next = temp.next;
            temp.next = temp.next.next;
            end.next.next = null;

            temp = temp.next;
            end = end.next;
            counter--;
        }
        return node;
    }

    public static void main(String[] args) {
        Node1 node = new Node1(1);
        node.next = new Node1(3);
        node.next.next = new Node1(5);
        node.next.next.next = new Node1(2);
        node.next.next.next.next = new Node1(4);
        oddEven(node);
    }
}

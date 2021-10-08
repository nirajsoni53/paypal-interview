package linkedList;

public class MergeKList {
    static Node mergeKList(Node[] node){
        if(node == null || node.length == 0) return null;
        return mergeKList(node, 0, node.length - 1);
    }

    private static Node mergeKList(Node[] node, int start, int end){
        if(start == end) return node[start];
        int mid = (start + end) / 2;
        Node left = mergeKList(node, 0, mid);
        Node right = mergeKList(node, mid + 1, end);
        return merge(left , right);
    }

    private static Node merge(Node left, Node right){
        Node node = new Node();
        Node curr = node;

        while(left != null || right != null){
            if(left == null){
                curr.next = right;
                right = right.next;
            } else if(right == null){
                curr.next = left;
                left = left.next;
            } else if(left.data <= right.data){
                curr.next = left;
                left = left.next;
            } else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        return node.next;
    }
}

package tree;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class CheckTreeIsBST {

    static boolean isBST(Node root){
        if (root == null) return true;
        if(isSubtreeLesser(root.left, root.data) &&
                isSubtreeGreter(root.right, root.data) &&
                isBST(root.left) && isBST(root.right)
        ){
            return true;
        }
        else return false;
    }

    static boolean isSubtreeLesser(Node root, int value){
        if (root == null) return true;
        if(root.data <= value &&
                isSubtreeLesser(root.left, value) &&
                isSubtreeLesser(root.right, value)
           ){
            return true;
        }
        else return false;
    }

    static boolean isSubtreeGreter(Node root, int value){
        if (root == null) return true;
        if(root.data > value &&
                isSubtreeGreter(root.left, value) &&
                isSubtreeGreter(root.right, value)
        ){
            return true;
        }
        else return false;
    }

    static boolean checkBST(Node root) {
        return bstChecker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean bstChecker(Node root, int minValue, int maxValue){
        if(root == null) return true;
        if(root.data > minValue && root.data < maxValue
                && bstChecker(root.left, minValue, root.data)
                && bstChecker(root.right, root.data, maxValue)
        ){
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right = new Node(9);
        System.out.println(checkBST(root));
        System.out.println(isBST(root));
    }
}

package tree;

public class HeightOfBinaryTree {

    static int findHeightOfTree(Node root){
        return findHeightOfTree(root, 1);
    }

    static int maxHeight = 1;
    static int findHeightOfTree(Node root, int height){
        if (root == null) return 0;
        if (height > maxHeight) maxHeight = height;
        findHeightOfTree(root.left, height+1);
        findHeightOfTree(root.right, height+1);
        return maxHeight;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(9);
        root.left.left.right = new Node(7);
        root.right = new Node(11);
        root.right.right = new Node(12);
        root.right.right.right = new Node(13);
        root.right.right.right.right = new Node(14);
        root.right.right.right.right.right = new Node(15);
        root.right.right.right.right.right.right = new Node(15);

        System.out.println(findHeightOfTree(root));
    }
}

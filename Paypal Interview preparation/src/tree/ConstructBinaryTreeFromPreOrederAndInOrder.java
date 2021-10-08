package tree;

public class ConstructBinaryTreeFromPreOrederAndInOrder {
    public Tree buildTree(int[] inOrder, int[] preOrder){
        return helper(0, 0, inOrder.length - 1, inOrder, preOrder);
    }

    private Tree helper(int preStart, int inStart, int inEnd,
                        int[] inOrder, int[] preOrder){
        if(preStart > preOrder.length || inStart > inEnd) return null;
        Tree root = new Tree(preOrder[preStart]);

        int inIndex = 0;
        for (int i = 0; i <= inEnd; i++){
            if(root.value == inOrder[i]) {
                inIndex = i;
                break;
            }
        }

        root.left =  helper(preStart + 1, inStart, inIndex -1, inOrder, preOrder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, inOrder, preOrder);

        return root;
    }

    public static void main(String[] args) {
        Tree root = new ConstructBinaryTreeFromPreOrederAndInOrder()
                .buildTree(new int[]{9, 3, 15, 20, 7},
                           new int[]{3, 9, 20, 15, 7});
        System.out.println(root);
    }
}

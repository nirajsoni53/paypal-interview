package tree.binaryTree;

import tree.Tree;

/*
*                  15
*             10         20
*           8    12    17   25
*        6     11     16       27
*
* InOrder is = 6 8 10 11 12 15 16 17 20 25 27
*
* e.g val 10 inOrder predecessor is 8 (previous number).
* e.g val 12 inOrder predecessor is 11 (left -> strictly right).
* e.g val 15 inOrder predecessor is 12 (left -> strictly right).
* Rule 1: If target node has left sub node then go to left and then strictly right.
*        if right is not available then return left.
* Rule 2: If target doesn't have left node then return it's smallest parent lesser then current value.
*         e.g. value = 12 predecessor will be 11 which is its smallest and < then 12.
* */
public class InOrderPredecessor {

    Tree findIOP(Tree root, int val){
        if(root == null){
            return null;
        }
        Tree inOrderPredecessor = null;

        while(root != null){
            if(root.value > val){
                root = root.left;
            }else if(root.value < val){
                root = root.right;
                inOrderPredecessor = root;
            } else{
                if(root.left != null)
                    inOrderPredecessor = findPredecessor(root);
                break;
            }
        }
        return inOrderPredecessor;
    }

    private Tree findPredecessor(Tree root) {
        Tree temp = root.left;
        while(temp.right != null){
            temp  = temp.right;
        }
        return temp;
    }

    public static void main(String[] args) {
        Tree tree = new Tree(15);
        tree.left = new Tree(10);
        tree.left.left = new Tree(8);
        tree.left.left.left = new Tree(6);
        tree.left.right = new Tree(12);
        tree.left.right.left = new Tree(11);

        tree.right = new Tree(20);
        tree.right.right = new Tree(25);
        tree.right.right.right = new Tree(27);
        tree.right.left = new Tree(17);
        tree.right.left.left = new Tree(16);

        Tree result = new InOrderPredecessor().findIOP(tree, 12);
        System.out.println(result);
    }
}

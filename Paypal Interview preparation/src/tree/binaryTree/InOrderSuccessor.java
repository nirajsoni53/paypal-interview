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
* e.g val 10 inOrder successor is 11 (next number).
* e.g val 12 inOrder successor is 15 (smallest parent > then current value).
* e.g val 15 inOrder successor is 16 (right -> strictly left).
* Rule 1: If target node has right sub node then go to right and then strictly left.
*        if left is not available then return right.
* Rule 2: If target doesn't have right node then return it's smallest parent bigger then current value.
*         e.g. value = 12 successor will be 15 which is its smallest and > then 12.
* */
public class InOrderSuccessor {

    Tree findIOS(Tree root, int val){
        if(root == null){
            return null;
        }
        Tree inOrderSuccessor = null;

        while(root != null){
            if(root.value > val){
                inOrderSuccessor = root;
                root = root.left;
            }else if(root.value < val){
                root = root.right;
            } else{
                if(root.right != null)
                    inOrderSuccessor = findSuccessor(root);
                break;
            }
        }
        return inOrderSuccessor;
    }

    private Tree findSuccessor(Tree root) {
        Tree temp = root.right;
        while(temp.left != null){
            temp  = temp.left;
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

        new InOrderSuccessor().findIOS(tree, 15);
    }
}

package tree.midium;

import tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderMy {

    int maxLevel = 0;
    public List<List<Integer>> levelOrder(Tree root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i< size; i++){
                Tree tree = queue.remove();
                list.add(tree.value);
                if(tree.left != null) queue.add(tree.left);
                if(tree.right != null) queue.add(tree.right);
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
       /* Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        root.right = new Tree(5);
        new LevelOrderMy().levelOrder(root);*/

        Tree root1 = new Tree(1);
        root1.left = new Tree(2);
        root1.left.left = new Tree(4);
        root1.right = new Tree(3);
        root1.right.right = new Tree(5);
        new LevelOrderMy().levelOrder(root1);
    }
}

package tree;

import java.util.ArrayList;
import java.util.List;

/*113. Path Sum II
 */
public class PathSum2 {

    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> pathSum(Tree root, int targetSum) {
        if(root == null || targetSum == 0) return result;
        List<Integer> list = new ArrayList<>();
        pathSum(root, targetSum, list, 0);
        return result;
    }

    static void pathSum(Tree root, int targetSum, List<Integer> list, int sum) {
        if(root == null) return;

        sum += root.value;
        list.add(root.value);

        if(sum == targetSum && root.left == null && root.right == null) {
            result.add(list);
            return;
        }
        pathSum(root.left, targetSum, new ArrayList<>(list), sum);
        pathSum(root.right, targetSum, new ArrayList<>(list), sum);
    }


    public static void main(String[] args) {
        Tree root = new Tree(5);

        root.left = new Tree(4);
        root.left.left = new Tree(11);
        root.left.left.left = new Tree(7);
        root.left.left.right = new Tree(2);

        root.right = new Tree(8);
        root.right.left = new Tree(13);
        root.right.right = new Tree(4);
        root.right.right.left = new Tree(5);
        root.right.right.right = new Tree(1);

        pathSum(root,22);

    }
}

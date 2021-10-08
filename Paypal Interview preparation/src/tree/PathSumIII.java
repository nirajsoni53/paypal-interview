package tree;

import java.util.HashMap;

/*437. Path Sum III
 */
public class PathSumIII {
    static int totalSum = 0;
    public static int pathSum(Tree root, int targetSum) {
        if(root == null) return 0;
        findPathSum(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return totalSum;
    }

    private static void findPathSum(Tree root, int sum, int targetSum) {
        if(root == null) return;
        sum+=root.value;
        if(sum == targetSum) totalSum++;
        findPathSum(root.left, sum, targetSum);
        findPathSum(root.right, sum, targetSum);
    }

    static int pathSum2(Tree root, int targetSum){
        if(root == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        findPathSum(root, 0, targetSum, map);
        return totalSum;
    }

    static void findPathSum(Tree root, int sum, int targerSum, HashMap<Integer, Integer> map){
        if (root == null) return;
        sum+=root.value;
        if (map.containsKey(sum - targerSum))
            totalSum += map.get(sum - targerSum);
        map.put(sum, map.getOrDefault(sum, 0)+1);
        findPathSum(root.left, sum, targerSum, map);
        findPathSum(root.right, sum, targerSum, map);

        map.put(sum, map.get(sum) -1);
    }

    public static void main(String[] args) {
        Tree root = new Tree(10);

        root.left = new Tree(5);
        root.left.left = new Tree(3);
        root.left.right = new Tree(2);
        root.left.right.right = new Tree(1);
        root.left.left.right = new Tree(-2);
        root.left.left.left = new Tree(3);


        root.right = new Tree(-3);
        root.right.right = new Tree(11);

        //System.out.println(pathSum(root, 8));
        System.out.println(pathSum2(root, 8));
    }
}

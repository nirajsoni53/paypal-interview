package dp.house_robber3;

import java.util.HashMap;
import java.util.Map;

/*
* Time: O(n)
* Space: O(n)
* */
public class HouseRobber3Memoization {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);

        int leftSub = 0;
        int rightSub = 0;

        if(root.left != null)
            leftSub = rob(root.left.left) + rob(root.left.right);
        if(root.right != null)
            rightSub = rob(root.right.left) + rob(root.right.right);

        int keep = root.val + leftSub + rightSub;
        int skip = rob(root.left) + rob(root.right);

        map.put(root, Math.max(keep, skip));
        return map.get(root);
    }
}

package tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*98. Validate Binary Search Tree
Test Input:
[2,1,3]
[5,1,4,null,null,3,6]
[5,4,6,null,null,3,7]
[2147483647]
[-2147483648,null,2147483647]
 */
public class ValidBSTnew {
    public boolean isValidBST(Tree root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        return bstChecker(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean bstChecker(Tree root, long minValue, long maxValue){
        if(root == null) return true;
        if(root.value > minValue && root.value < maxValue
                && bstChecker(root.left, minValue, root.value)
                && bstChecker(root.right, root.value, maxValue)
        ){
            return true;
        }
        else return false;
    }
}

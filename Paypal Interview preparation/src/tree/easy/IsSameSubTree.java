package tree.easy;

import tree.Tree;

public class IsSameSubTree {
    public boolean isSubtree(Tree root, Tree subRoot) {
        if(root==null) return subRoot==null;
        if((root.value==subRoot.value && isSameTree(root, subRoot))
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot))
            return true;
        return false;
    }
    private boolean isSameTree(Tree root, Tree subRoot){
        if(root==null) return subRoot==null;
        if(subRoot==null) return root==null;
        if(root.value==subRoot.value && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right))
            return true;
        return false;
    }
}

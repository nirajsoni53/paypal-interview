package tree;

import java.util.ArrayList;

public class SearchInBST {
    public Tree searchBST(Tree root, int val) {
        if(root == null) return null;
        if(val < root.value) return searchBST(root.left, val);
        else if(val > root.value) return searchBST(root.right, val);
        return root;
    }
}

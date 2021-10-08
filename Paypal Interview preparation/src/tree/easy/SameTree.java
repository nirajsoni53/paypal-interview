package tree.easy;

import tree.Tree;

public class SameTree {
    public static boolean isSameTree(Tree p, Tree q) {
        return isSameTreeHelper(p , q, true);
    }

    public static boolean isSameTreeHelper(Tree p, Tree q, boolean flag) {
        if(p == null && q == null) return true;
        if(p != null && q == null) return false;
        else if(p == null && q != null) return false;
        if(p.value != q.value) return false;

        flag = flag && isSameTreeHelper(p.left, q.left, flag);
        flag = flag && isSameTreeHelper(p.right, q.right, flag);
        return flag;
    }



}

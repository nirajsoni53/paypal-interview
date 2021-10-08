package tree;

public class SameBST {

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

    public static void main(String[] args) {
        Tree f = new Tree(1);
        //f.left = new Tree(2);
        f.right = new Tree(3);

        Tree s = new Tree(1);
        s.left = new Tree(2);
        //s.right = new Tree(3);

        System.out.println(isSameTree(f,s));
    }
}

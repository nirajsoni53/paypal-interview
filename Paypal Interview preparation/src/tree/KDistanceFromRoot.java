package tree;

import java.util.ArrayList;

public class KDistanceFromRoot {

    ArrayList<Integer> Kdistance(Tree root, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        if(k == 0) list.add(root.value);
        else Kdistance(root, k, 0, list);
        return list;
    }

    void Kdistance(Tree root, int k, int distance, ArrayList<Integer> list){
        if(root == null) return;
        if(distance == k) {
            list.add(root.value);
        }
        else
        {
            Kdistance(root.left, k, distance + 1, list);
            Kdistance(root.right, k, distance + 1, list);
        }
    }
}

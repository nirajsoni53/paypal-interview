package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* https://leetcode.com/problems/clone-graph/
* 133. Clone Graph
* Medium
* */
class Node{
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class DeepClone {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> copyMap = new HashMap<>();
        return clone(node, copyMap);
    }

    private Node clone(Node node, Map<Node, Node> copyMap){
        if(copyMap.containsKey(node))
            return copyMap.get(node);

        Node copy = new Node(node.val);
        copyMap.put(node, copy);

        for(Node edge: node.neighbors){
            copy.neighbors.add(clone(edge, copyMap));
        }
        return copy;
    }
}

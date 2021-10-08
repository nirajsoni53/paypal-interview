package union_disjoin;


/*
* e.g [[0,1],[2,3],[2,1],[3,4],[4,0]]
*
*          0
*               4
*      1
*               3
*          2
*
* Step 1: parent arr = [-1, -1, -1, -1, -1] created by no of nodes which is 5
*
* Step 2: Join 0,1 so parent arr = [-1, 0, -1, -1, -1]
*
* Step 3: Join 2,3 so parent arr = [-1, 0, -1, 2, -1]
*
* Step 4: Join 2,1 so parent arr = [2, 0, -1, 2, -1]
*
* Step 5: Join 3,4 so parent arr = [2, 0, -1, 2, 2]
*
* Step 6: Join 4,0 so here there is already have a link from 0 to 4
* which is 0 -> 1 -> 2 -> 3 -> 4, so its a cycle then we can ignor it.
* */
public class UnionDisjoinWithoutRankOrCompressor {
    int[] parent;
    public boolean joinByRank(int[][] edgeList){
        parent = new int[5];
        for (int i = 0; i < 5; i++){
            parent[i] = -1;
        }
        return isHasCycle(edgeList);
    }

    private boolean isHasCycle(int[][] edgeList) {
        for(int[] edge : edgeList){
            int from = find(edge[0]);
            int to = find(edge[1]);

            if(from == to) return true;

            union(from, to);
        }
        return false;
    }

    private void union(int from, int to) {
        /*
         * parent[find(to)] = find(from);
         * */
        parent[to] = from;
    }

    private int find(int node) {
        if(parent[node] == -1) return node;
        //find the parent and update in current node.
        return find(parent[node]);
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{2,3},{2,1},{3,4},{4,0}};
        new UnionByRankWIthPathCompressor().joinByRank(edges);
    }
}

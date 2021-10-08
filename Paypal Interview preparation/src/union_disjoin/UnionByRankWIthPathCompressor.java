package union_disjoin;

public class UnionByRankWIthPathCompressor {

    int[] parent;
    int[] rank;

    public boolean joinByRank(int[][] edgeList){
        parent = new int[5];
        rank = new int[5];
        for (int i = 0; i < 5; i++){
            parent[i] = -1;
            rank[i] = 0;
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
        if(rank[from] > rank[to]){
            parent[to] = from;
        }else if(rank[from] < rank[to]){
            parent[from] = to;
        } else {
            parent[from] = to;
            rank[to]++;
        }
    }

    private int find(int node) {
        // if node is parent then return itself.
        if(parent[node] == -1) return node;

        //find the absolute parent and update in current node.
        int p = find(parent[node]);
        return parent[node] = p;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{2,3},{1,2},{0,4},{4,3}};
        new UnionByRankWIthPathCompressor().joinByRank(edges);
    }
}

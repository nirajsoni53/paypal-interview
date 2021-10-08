package mst.water_districution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaterDistributionInVillage2 {
        public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
            List<EdgeCost> costs = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                costs.add(new EdgeCost(0, i, wells[i - 1]));
            }
            for (int[] p : pipes) {
                costs.add(new EdgeCost(p[0], p[1], p[2]));
            }
            Collections.sort(costs);
            int minCosts = 0;
            UnionFind uf = new UnionFind(n);
            for (EdgeCost edge : costs) {
                int rootX = uf.find(edge.node1);
                int rootY = uf.find(edge.node2);
                if (rootX == rootY) continue;
                minCosts += edge.cost;
                uf.union(edge.node1, edge.node2);
                // for each union, we connnect one node
                n--;
                // if all nodes already connected, terminate early
                if (n == 0) {
                    return minCosts;
                }
            }
            return minCosts;
        }

        class EdgeCost implements Comparable<EdgeCost> {
            int node1;
            int node2;
            int cost;
            public EdgeCost(int node1, int node2, int cost) {
                this.node1 = node1;
                this.node2 = node2;
                this.cost = cost;
            }

            @Override
            public int compareTo(EdgeCost o) {
                return this.cost - o.cost;
            }
        }

        class UnionFind {
            int[] parent;
            int[] rank;
            public UnionFind(int n) {
                parent = new int[n + 1];
                for (int i = 0; i <= n; i++) {
                    parent[i] = i;
                }
                rank = new int[n + 1];
            }
            public int find(int x) {
                return x == parent[x] ? x : find(parent[x]);
            }
            public void union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) return;
                if (rank[px] >= rank[py]) {
                    parent[py] = px;
                    rank[px] += rank[py];
                } else {
                    parent[px] = py;
                    rank[py] += rank[px];
                }
            }
        }

    public static void main(String[] args) {
        /* TEST CASE 1*/
        int[] wells = new int[]{1, 2, 2};
        int[][] pipes = new int[][]{{1, 2, 1}, {2, 3, 1}};
        int totalCost = new WaterDistributionInVillage2().minCostToSupplyWater(3, wells, pipes);

        System.out.println(totalCost == 3);
    }
}

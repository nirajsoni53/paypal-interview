package mst.water_districution;

import java.util.*;

/* Space : O(2 * n + w), Time: O(E logE) + O(P) */
public class WaterDistributionInVillage {

    int parent[];
    public int minimumCostToWaterSupply(int n, int[] wells, int[][] pipes){
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        Map<Integer, Integer> costDetector = new HashMap<>();
        for (int i = 1; i <= wells.length; i++){
            costDetector.put(i, wells[i - 1]);
        }

        Arrays.sort(pipes, Comparator.comparingInt(pipe -> pipe[2]));

        int totalCost = 0;

        for (int[] pipe : pipes){
            int homeA = pipe[0];
            int homeB = pipe[1];
            int cost = pipe[2];

            int minWell = Math.min(costDetector.get(find(homeA)), costDetector.get(find(homeB)));
            int costOfSeprateWell = costDetector.get(find(homeA)) + costDetector.get(find(homeB));

            /* This area is only calculate cost of pipes */
            if(costOfSeprateWell > (minWell + cost)){
                union(find(homeA), find(homeB));
                costDetector.put(find(homeA), minWell);
                totalCost += cost;
            }
        }

        /* This area is to calculate cost of well and sum with total cost*/
        Set<Integer> visited = new HashSet<>();
        for (int i = 1; i <= n; i++){
            int parent = find(i);
            if(!visited.contains(parent)){
                totalCost += costDetector.get(parent);
                visited.add(parent);
            }
        }

        return totalCost;
    }

    private int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    private void union(int from, int to){
        parent[from] = to;
    }


    public static void main(String[] args) {

        /* TEST CASE 1*/
        int[] wells = new int[]{1, 2, 2};
        int[][] pipes = new int[][]{{1, 2, 1}, {2, 3, 1}};
        int totalCost = new WaterDistributionInVillage().minimumCostToWaterSupply(3, wells, pipes);

        System.out.println(totalCost == 3);

        /* TEST CASE 2*/
        int[] wells1 = new int[]{1, 2, 2};
        int[][] pipes1 = new int[][]{{1, 2, 3}, {2, 3, 2}};
        int totalCost1 = new WaterDistributionInVillage().minimumCostToWaterSupply(3, wells1, pipes1);

        System.out.println(totalCost1 == 5);

        /* TEST CASE 3*/
        int[] wells2 = new int[]{1, 4, 2};
        int[][] pipes2 = new int[][]{{1, 2, 3}, {2, 3, 2}};
        int totalCost2 = new WaterDistributionInVillage().minimumCostToWaterSupply(3, wells2, pipes2);

        System.out.println(totalCost2 == 5);


        /* TEST CASE 4*/
        int[] wells3 = new int[]{1,2,2,3,2};
        int[][] pipes3 = new int[][]{{1,2,1}, {2,3,1}, {4,5,7}};
        int totalCost3 = new WaterDistributionInVillage().minimumCostToWaterSupply(5, wells3, pipes3);

        System.out.println(totalCost3 == 8);
    }
}

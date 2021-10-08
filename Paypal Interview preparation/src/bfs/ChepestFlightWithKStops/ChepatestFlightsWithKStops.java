package bfs.ChepestFlightWithKStops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DestCost{
    int destination;
    int cost;

    public DestCost(int destination, int cost){
        this.destination = destination;
        this.cost = cost;
    }
}

/*
* Time: O(V + E), here E can be go to v to v^2 if graph is fully connected.
* Time: O(V^2) if we use Adjacency matrix.
* */
public class ChepatestFlightsWithKStops {
    int minCost = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<DestCost>> adj = new HashMap<>();
        for(int[] pair: flights){
            int source = pair[0];
            int destination = pair[1];
            int cost = pair[2];
            if(adj.containsKey(source)){
                List<DestCost> destCost = adj.get(source);
                destCost.add(new DestCost(destination, cost));
                adj.put(source, destCost);
            }else{
                List<DestCost> destCost = new ArrayList<>();
                destCost.add(new DestCost(destination, cost));
                adj.put(source, destCost);
            }
        }

        findCheapestPrice(src, dst, k, adj, 0);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    public void findCheapestPrice(int src, int dst, int k, Map<Integer, List<DestCost>> adj, int cost) {
        if(cost > minCost) return;
        if(src == dst) {
            minCost = cost;
            return;
        }
        if(k < 0) return;
        if(!adj.containsKey(src)) return;
        for(DestCost pair : adj.get(src)){
            findCheapestPrice(pair.destination, dst, (k - 1), adj, cost + pair.cost);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dest = 2;
        int k = 1;

        int result = new ChepatestFlightsWithKStops().findCheapestPrice(n, flights, src, dest,k);
        System.out.println(result == 200);

        /* TEST CASE 2*/
        n = 3;
        flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        src = 0;
        dest = 2;
        k = 0;

        result = new ChepatestFlightsWithKStops().findCheapestPrice(n, flights, src, dest,k);
        System.out.println(result == 500);
    }
}

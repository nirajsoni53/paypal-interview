package bfs.ChepestFlightWithKStops;

import java.util.*;

class DestCostChecker{
    private int destination;
    private int cost;
    private int steps;

    public DestCostChecker(int destination, int cost, int steps){
        this.destination = destination;
        this.cost = cost;
        this.steps = steps;
    }

    public int getDestination() {
        return destination;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getCost() {
        return cost;
    }

    public int getSteps() {
        return steps;
    }
}

/*
* Time: O(V + E), here E can be go to v to v^2 if graph is fully connected.
* Time: O(V^2) if we use Adjacency matrix.
* */
public class CheapestFlightWithKStopsPQ {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<DestCostChecker>> adj = new HashMap<>();
        for(int[] pair: flights){
            int source = pair[0];
            int destination = pair[1];
            int cost = pair[2];
            List<DestCostChecker> destCost;
            destCost = adj.containsKey(source) ? adj.get(source) : new ArrayList<>();
            destCost.add(new DestCostChecker(destination, cost, k));
            adj.put(source, destCost);
        }

        Map<Integer, Integer> vertexHopMap = new HashMap<>();
        PriorityQueue<DestCostChecker> queue = new PriorityQueue<>(
                Comparator.comparingInt(DestCostChecker::getCost)
        );

        queue.offer(new DestCostChecker(src, 0, 0));

        while (!queue.isEmpty()){
            DestCostChecker destCode = queue.poll();
            int allowedSteps = k + 1;

            if(destCode.getDestination() == dst && destCode.getSteps() <= allowedSteps) return destCode.getCost();
            if (destCode.getSteps() > allowedSteps || (vertexHopMap.containsKey(destCode.getDestination())
                    && vertexHopMap.get(destCode.getDestination()) < destCode.getSteps())) {
                continue;
            }

            // To keep track of the vertex with minimum hop
            vertexHopMap.put(destCode.getDestination(), destCode.getSteps());

            if(!adj.containsKey(destCode.getDestination())) continue;
            for (DestCostChecker c: adj.get(destCode.getDestination())){
                queue.add(new DestCostChecker(c.getDestination(), destCode.getCost() + c.getCost(), destCode.getSteps() + 1));
            }
        }
        return -1;
    }
}

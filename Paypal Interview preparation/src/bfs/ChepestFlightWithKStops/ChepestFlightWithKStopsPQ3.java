package bfs.ChepestFlightWithKStops;

import java.util.*;

/*
 * If we use bellmen ford algoritham then Time: O(VE)
 * Time: O(ELogV).
 * Time: O(V^2) if we use Adjacency matrix.
 * */
public class ChepestFlightWithKStopsPQ3 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Pair>[] adjacencyList = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<Pair>();
        }

        for (int[] arr : flights) {
            adjacencyList[arr[0]].add(new Pair(arr[1], arr[2], 0));
        }

        // To keep track of the vertex with minimum hopping
        Map<Integer, Integer> vertexHopMap = new HashMap<>();
        return findCheapestPath(src, dst, k, adjacencyList, vertexHopMap);
    }

    public int findCheapestPath(int source, int destination, int k, ArrayList<Pair>[] adjacencyList, Map<Integer, Integer> vertexHopMap) {

        /* Allowed step we are keeping as k + 1 because hop is meant to a position between three vertex
         * Like    v1 --------  v2  ---------  v3
         *                   (hop : 1)
         *
         * So when we will be reaching to the destination for example v3 we will be having 2 hop
         */
        int allowedStops = k + 1;

        Queue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(obj -> obj.cost));
        minHeap.add(new Pair(source, 0, 0));

        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            /*
             *  Base Case-1:
             * If current pair's hop is already greater than allowedStops or
             * This vertex is being explored by some other path with less hop then
             * we do not want to process it's neighbour.
             */
            if (current.hop > allowedStops || (vertexHopMap.containsKey(current.vertex)
                    && vertexHopMap.get(current.vertex) < current.hop)) {

                continue;
            }

            // To keep track of the vertex with minimum hop
            vertexHopMap.put(current.vertex, current.hop);

            /*
             * Base Case-2:
             * If we have reached the destination and the no of hop opted is less than or equal to the allowed hop
             * Then return the cost.
             */
            if (current.vertex == destination && current.hop <= allowedStops) {
                return current.cost;
            }

            /*
             * Explore the neighbour of the current vertex
             */
            for (Pair neighbour : adjacencyList[current.vertex]) {
                minHeap.add(new Pair(neighbour.vertex, neighbour.cost + current.cost, current.hop + 1));
            }
        }

        return -1;
    }

    /**
     * Simple POJO class to Hold the basic data of a vertex
     */
    class Pair {
        public int vertex;
        public int cost;
        public int hop;

        Pair(int vertex, int cost, int hop) {
            this.vertex = vertex;
            this.cost = cost;
            this.hop = hop;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dest = 2;
        int k = 1;
/*

        int result = new ChepestFlightWithKStopsPQ3().findCheapestPrice(n, flights, src, dest,k);
        System.out.println(result == 200);
*/

       /* *//* TEST CASE 2*//*
        n = 3;
        flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        src = 0;
        dest = 2;
        k = 0;

        result = new ChepestFlightWithKStopsPQ3().findCheapestPrice(n, flights, src, dest,k);
        System.out.println(result == 500);*/


        n = 11;
        flights = new int[][]{{0,3,3},{3,4,3},{4,1,3},{0,5,1},{5,1,100},{0,6,2},{6,1,100},{0,7,1},{7,8,1},{8,9,1},{9,1,1},{1,10,1},{10,2,1},{1,2,100}};
        src = 0;
        dest = 2;
        k = 4;

        int result = new ChepestFlightWithKStopsPQ3().findCheapestPrice(n, flights, src, dest,k);
        System.out.println(result == 500);

        /*
        * 10
          [[3,4,4],[2,5,6],[4,7,10],[9,6,5],[7,4,4],[6,2,10],[6,8,6],[7,9,4],[1,5,4],[1,0,4],[9,7,3],[7,0,5],[6,5,8],[1,7,6],[4,0,9],[5,9,1],[8,7,3],[1,2,6],[4,1,5],[5,2,4],[1,9,1],[7,8,10],[0,4,2],[7,2,8]]
          6
          0
          7
        * */
    }
}

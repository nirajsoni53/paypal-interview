package mst;

import java.util.Arrays;
import java.util.Comparator;

/*
* Medium
* Find minimum cost to connect all cities.
*
* Use Kruskal algoritham
*
* first we create a group for n size, n is no of cities.
*
* Input = [[1, 2, 5], [2, 3, 1], [1, 3, 6]]
* here first 2 input's are cities and last one is cost.
* e.g 1 & 2 are cities and 5 is a cost to connect that city.
*
* */
public class ConnectingCities {

    int[] group;
    public int minimumCost(int[][] connections, int noOfCities){

        /* Create a group and assign its index as its value*/
        group = new int[noOfCities];
        for(int i = 0; i < noOfCities; i++){
            group[i] = i;
        }

        /* Sort the array based on cost a[2]*/
        Arrays.sort(connections, Comparator.comparingInt(f -> f[2]));

        /*Here a logic to find minimum cost*/
        int minCost = 0;
        /* Iterate and check for every array*/
        for (int[] con : connections){
            int city1 = con[0] - 1; // get the first city from array
            int city2 = con[1] - 1; // get the second city from array
            //here -1 is for do a index match bacuse array start from 0 index so.

            /* Here we if both city are not belong to same group then we can
            *  find the minimum cost and perform the union operation.
            *  */
            if(findParent(city1) != findParent(city2)){
                minCost += con[2];

                // this operation is to join two cities parent with each other.
                union(city1, city2);
            }
        }

        /* Here we take one parent and check if after all operation
        *  is there any cities which not belong to parent one.
        *
        *  1 ---> 2
        *  3 ---> 4
        *                           0  1  2  3
        * here our group look like [0, 0, 2, 2]
        *
        * so here there are 2 parents index[0] -> 0, index[2] --> 2
        * so we can say that those 2 groups are different then we can return -1.
        * */
        int currentGroup = findParent(0);
        for(int i = 0; i < noOfCities; i++){
            if(findParent(i) != currentGroup) return -1;
        }
        
        return minCost;
    }

    /* This function is use to find a parent of any given city*/
    private int findParent(int currentNode) {
        /* Here we check if given number's parent is itself then no need
        *  to find parent.
        *
        *  but if given number parent is different then its number then we have to
        *  find out the parent of that number, so we are doing recursive call.
        *
        * */
        if(group[currentNode] != currentNode){
            group[currentNode] = findParent(group[currentNode]);
        }
        return group[currentNode];
    }

    private void union(int a, int b){
        /* This function is use to connect one number parent to another number parent
        *  e.g  If i have to connect 1 with 2, then either 1 will be a parent of 2
        *  or 2 will be a parent of 1.
        *
        *  first we try to find 1's parent and then find 2's parent then we connect
        *  both parents.
        *
        *  e.g initial array : [0, 1, 2]
        *  if i want to connect 1 ---> 2 then my new array will be a
        *  [0, 0, 2] so value of index 1 will point to index 0.
        * */
        group[findParent(b)] = findParent(a);
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,5},{1,3,6},{2,3,1}};
        new ConnectingCities().minimumCost(arr, 3);

        int[][] arr1 = new int[][]{{1,2,3},{3,4,4}};
        new ConnectingCities().minimumCost(arr1, 4);
    }
}

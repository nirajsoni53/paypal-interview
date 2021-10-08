package greedy.gas_station;

public class GasStationN2_1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0;i<n;i++){
            if(gas[i] < cost[i]) continue;
            if(solve(i,n,gas,cost) == i) return i;
        }
        return -1;
    }

    int solve(int start, int n, int[]gas, int[]cost){
        int j = (start+1) % n, curr_gas = gas[start]-cost[start];
        while(j != start){
            curr_gas = curr_gas + gas[j] - cost[j];
            if(curr_gas < 0) break;
            j = (j+1) % n;
        }
        return j==start ? start : -1;
    }

    public static void main(String[] args) {
        /*int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};*/
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        int result = new GasStationN2_1().canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}

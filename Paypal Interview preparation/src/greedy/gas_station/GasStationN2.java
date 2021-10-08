package greedy.gas_station;

public class GasStationN2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total = 0;
        int start = 0;
        int j = 0;
        for(int i = 0; i < gas.length; i++){
            start = i; //3
            if(gas[i] < cost[i]) continue;
            j = (i + 1) % gas.length; //4
            total = gas[i] - cost[i]; //3,
            while(j != start){
                total = total + gas[j] - cost[j]; //3 + (5-2) = 6
                if(total < 0) break;
                j = (j+1) % gas.length; //0
            }
            if(j == start) return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        /*int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};*/
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        int result = new GasStationN2().canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}

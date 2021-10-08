package greedy.gas_station;

public class GasStationON {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int diff = 0;
        int n = gas.length;
        int start = -1;

        for(int i = 0; i < n; i++){
            sum = sum + (gas[i] - cost[i]);
            if(sum < 0){
                start = i + 1;
                diff += sum;
                sum = 0;
            }
        }
        return (sum + diff) >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        /*[1,2,3,4,5,6,7,8]
[3,1,4,2,8,3,3,6]*/
        int[] gas = new int[]{1,2,3,4,5,6,7,8};
        int[] cost = new int[]{3,1,4,2,8,3,3,6};
        int result = new GasStationON().canCompleteCircuit(gas, cost);
        System.out.println(result);    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;

        // -1 -1 -1 3
        // -1 -2 -3 0
        //  0  1  2 3


        // -1 -1  1
        // -1 -2 -1
        // -1  0  1
        int currentStart = 0;
        int balance = 0;
        for(int i = 0; i < gas.length; i++){
            balance += gas[i] - cost[i];
            if(balance < 0){
                currentStart = i+1;
                balance = 0;
            }
        }
        return currentStart;
    }
}

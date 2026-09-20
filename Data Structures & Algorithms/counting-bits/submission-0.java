class Solution {
   public int[] countBits(int n) {
        int[] result = new int[n+1];
        int power = -1;
        for(int i = 1; i < result.length; i++){
            if((1 << (power + 1)) == i){
                result[i] = 1;
                power++;
            } else {
                int twoPow = 1 << power;
                result[i] = result[twoPow] + result[i - twoPow];
            }
        }
        return result;
    }
}

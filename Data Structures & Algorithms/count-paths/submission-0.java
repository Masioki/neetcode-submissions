class Solution {
 public int uniquePaths(int rows, int cols) {
        if(rows == 0 || cols == 0){
            return 1;
        }
        int[] cache = new int[cols];
        Arrays.fill(cache, 1);
        for(int row = 0; row < rows - 1; row++){
            for(int col = cols - 2; col >= 0; col--){
                cache[col] = cache[col] + cache[col + 1];
            }
        }   
        return cache[0];     
    }
}

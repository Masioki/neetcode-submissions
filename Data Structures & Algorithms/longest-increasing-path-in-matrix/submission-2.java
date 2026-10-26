class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
                {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}

    };
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[0].length; y++){
                max = Math.max(max, explore(cache, matrix, x, y));
            }
        }
        return max;
    }
    
    private int explore(int[][] cache, int[][] matrix, int x, int y){
        if(cache[x][y] > 0){
            return cache[x][y];
        }
        
        int result = 0;
        for(int[] dir : DIRECTIONS){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(!validCoords(matrix, newX, newY)) continue;
            if(matrix[newX][newY] > matrix[x][y]){
                result = Math.max(result, explore(cache, matrix, newX, newY));
            }
        }
        
        result++;
        cache[x][y] = result;
        return result;
    }
    
    private boolean validCoords(int[][] matrix, int x, int y) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }
}
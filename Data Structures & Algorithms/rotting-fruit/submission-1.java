class Solution {
    public int orangesRotting(int[][] grid) {
        int leftCount = 0;
        Set<int[]> coords = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    leftCount++;
                }
                if(grid[i][j] == 2){
                    coords.add(new int[]{i, j});
                }
            }
        }
        if(leftCount == 0){
            return 0;
        }
        return step(grid, coords, leftCount, 0);
    }

    private int step(int[][] grid, Set<int[]> coords, int left, int iter){

        Set<int[]> nextCoords = new HashSet<>();
        for(var coord : coords){
            var newCoords = new int[][]{
                {coord[0] + 1, coord[1]},
                {coord[0] - 1, coord[1]},
                {coord[0], coord[1] + 1},
                {coord[0], coord[1] - 1}
            };
            for(var c : newCoords){
                var x = c[0];
                var y = c[1];
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
                    continue;
                }
                if(grid[x][y] == 1){
                    nextCoords.add(new int[]{x, y});
                    grid[x][y] = 2;
                }
            }
        }
        if(nextCoords.isEmpty()){
            return -1;
        }
        left = left - nextCoords.size();
        if(left == 0){
            return iter+1;
        }

        return step(grid, nextCoords, left, iter + 1);
    }

}

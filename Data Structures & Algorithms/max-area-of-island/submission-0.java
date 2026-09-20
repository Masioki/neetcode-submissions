class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[0].length; y++){
                if(grid[x][y] == 1){
                    result = Math.max(result, removeIsland(x, y, grid));
                }
            }
        }
        return result;
    }

    private int removeIsland(int x, int y, int[][] grid){
        Queue<int[]> toRemove = new ArrayDeque<>();
        toRemove.add(new int[]{x, y});
        grid[x][y] = 0;

        int removed = 0;
        while(!toRemove.isEmpty()){
            int[] coords = toRemove.poll();
            removed++;
            for(int[] direction : DIRECTIONS){
                int newX = coords[0] + direction[0];
                int newY = coords[1] + direction[1];
                if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length){
                    continue;
                }
                if(grid[newX][newY] == 1){
                    grid[newX][newY] = 0;
                    toRemove.add(new int[]{newX, newY});
                }
            }
        }
        return removed;
    }
}

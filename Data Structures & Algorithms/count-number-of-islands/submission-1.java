class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
  public int numIslands(char[][] grid) {
    int result = 0;
    for(int y = 0; y <grid.length; y++){
      for(int x = 0; x < grid[0].length; x++){
        if(grid[y][x] == '1'){
          result++;
          removeIsland(y, x, grid);
        }
      }
    }
    return result;
  }

  private void removeIsland(int y, int x, char[][] grid){
    Queue<int[]> toRemove = new ArrayDeque<>();
    toRemove.add(new int[]{y, x});
    grid[y][x] = '0';
    while(!toRemove.isEmpty()){
      var coords = toRemove.poll();
      for(int[] direction : DIRECTIONS){
        int newY = direction[0] + coords[0];
        int newX = direction[1] + coords[1];
        if(newY < 0 || newY >= grid.length || newX < 0 || newX >= grid[0].length){
          continue;
        }
        if(grid[newY][newX] == '1'){
          toRemove.add(new int[]{newY, newX});
          grid[newY][newX] = '0';
        }
      }
    }
  }
}

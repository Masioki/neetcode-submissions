class Solution {
    private final static int[][] DIRECTIONS = new int[][]{
        {0, 1}, // top
        {1, 0}, // right
        {0, -1}, // bottom
        {-1, 0} // left
    };

   public List<Integer> spiralOrder(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0) return List.of();

    int count = matrix.length * matrix[0].length;
    List<Integer> result = new ArrayList<>(count);
    int[] offset = new int[DIRECTIONS.length];
    int x = 0;
    int y = 0;
    int dirIndex = 0;
    result.add(matrix[x][y]);
    while(result.size() < count){
      int newX = x + DIRECTIONS[dirIndex][0];
      int newY = y + DIRECTIONS[dirIndex][1];
      if(!validCoords(matrix, newX, newY, offset)){
        offset[dirIndex]++;
        dirIndex = (dirIndex + 1) % DIRECTIONS.length;
        newX = x + DIRECTIONS[dirIndex][0];
        newY = y + DIRECTIONS[dirIndex][1];
      }
      x = newX;
      y = newY;
      result.add(matrix[x][y]);
    }
    return result;
  }

  private boolean validCoords(int[][] matrix, int x, int y, int[] offset){
    return x >= 0 + offset[0] && y >= 0 + offset[3] && x < matrix.length - offset[2] && y < matrix[0].length - offset[1];
  }
}
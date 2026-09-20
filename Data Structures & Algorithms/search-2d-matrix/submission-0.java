class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    return isPresent(findRow(matrix, target), target);
  }

  private int[] findRow(int[][] matrix, int target){
    int start = 0;
    int end = matrix.length - 1;
    while(start < end){
      int mid = (int) (start + Math.ceil((double) (end - start) / 2));
      if(matrix[mid][0] > target){
        end = mid - 1;
      } else {
        start = mid;
      }
    }
    return matrix[start];
  }

  private boolean isPresent(int[] row, int target) {
    int start = 0;
    int end = row.length - 1;
    while(start < end){
      int mid = start + ((end - start) / 2);
      if(row[mid] < target){
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return row[start] == target;
  }
}

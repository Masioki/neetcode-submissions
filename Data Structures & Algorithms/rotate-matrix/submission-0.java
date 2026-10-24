class Solution {
    public void rotate(int[][] matrix) {
        rowsToCols(matrix);
        rotateRows(matrix);
    }

    private void rowsToCols(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = row+1; col < matrix[0].length ; col++){
                swap(matrix, row, col, col, row);
            }
        }
    }

    private void rotateRows(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length / 2; col++){
                swap(matrix, row, col, row, matrix[0].length - 1 - col);
            }
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}
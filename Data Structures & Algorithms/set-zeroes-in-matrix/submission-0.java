class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        boolean markRowZerod = false;
        boolean markColZerod = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                markRowZerod = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                markColZerod = true;
                break;
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    mark(matrix, row, col);
                }
            }
        }
        zeroMarked(matrix);

        if (markRowZerod) {
            zeroRow(matrix, 0);
        }
        if (markColZerod) {
            zeroCol(matrix, 0);
        }
    }

    private void mark(int[][] matrix, int x, int y) {
        matrix[x][0] = 0;
        matrix[0][y] = 0;
    }

    private void zeroMarked(int[][] matrix) {
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                zeroRow(matrix, row);
            }
        }
        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                zeroCol(matrix, col);
            }
        }
    }

    private void zeroCol(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    private void zeroRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
    }
}

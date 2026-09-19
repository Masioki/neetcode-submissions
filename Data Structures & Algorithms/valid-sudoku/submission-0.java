class Solution {
       public boolean isValidSudoku(char[][] board) {
        int[][][] squares = new int[3][3][9];
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    var row = rows[i];
                    var col = cols[j];
                    var square = squares[i/3][j/3];
                    int value = (int) (board[i][j] - '1');
                    if(row[value] == 0){
                        row[value] = 1;
                    } else {
                        return false;
                    }

                    if(col[value] == 0){
                        col[value] = 1;
                    } else {
                        return false;
                    }

                    if(square[value] == 0){
                        square[value] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

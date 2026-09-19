class Solution {
        private static final int[][] DIRECTIONS = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
  public void solve(char[][] board) {
    if (board.length == 0) {
      return;
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
          if (board[i][j] == 'O') {
            search(i, j, board);
          }
        }
      }
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
        if (board[i][j] == 'T') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private void search(int i, int j, char[][] board) {
    board[i][j] = 'T';
    for (var direction : DIRECTIONS) {
      int x = i + direction[0];
      int y = j + direction[1];
      if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
        continue;
      }

      if (board[x][y] == 'O') {
        search(x, y, board);
      }
    }
  }
}

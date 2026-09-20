class Solution {
  private static final int[][] DIRECTIONS = new int[][]{
    {0, 1},
    {0, -1},
    {1, 0},
    {-1, 0}
  };

  public boolean exist(char[][] board, String word) {
    if(word == null || word.isEmpty()){
      return true;
    }
    if(board == null || board.length == 0 || board[0].length == 0){
      return false;
    }

    char firstChar = word.charAt(0);
    for(int x = 0; x < board.length; x++){
      for(int y = 0; y < board[0].length; y++){
        if(board[x][y] == firstChar){
          if(isPresent(board, word, 0, x, y)){
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean isPresent(char[][] board, String word, int wordIdx, int x, int y){
    if(wordIdx >= word.length() - 1){
      return true;
    }

    board[x][y] = 0;
    char currentChar = word.charAt(wordIdx);

    wordIdx++;
    char nextChar = word.charAt(wordIdx);
    for(int[] direction : DIRECTIONS){
      int newX = x + direction[0];
      int newY = y + direction[1];
      if(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length){
        continue;
      }
      if(board[newX][newY] == nextChar){
        if(isPresent(board, word, wordIdx, newX, newY)){
          return true;
        }
      }
    }
    board[x][y] = currentChar;
    return false;
  }


}

class Solution {
        private static final int[][] DIRECTIONS = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public void islandsAndTreasure(int[][] rooms) {
                Queue<int[]> starts = new ArrayDeque<>();
        for(int x = 0; x < rooms.length; x++){
            for(int y = 0; y < rooms[0].length; y++){
                if(rooms[x][y] == 0){
                    starts.add(new int[]{x, y});
                }
            }
        }


        int depth = 1;
        while(!starts.isEmpty()){
            int size = starts.size();
            for(int i = 0; i < size; i++){
                int[] coords = starts.poll();
                for(int[] direction : DIRECTIONS){
                    int newX = coords[0] + direction[0];
                    int newY = coords[1] + direction[1];
                    if(newX < 0 || newX >= rooms.length || newY < 0 || newY >= rooms[0].length){
                        // invalid coords
                        continue;
                    }
                    // valid coords
                    // get min from other fields
                    if(rooms[newX][newY] == Integer.MAX_VALUE){
                        rooms[newX][newY] = depth;
                        starts.add(new int[]{newX, newY});
                    }
                }
            }
            depth++;
        }
        
    }
}

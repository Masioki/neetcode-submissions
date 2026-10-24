class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return List.of();

        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        int[][] visited = new int[heights.length][heights[0].length];

        collectRow(queue, heights, 0);
        collectCol(queue, heights, 0);
        multiBfs(heights, visited, 1, queue, result);

        collectRow(queue, heights, heights.length - 1);
        collectCol(queue, heights, heights[0].length - 1);
        multiBfs(heights, visited, 2, queue, result);

        return result;
    }

    private void multiBfs(int[][] heights, int[][] visited, int marker, Queue<List<Integer>> queue,
        List<List<Integer>> result) {

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i <size; i++){
                var current = queue.poll();
                int row = current.get(0);
                int col = current.get(1);
                if(visited[row][col] == marker) continue;
                if(visited[row][col] > 0){
                    result.add(current);
                }
                visited[row][col] = marker;
                // neighbours
                int value = heights[row][col];
                for(int[] dir : DIRECTIONS){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(!validCoords(newRow, newCol, heights)) continue;
                    if(visited[newRow][newCol] == marker) continue;
                    if(heights[newRow][newCol] < value) continue;
                    queue.add(List.of(newRow, newCol));
                }
            }
        }
    }

    private boolean validCoords(int x, int y, int[][] heights) {
        return x >= 0 && x < heights.length && y >= 0 && y < heights[0].length;
    }

    private void collectRow(Queue<List<Integer>> queue, int[][] heights, int row) {
        for (int i = 0; i < heights[0].length; i++) {
            queue.add(List.of(row, i));
        }
    }

    private void collectCol(Queue<List<Integer>> queue, int[][] heights, int col) {
        for (int i = 0; i < heights.length; i++) {
            queue.add(List.of(i, col));
        }
    }
}

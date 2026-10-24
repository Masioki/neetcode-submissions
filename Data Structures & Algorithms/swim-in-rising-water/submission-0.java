class Solution {
    private final static int[][] DIRECTIONS = new int[][] {
        {0, 1}, // top
        {1, 0}, // right
        {0, -1}, // bottom
        {-1, 0} // left
    };

    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int targetX = grid.length - 1;
        int targetY = grid[0].length - 1;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Coord> queue = new PriorityQueue<>(Comparator.comparing(c -> c.time()));
        queue.add(new Coord(0, 0, grid[0][0]));
        while (!queue.isEmpty()) {
            var current = queue.poll();
            int x = current.x();
            int y = current.y();
            if (visited[x][y])
                continue;
            if (x == targetX && y == targetY)
                return current.time();
            visited[x][y] = true;
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (!validCoords(newX, newY, grid))
                    continue;
                if (visited[newX][newY])
                    continue;
                int newTime = Math.max(current.time(), grid[newX][newY]);
                queue.add(new Coord(newX, newY, newTime));
            }
        }
        return 0;
    }

    private boolean validCoords(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
record Coord(int x, int y, int time) {}
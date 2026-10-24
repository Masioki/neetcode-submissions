class CountSquares {
    private final Map<Point, Integer> pointCounts;
    private final Map<Integer, Set<Point>> diagonal;
    private final Map<Integer, Set<Point>> antiDiagonal;

    public CountSquares() {
        pointCounts = new HashMap<>();
        diagonal = new HashMap<>();
        antiDiagonal = new HashMap<>();
    }

    public void add(int[] point) {
        var key = new Point(point[0], point[1]);
        pointCounts.put(key, pointCounts.getOrDefault(key, 0) + 1);
        int diagonalKey = key.y() - key.x();
        diagonal.computeIfAbsent(diagonalKey, v -> new HashSet<>()).add(key);

        int antiDiagonalKey = key.y() + key.x();
        antiDiagonal.computeIfAbsent(antiDiagonalKey, c -> new HashSet<>()).add(key);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        return count(x, y, diagonal.getOrDefault(y - x, Set.of())) + count(x, y, antiDiagonal.getOrDefault(y + x,Set.of()));
    }

    private int count(int x, int y, Set<Point> points) {
        int result = 0;
        for (Point p : points) {
            if (p.x() == x && p.y() == y)
                continue;
            Point expected1 = new Point(x, p.y());
            Point expected2 = new Point(p.x(), y);

            result += pointCounts.getOrDefault(p, 0) * pointCounts.getOrDefault(expected1, 0)
                * pointCounts.getOrDefault(expected2, 0);
        }
        return result;
    }
}

record Point(int x, int y) {}

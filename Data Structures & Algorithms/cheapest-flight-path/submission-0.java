class Solution {
    private final static int[][] DIRECTIONS = new int[][] {
        {0, 1}, // top
        {1, 0}, // right
        {0, -1}, // bottom
        {-1, 0} // left
    };

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Set<Flight>> flightsGraph = prepareGraph(flights);
        Set<State> visited = new HashSet<>();
        Queue<Path> queue = new PriorityQueue<>(Comparator.comparing(p -> p.price()));
        queue.add(new Path(new State(src, 0), 0));

        while (!queue.isEmpty()) {
            Path current = queue.poll();
            int airport = current.state().airport();
            int stops = current.state().stops();

            if (visited.contains(current.state()))
                continue;
            if (airport == dst)
                return current.price();
            visited.add(current.state());
            if (!flightsGraph.containsKey(airport) || stops > k)
                continue;

            for (Flight neighbour : flightsGraph.get(airport)) {
                State newState = new State(neighbour.to(), stops + 1);
                if (visited.contains(newState))
                    continue;

                queue.add(new Path(newState, current.price() + neighbour.price()));
            }
        }
        return -1;
    }

    private Map<Integer, Set<Flight>> prepareGraph(int[][] flights) {
        Map<Integer, Set<Flight>> result = new HashMap<>();
        for (int[] flight : flights) {
            result.computeIfAbsent(flight[0], v -> new HashSet<>())
                .add(new Flight(flight[1], flight[2]));
        }
        return result;
    }
}

record State(int airport, int stops) {}

record Path(State state, int price) {}

record Flight(int to, int price) {}

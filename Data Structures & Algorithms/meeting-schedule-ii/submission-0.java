/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
     Collections.sort(intervals, Comparator.comparing(i -> i.start));
        Queue<Interval> queue = new PriorityQueue<>(Comparator.comparing(a -> a.end));
        int maxRooms = 0;
        for (var interval : intervals) {
            while (!queue.isEmpty() && queue.peek().end <= interval.start) {
                queue.poll();
            }
            queue.add(interval);
            maxRooms = Math.max(maxRooms, queue.size());
        }
        return maxRooms;
    }
}

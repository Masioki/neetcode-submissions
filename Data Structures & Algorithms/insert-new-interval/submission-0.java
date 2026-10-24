class Solution {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) {
      return new int[][] {newInterval};
    }

    List<int[]> result = new ArrayList<>(intervals.length + 1);
    int indexBefore = bsIndexBefore(intervals, newInterval);
    for (int[] i : intervals) {
      result.add(i);
    }
    result.add(indexBefore + 1, newInterval);
    result = mergeFrom(result, indexBefore);
    return result.toArray(new int[0][0]);
  }

  private int bsIndexBefore(int[][] intervals, int[] newInterval) {
    if (intervals[intervals.length - 1][0] <= newInterval[0]) {
      return intervals.length - 1;
    }
    int start = 0;
    int end = intervals.length - 1;
    while (start < end) {
      int mid = (int) Math.ceil(start + (double) (end - start) / 2);
      if (intervals[mid][0] > newInterval[0]) {
        end = mid - 1;
      } else {
        start = mid;
      }
    }
    if (intervals[start][0] <= newInterval[0]) {
      return start;
    }
    return -1;
  }

  private List<int[]> mergeFrom(List<int[]> intervals, int index) {
    index = Math.max(index, 0);
    int startingIndex = index;
    boolean merged = true;
    while ((merged || index == startingIndex+1)&& index < intervals.size() - 1) {
      if (overlap(intervals.get(index), intervals.get(index + 1))) {
        intervals.get(index)[1] = Math.max(intervals.get(index)[1], intervals.get(index + 1)[1]);
        intervals.remove(index + 1);
      } else {
        merged = false;
        index++;
      }
    }
    return intervals;
  }

  private boolean overlap(int[] i1, int[] i2) {
    return i1[1] >= i2[0];
  }

}
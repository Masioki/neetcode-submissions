class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(i -> i[1]));

        int result = 0;
        int prevEnd = Integer.MIN_VALUE;
        for(int[] interval : intervals){
            if(interval[0] >= prevEnd){
                prevEnd = interval[1];
            } else {
                result++;
            }
        }
        return result;
    }
}

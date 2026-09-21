class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < intervals.length - 1; i++){
            if(overlap(intervals[i], intervals[i+1])){
                merge(intervals[i], intervals[i+1]);
            }
        }
        List<int[]> merged = new ArrayList<>();
        for(int[] interval : intervals){
            if(interval[0] >= 0){
                merged.add(interval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private boolean overlap(int[] int1, int[] int2){
        return int1[1] >= int2[0];
    }

    private void merge(int[] int1, int[] int2){
        int2[0] = Math.min(int2[0], int1[0]);
        int2[1] = Math.max(int2[1], int1[1]);
        int1[0] = -1;
        int1[1] = -1;
    }
}

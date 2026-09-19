class Solution {
   public int maxArea(int[] heights) {
    int lowerIdx = 0;
    int upperIdx = heights.length - 1;
    int maxArea = 0;
    while (lowerIdx < upperIdx) {
      int heightDiff = heights[lowerIdx] - heights[upperIdx];
      int area = Math.min(heights[lowerIdx], heights[upperIdx]) * (upperIdx - lowerIdx);
      if (area > maxArea) {
        maxArea = area;
      }
      if (heightDiff == 0) {
        lowerIdx++;
        upperIdx--;
      } else if (heightDiff < 0) {
        lowerIdx++;
      } else {
        upperIdx--;
      }
    }
    return maxArea;
  }
}

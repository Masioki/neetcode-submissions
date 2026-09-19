class Solution {
   public int[] twoSum(int[] numbers, int target) {
    int smallerIdx = 0;
    int largerIdx = numbers.length - 1;
    int smallerValue = numbers[0];
    int largerValue = numbers[numbers.length - 1];

    while (smallerValue + largerValue != target) {
      if (smallerValue + largerValue < target) {
        smallerIdx++;
        smallerValue = numbers[smallerIdx];
      } else {
        largerIdx--;
        largerValue = numbers[largerIdx];
      }
    }
    return new int[] {smallerIdx + 1, largerIdx + 1};
  }
}

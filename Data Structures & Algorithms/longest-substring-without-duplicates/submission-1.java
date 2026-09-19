class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() < 2) {
      return s.length();
    }

    int[] indexes = new int[128];

    int currentStart = 0;
    int length = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      int cIdx = indexes[c];
//      System.out.println("cidx " + cIdx + " char " + c);
//      System.out.println(Arrays.toString(indexes));
      if (cIdx > 0) {
        for (int j = currentStart; j < cIdx; j++) {
          indexes[chars[j]] = 0;
        }
        indexes[c] = i + 1;
        currentStart = cIdx;
//        System.out.println(currentStart);
      } else {
        indexes[c] = i + 1;
        length = Math.max(length, i - currentStart + 1);
      }
    }
    return length;
  }
}

class Solution {
   public String minWindow(String s, String t) {
    if (s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
      return "";
    }
    int[] counts = new int[52];
    Set<Character> validChars = new HashSet<>();
    for (var c : t.toCharArray()) {
      validChars.add(c);
      counts[getIndex(c)]++;
    }
    Set<Character> missingChars = new HashSet<>(validChars);
    int resultLength = 0;
    int resultStartIdx = 0;
    int left = 0;
    int right = -1;

    while (right < s.length()) {
      if (missingChars.isEmpty()) {
        // valid subsequence
        int length = right - left + 1;
        if (length < resultLength || resultLength == 0) {
          resultLength = length;
          resultStartIdx = left;
        }
        char leftChar = s.charAt(left);
        int leftCharIdx = getIndex(leftChar);
        if (validChars.contains(leftChar)) {
          counts[leftCharIdx]++;
          if (counts[leftCharIdx] == 1) {
            missingChars.add(leftChar);
          }
        }
        left++;
      } else {
        // invalid - extend
        right++;
        // newly met char
        if (right < s.length()) {
          char c = s.charAt(right);
          int countIdx = getIndex(c);
          counts[countIdx]--;
          if (counts[countIdx] == 0) {
            missingChars.remove(c);
          }
        }
      }
    }

    return s.substring(resultStartIdx, resultStartIdx + resultLength);
  }

  private int getIndex(char c){
    if(Character.isUpperCase(c)){
      return c - 'A';
    } else {
      return c - 'a' + 26;
    }
  }
}

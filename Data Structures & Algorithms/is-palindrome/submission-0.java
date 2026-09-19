class Solution {
  public boolean isPalindrome(String s) {
    int lowerIndex = 0;
    int upperIndex = s.length() - 1;
    
    while (lowerIndex < upperIndex) {
      char lowerChar = s.charAt(lowerIndex);
      while(!charValid(lowerChar) && lowerIndex < upperIndex) {
        lowerIndex++;
        lowerChar = s.charAt(lowerIndex);
      }
      
      char upperChar = s.charAt(upperIndex);
      while(!charValid(upperChar) && upperIndex > lowerIndex) {
        upperIndex--;
        upperChar = s.charAt(upperIndex);
      }
      
      if (normalize(lowerChar) != normalize(upperChar)) {
        return false;
      }
      lowerIndex++;
      upperIndex--;
    }
    return true;
  }
  
  private boolean charValid(char c){
    c = normalize(c);
    return (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
  }
  
  private char normalize(char c) {
    return (c >= 'a' && c <= 'z') ? (char) (c - 'a' + 'A') : c;
  }
}

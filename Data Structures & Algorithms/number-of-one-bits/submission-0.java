class Solution {
  public int hammingWeight(int n) {
    int result = 0;
    for(int i = 0; i < 32; i++){
      if((1 << i) == (n & (1 << i))){
        result++;
      }
    }
    return result;
  }
}

class Solution {
     public int[] productExceptSelf(int[] nums) {
    int zeros = 0;
    int product = 1;
    for (int num : nums) {
      if (num == 0) {
        zeros++;
      } else {
        product *= num;
      }
    }
    if (zeros > 1) {
      return new int[nums.length];
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        result[i] = product;
      } else {
        if (zeros == 1) {
          result[i] = 0;
        } else {
          result[i] = product / nums[i];
        }
      }
    }
    return result;
  }
}  

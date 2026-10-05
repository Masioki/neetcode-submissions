class Solution {
     public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];
        prefixProduct[0] = nums[0];
        suffixProduct[nums.length -1] = nums[nums.length-1];

        for(int i = 1; i <nums.length; i++){
          prefixProduct[i] = prefixProduct[i-1]*nums[i];
          suffixProduct[nums.length - 1 -i] = suffixProduct[nums.length -i] * nums[nums.length - 1 -i];
        }

        int[] result = new int[nums.length];
        for(int i = 0; i <result.length; i++){
          int product = 1;
          if(i >= 1){
            product *= prefixProduct[i-1];
          }
          if(i < nums.length - 1){
            product *= suffixProduct[i+1];
          }
          result[i] = product;
        }
        return result;
  }
}  

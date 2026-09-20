class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        boolean carry = false;
        do {
            int newValue = digits[i]+1;
            digits[i] = newValue % 10;
            carry = newValue >= 10;
            i--;
        } while(carry && i >= 0);
        if(carry){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for(int j = 0; j < digits.length; j++){
                newDigits[j+1] = digits[j];
            }
            digits = newDigits;
        }
        return digits;
    }
}

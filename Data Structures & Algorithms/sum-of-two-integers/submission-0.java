class Solution {
    public int getSum(int a, int b) {
        // 0 1 0 1 0
        // 0 0 1 1 1
        // XOR - 0 1 1 0 1
        // AND - 0 0 0 1 0
        // OR  - 0 1 1 1 1

        int result = a ^ b;
        int and = a & b;
        int carry = 0;
        for(int bit=0; bit < 32; bit++){
            if (carry > 0){
                if(!isOne(result, bit)){
                    carry--;
                }
                result = reverse(result, bit);
            }
            if (isOne(and, bit)){
                carry++;
            } 
        }
        return result;
    }

    private boolean isOne(int num, int bit) {
        return (num & (1 << bit)) != 0;
    }

    private int reverse(int num, int bit){
        return num ^ (1 << bit);
    }
}

class Solution {
    public int numDecodings(String s) {
        if(s == null || s.isEmpty() || s.charAt(0) == '0'){
            return 0;
        }
        int[] cache = new int[s.length() + 1];
        cache[s.length()] = 1;
        if(s.charAt(s.length() - 1) == '0'){
            cache[s.length() - 1] = 0;
        } else {
            cache[s.length() - 1 ] = 1;
        }

        for(int i = s.length() - 2; i>=0; i--){
            char current = s.charAt(i);
            char next = s.charAt(i + 1);
            int result = 0;
            if(current == '0'){
                cache[i] = 0;
            } else if(current == '1' || (current == '2' && next <= '6')){
                cache[i] = cache[i + 1] + cache[i + 2]; // ... 2 2 1
            } else {
                cache[i] = cache[i + 1]; // ... 3 0
            }
        }
        return cache[0];
    }
}

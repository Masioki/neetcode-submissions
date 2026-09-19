class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return "";
        }

        String result = "";
        int length = 0;
        int center = 0;
        for(int i =0; i < s.length()*2; i++){
            int currentLength = 0;
            if(i % 2 == 1){
                int index = i / 2;
                for(int j = 0; index - j >= 0 && j + index +1< s.length(); j++){
                    if(s.charAt(index-j) == s.charAt(j + index + 1)){
                        currentLength+=2;
                    } else {
                        break;
                    }
                }
            } else {
                currentLength++;
                int index = i / 2;
                for(int j = 1; index - j >= 0 && j + index < s.length(); j++){
                    if(s.charAt(index-j) == s.charAt(j + index)){
                        currentLength+=2;
                    } else {
                        break;
                    }
                }
            }
            if(currentLength > length) {
                length = currentLength;
                center = i;
            }
        }
        
    int startIndex = center / 2 - length / 2;
    if(length %2 == 0){
      startIndex++;
    }
    return s.substring(startIndex, startIndex + length);
    }
}

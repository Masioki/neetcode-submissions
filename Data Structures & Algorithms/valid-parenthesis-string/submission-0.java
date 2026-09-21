class Solution {
  public boolean checkValidString(String s) {
        int maxOpen = 0;
        int minOpen = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                maxOpen++;
                minOpen++;
            } else if(c == ')'){
                maxOpen--;
                minOpen--;
            } else  {
                maxOpen++;
                minOpen--;
            } 

            if(minOpen < 0){
                minOpen = 0;
            }

            if(maxOpen < 0){
                return false;
            }

        }

        return minOpen == 0;
    }
}

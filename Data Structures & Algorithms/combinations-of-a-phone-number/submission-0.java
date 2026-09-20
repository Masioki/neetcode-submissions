class Solution {
    public List<String> letterCombinations(String digits) {
        int[] lettersOffset = new int[] {0, 3, 6, 9, 12, 15, 19, 22};
        return step(digits, lettersOffset);
    }

    public List<String> step(String digits, int[] lettersOffset) {
        if(digits == null || digits.isEmpty()) {
            return List.of();
        }
        int index =  digits.charAt(0) - 2 - '0';
        List<String> results = new ArrayList<>();
        var strings = step(digits.substring(1), lettersOffset);
        int letterMaxOffset = lettersOffset.length - 1 > index ? lettersOffset[index+1] : 26;
        for(int i = lettersOffset[index]; i < letterMaxOffset; i++){
            char c = (char) ('a' +  i);
            if(strings.isEmpty()){
                results.add(c + "");
            } else {
                for(var s : strings){
                    results.add(c + s);
                }
            }
        }
        return results;
    }
}

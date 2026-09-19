class Solution {
    public boolean isValid(String s) {
        Set<Character> open = Set.of('(', '{', '[');
        Map<Character, Character> closeToOpenMap = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );
        Stack<Character> bracketQueue = new Stack<>();

        for(char c : s.toCharArray()) {
            if(open.contains(c)){
                bracketQueue.push(c);
            } else {
                if(bracketQueue.isEmpty()){
                    return false;
                }
                char latest = bracketQueue.pop();
                if(latest != closeToOpenMap.get(c)){
                    return false;
                }
            }
        }

        return bracketQueue.isEmpty();
    }
}

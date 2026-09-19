class Solution {
    private final String ADD = "+";
    private final String SUB = "-";
    private final String MUL = "*";
    private final String DIV = "/";
    private final Set<String> OPERANDS = Set.of(ADD, SUB, MUL, DIV);
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0){
            return 0;
        }
        Stack<String> equation = new Stack<>();
        for(var t : tokens){
            if(OPERANDS.contains(t)){
                String operand = t;
                int right = Integer.parseInt(equation.pop());
                int left = Integer.parseInt(equation.pop());
                int result = 0;
                if(ADD.equals(operand)){
                    result = left + right;
                }
                if(SUB.equals(operand)){
                    result = left - right;
                }
                if(MUL.equals(operand)){
                    result = left * right;
                }
                if(DIV.equals(operand)){
                    result = left / right;
                }
                equation.push(Integer.toString(result));
            } else {
                equation.push(t);
            }
        }
        return Integer.parseInt(equation.pop());
    }
}

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
        List<String> equation = new ArrayList<>();
        for(var s : tokens){
            equation.add(s);
        }
        int idx = 0;
        while(idx < equation.size()-1){
            // iter to first operand
            while(!OPERANDS.contains(equation.get(idx))){
                idx++;
            }
            String operand = equation.get(idx);
            int left = Integer.parseInt(equation.get(idx - 2));
            int right = Integer.parseInt(equation.get(idx - 1));
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
            equation.set(idx - 2, String.valueOf(result));
            equation.remove(idx - 1);
            equation.remove(idx - 1);
            idx = idx - 2;
        }
        return Integer.parseInt(equation.get(0));
    }
}

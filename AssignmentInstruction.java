public class AssignmentInstruction extends Instruction {
    private String varName;
    private String expression;

    public AssignmentInstruction(String varName, String expression) {
        this.varName = varName;
        this.expression = expression;
    }

    @Override
    public void exec() {
        int result = evaluateExpression(expression);
        Memory.variables.put(varName, result);
    }

    private int evaluateExpression(String expr) {
        expr = expr.trim();
        
        
        if (expr.matches("-?\\d+")) {
            return Integer.parseInt(expr);
        }
        
        
        if (!expr.contains(" ") && Memory.variables.containsKey(expr)) {
            return Memory.variables.get(expr);
        }

        String[] tokens = expr.split("\\s+");
        if (tokens.length == 3) {
            int val1 = getValue(tokens[0]);
            String operator = tokens[1];
            int val2 = getValue(tokens[2]);

            switch (operator) {
                case "+": return val1 + val2;
                case "-": return val1 - val2;
                case "*": return val1 * val2;
                case "/": return val1 / val2;
                default: throw new IllegalArgumentException("Operator i panjohur: " + operator);
            }
        }
        throw new IllegalArgumentException("Nuk mund te llogaritet: " + expr);
    }

    
    private int getValue(String token) {
        if (token.matches("-?\\d+")) {
            return Integer.parseInt(token);
        }
        if (Memory.variables.containsKey(token)) {
            return Memory.variables.get(token);
        }
        throw new IllegalArgumentException("Variabli nuk ekziston: " + token);
    }
}

package Lab12;

public class RecursiveParser {

    private String expression;
    private int index;

    public RecursiveParser(String expression) {
        this.expression = expression.replaceAll("\\s+", ""); // Remove whitespace
        this.index = 0;
    }

    public double evaluate() throws Exception {
        return parseExpression();
    }

    private double parseExpression() throws Exception {
        double value = parseTerm();
        while (index < expression.length() && (expression.charAt(index) == '+' || expression.charAt(index) == '-')) {
            char operator = expression.charAt(index++);
            double nextTerm = parseTerm();
            value = applyOperator(value, nextTerm, operator);
        }
        return value;
    }

    private double parseTerm() throws Exception {
        double value = parseFactor();
        while (index < expression.length() && (expression.charAt(index) == '*' || expression.charAt(index) == '/')) {
            char operator = expression.charAt(index++);
            double nextFactor = parseFactor();
            value = applyOperator(value, nextFactor, operator);
        }
        return value;
    }

    private double parseFactor() throws Exception {
        if (index < expression.length() && expression.charAt(index) == '(') {
            index++; // Skip '('
            double value = parseExpression();
            if (index >= expression.length() || expression.charAt(index) != ')') {
                throw new IllegalArgumentException("Mismatched parentheses.");
            }
            index++; // Skip ')'
            return value;
        } else {
            return parseNumber();
        }
    }

    private double parseNumber() throws Exception {
        int startIndex = index;
        boolean hasDecimal = false;

        while (index < expression.length() &&
              (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
            if (expression.charAt(index) == '.') {
                if (hasDecimal) {
                    throw new IllegalArgumentException("Invalid number format.");
                }
                hasDecimal = true;
            }
            index++;
        }

        if (startIndex == index) {
            throw new IllegalArgumentException("Expected a number at position " + startIndex);
        }

        String numberStr = expression.substring(startIndex, index);
        return Double.parseDouble(numberStr);
    }

    private double applyOperator(double left, double right, char operator) throws Exception {
        switch (operator) {
            case '+': return left + right;
            case '-': return left - right;
            case '*': return left * right;
            case '/': 
                if (right == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return left / right;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
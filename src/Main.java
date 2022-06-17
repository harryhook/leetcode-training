import java.util.Stack;

public class Main {
    public static float evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Float> num = new Stack<Float>();
        Stack<Character> ops = new Stack<Character>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') {
                continue;
            }
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer buffer = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    buffer.append(tokens[i++]);
                }
                i--; //回退一位
                num.push(Float.parseFloat(buffer.toString()));
            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    num.push(caculate(ops.pop(), num.pop(), num.pop()));
                }
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    num.push(caculate(ops.pop(), num.pop(), num.pop()));
                }
                ops.push(tokens[i]);
            }
        }
        while (!ops.empty()) {
            num.push(caculate(ops.pop(), num.pop(), num.pop()));
        }
        return num.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static float caculate(char ops, float b, float a) {
        switch (ops) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Main.evaluate("2 + 3 * 4 + 5"));
        System.out.println(Main.evaluate("100 * 2 + 12"));
        System.out.println(Main.evaluate("100 * ( 2 + 12 )"));
        System.out.println(Main.evaluate("100 * ( 2 + 12 ) / 14"));
    }
}
import java.util.Stack;

class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                performOperation(tokens[i], stack);

            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();

    }

    private static void performOperation(String s, Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    int latest_val = stack.pop();
                    int earlier_val = stack.pop();
                    stack.push(earlier_val - latest_val);
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    try {
                        int val1 = stack.pop();
                        int val2 = stack.pop();
                        stack.push(val2 / val1);
                        break;
                    } catch (ArithmeticException e) {
                        System.out.println("Cannot divide a number by 0");
                    }

            }
        }
    }
}
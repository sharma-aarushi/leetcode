import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution22 {
    public List<String> generateParenthesis(int n) {
        Stack<Character> parentheses = new Stack<>();
        List<String> output = new ArrayList<>();
        backtrack(parentheses, n, 0, 0, output);
        return output;

    }

    private void backtrack(Stack<Character> parentheses, int n, int open, int close, List<String> output) {

        // base case: number of opening and closing ()=n
        if (open == n && close == n) {
            StringBuilder builder = new StringBuilder();
            for (char ch : parentheses) {
                builder.append(ch);
            }
            output.add(builder.reverse().toString());
            return;
        }
        if (open < n) {
            parentheses.push('(');
            backtrack(parentheses, n, open + 1, close, output);
            parentheses.pop();
        }
        if (close < open) {
            parentheses.push(')');
            backtrack(parentheses, n, open, close + 1, output);
            parentheses.pop();
        }
    }
}

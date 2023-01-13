import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Solution22 {
    // using backtracking and depth-first search
    public List<String> solution1(int n) {
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

    static class Node {
        String generatedSoFar;
        int numOpen;
        int numClose;

        Node(String generatedSoFar, int numOpen, int numClose) {
            this.generatedSoFar = generatedSoFar;
            this.numOpen = numOpen;
            this.numClose = numClose;
        }

    }

    // using level order traversal
    public List<String> solution2(int n) {
        Queue<Node> queue = new LinkedList<>();
        List<String> output = new ArrayList<>();
        Node root = new Node("(", 1, 0);
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.numOpen == n && node.numClose == n) {
                output.add(node.generatedSoFar);
                continue;// no more children left to add
            }
            if (node.numOpen < n) {
                Node left = new Node(node.generatedSoFar + "(", node.numOpen + 1, node.numClose);
                queue.add(left);
            }
            if (node.numClose < node.numOpen) {
                Node right = new Node(node.generatedSoFar + ")", node.numOpen, node.numClose + 1);
                queue.add(right);
            }

        }

        return output;

    }

    public List<String> generateParenthesis(int n) {
        return solution2(n);
    }
}
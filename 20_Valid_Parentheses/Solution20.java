import java.util.*;

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '(' || ch != '{' || ch != '[' || ch != ')' || ch != '}' || ch != ']') {
                return false;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                open.push(ch);
            } else if (ch == ')' && open.pop() != '(') {
                return false;

            } else if (ch == '}' && open.pop() != '{') {
                return false;
            } else if (ch == ']' && open.pop() != '[') {
                return false;
            }

        }
        return true;
    }
}

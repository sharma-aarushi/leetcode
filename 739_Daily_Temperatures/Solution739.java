import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.lemgth];
        // 1. creating a monotonically decreasing stack
        Stack<Pair> stack = new Stack<>();
        // 2. iterate over temps and compare against each value in stack
        for (int i = 0; i < temperatures.length; i++) {
            // 3. remove all values less than current value from stack
            while (!stack.isEmpty() && temperatures[i] > stack.peek().temp) {
                Pair popped = stack.pop();
                // 4. update the output for each of the removed values
                output[i] = i - popped.index;
            }
            Pair pair = new Pair(temperatures[i], i);
            stack.push(pair);
        }
        while (!stack.isEmpty()) {
            output[stack.pop().index] = 0;
        }
        return output;
    }

    private static class Pair {
        int temp;
        int index;

        Pair(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }
    }
}

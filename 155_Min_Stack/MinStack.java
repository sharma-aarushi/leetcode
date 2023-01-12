import java.util.ArrayList;

class MinStack {
    private ArrayList<Integer> minStack;
    private ArrayList<Integer> minimum = new ArrayList<>();
    // private int minSoFar;

    public MinStack() {
        this.minStack = new ArrayList<>();
    }

    public void push(int val) {
        this.minStack.add(val);
        if (!minimum.isEmpty()) {
            if (val < this.minimum.get(minimum.size() - 1)) {
                this.minimum.add(val);
            } else {
                this.minimum.add(this.minimum.get(minimum.size() - 1));
            }
        } else {
            this.minimum.add(val);
        }
        System.out.println("Push: minimum" + this.minimum);
        System.out.println("Push: minStack" + this.minStack);

    }

    public void pop() {

        this.minimum.remove(minimum.size() - 1);
        this.minStack.remove(minStack.size() - 1);// removing last element
    }

    public int top() {
        int lastIndex = this.minStack.size() - 1;
        if (!minStack.isEmpty()) {
            return minStack.get(lastIndex);
        } else {
            return -1;
        }
    }

    public int getMin() {
        return this.minimum.get(this.minimum.size() - 1);
    }

    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(-2);
        test.push(0);
        test.push(-3);

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        return linearSolution(nums);
    }

    // Time Complexity: O(n^2)
    public int[] bruteForce(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i)
                    product *= nums[j];
            }
            output[i] = product;
        }
        return output;
    }

    private int[] linearSolution(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }
        int[] op = new int[nums.length];
        op[0] = postfix[1];
        op[nums.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            op[i] = prefix[i - 1] * postfix[i + 1];
        }
        return op;
    }
}
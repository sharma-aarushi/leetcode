class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // return bruteForce(nums,target);
        return solution2(nums, target);
    }

    // time complexity: O(n^2)
    private int[] bruteForce(int[] nums, int target) {
        int[] sol = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    sol[0] = i;
                    sol[1] = j;
                }
            }
        }
        return sol;
    }

    private int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> pair = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (pair.containsKey(diff)) {
                return new int[] { pair.get(diff), i };
            }
            pair.put(num, i);
        }
        return null;// will never be reached because of problem statement

    }
}
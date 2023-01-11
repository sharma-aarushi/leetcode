import java.util.Arrays;
import java.util.HashSet;

class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        return solution3(nums);
    }

    // time complexity: O(n^2)
    private boolean bruteForce(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // time complexity: O(nlg(n))
    private boolean solution2(int[] nums) {
        Arrays.sort(nums);// sorting array
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // time complexoty: O(n)
    public boolean solution3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        return linearSol(nums);
    }

    public int solution1(int[] nums) {
        Arrays.sort(nums);// sorting the array
        if (nums.length == 0) {
            return 0;
        }
        int maxLength = 0;
        int currLength = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                currLength++;
            } else if (nums[i + 1] == nums[i]) {
                continue;
            } else {
                maxLength = Math.max(maxLength, currLength);
                currLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currLength);
        return maxLength;

    }

    public int linearSol(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        // inserting all array values into hashset
        for (int num : nums) {
            numSet.add(num);
        }
        int maxLen = 0;// what if empry array?
        for (int num : nums) {
            // number not start of the sequence
            if (numSet.contains(num - 1)) {
                continue;
            }
            int seqLen = 1, curr = num;
            while (numSet.contains(curr + 1)) {
                seqLen++;
                curr++;
            }
            maxLen = Math.max(seqLen, maxLen);
        }
        return maxLen;
    }
}
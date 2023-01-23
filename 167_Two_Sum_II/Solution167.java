public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        return twoPointerApproach(numbers, target);
    }

    // two pointer approach
    private int[] twoPointerApproach(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };// array is 1-indexed
            }
            if (sum < target) {
                left++;
                continue;
            }
            right--;
        }
        return null;// will never reach here because solution exists and is found inside the loop
    }
}

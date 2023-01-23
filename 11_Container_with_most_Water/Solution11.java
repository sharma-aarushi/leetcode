@SuppressWarnings ("unused")
public class Solution11 {
    public int maxArea(int[] height) {
        return twoPointerSolution(height);

    }

    // time complexity: O(n^2)
    // space complexity: O(1)
    private int bruteForce(int[] height) {
        int maxSoFar = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                int area = (i - j) * Math.min(height[i], height[j]);
                if (area > maxSoFar) {
                    maxSoFar = area;
                }
            }
        }
        return maxSoFar;
    }

    // time complexity: O(n)
    // space complexity: O(1)
    private int twoPointerSolution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxSoFar = 0;
        while (left < right) {
            int area = (Math.min(height[left], height[right]) * (right - left));
            if (area > maxSoFar) {
                maxSoFar = area;
            }
            if (height[left] > height[right]) {
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return maxSoFar;
    }
}

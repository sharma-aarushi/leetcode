import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    // Time complexity: O(nlogn)
    public int[] topKFrequent(int[] nums, int k) {
        return linearSolution(nums, k);
    }

    public int[] solution1(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<Entry<Integer, Integer>> entries = new ArrayList<>(frequency.entrySet());
        Collections.sort(entries, new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> entry1, Entry<Integer, Integer> entry2) {
                return -(entry1.getValue() - entry2.getValue());
            }
        });
        int[] output = new int[k];
        for (int i = 0; i < output.length; i++) {
            output[i] = entries.get(i).getKey();
        }
        return output;
    }

    // Time Complexity: O(n+klogn)=>O(n) only if k is smaller than n/log(n) using
    // max heap
    // TO DO
    // public int[] heapSolution(int[] nums, int k){
    // }
    // Time Complexity: O(n)
    public int[] linearSolution(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> reverseCount = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            reverseCount.add(null);// initializing the arraylist
        }
        // building count array
        for (Integer key : frequency.keySet()) {
            int count = frequency.get(key);// key is the number itself
            if (reverseCount.get(count) != null) {
                reverseCount.get(count).add(key);// adding to the end of the sublist within the arraylist
            } else {
                List<Integer> sublist = new ArrayList<>();
                sublist.add(key);
                reverseCount.set(count, sublist);
            }
        }
        // returning the top K elements
        int[] output = new int[k];
        int kCounter = 0;
        for (int i = reverseCount.size() - 1; i >= 0; i--) {
            if (reverseCount.get(i) == null) {
                continue;
            }
            List<Integer> countList = reverseCount.get(i);
            for (int number : countList) {
                output[kCounter++] = number;
                if (kCounter == k) {
                    return output;
                }
            }
        }
        return null;
    }
}
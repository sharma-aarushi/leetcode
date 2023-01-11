import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        return solution1(s, t);
    }

    // using hash map
    // time complexity: O(n)
    private boolean solution1(String s, String t) {
        HashMap<Character, Integer> scounts = getCharacterCounts(s);
        HashMap<Character, Integer> tcounts = getCharacterCounts(t);
        return scounts.equals(tcounts);
    }

    private HashMap<Character, Integer> getCharacterCounts(String s) {
        HashMap<Character, Integer> scounts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (scounts.containsKey(ch)) {
                scounts.put(ch, scounts.get(ch) + 1);
            } else {
                scounts.put(ch, 1);
            }
        }
        return scounts;
    }
}
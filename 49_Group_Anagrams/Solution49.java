class Solution49 {
    // Time complexity: O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            if (anagramMap.containsKey(key)) {
                List<String> anagramList = anagramMap.get(key);
                anagramList.add(str);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                anagramMap.put(key, newList);
            }
        }
        List<List<String>> output = new ArrayList<>();
        for (String key : anagramMap.keySet()) {
            output.add(anagramMap.get(key));
        }
        return output;
    }

    private String getKey(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}

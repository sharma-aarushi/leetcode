    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private boolean solution2(String s) {
        s = s.toLowerCase(); // O(n)-time O(n)-space

        StringBuilder newS = new StringBuilder(); // O(n)-space
        for (int i = 0; i < s.length(); i++) {// O(n)-time
            // filtering out non-alphanumerics
            if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)
                    || (s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                newS.append(s.charAt(i));
            }
        }
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < newS.length() / 2; i++) {// O(n)
            if (newS.charAt(i) != newS.charAt(newS.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }

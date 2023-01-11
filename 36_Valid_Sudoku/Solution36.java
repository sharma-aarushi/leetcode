class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> valuesSoFar = new HashSet<>();
        // iterating row by row
        for (int r = 0; r < 9; r++) {
            valuesSoFar.clear();// resetting the hashset
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }
                int val = ch - '0';
                if (valuesSoFar.contains(val)) {
                    return false;
                }
                if (val < 1 || val > 9) {
                    return false;
                }
                valuesSoFar.add(val);
            }
        }
        // iterating column by column
        for (int c = 0; c < 9; c++) {
            valuesSoFar.clear();// resetting the hashset
            for (int r = 0; r < 9; r++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }
                int val = ch - '0';
                if (valuesSoFar.contains(val)) {
                    return false;
                }
                if (val < 1 || val > 9) {
                    return false;
                }
                valuesSoFar.add(val);
            }
        }
        int numRows, numCols = 9;
        for (int subRow = 0; subRow < 3; subRow++) {
            for (int subCol = 0; subCol < 3; subCol++) {
                valuesSoFar.clear();
                for (int r = 3 * subRow; r < 3 * subRow + 3; r++) {
                    for (int c = 3 * subCol; c < 3 + 3 * subCol; c++) {

                        char ch = board[r][c];
                        if (ch == '.') {
                            continue;
                        }
                        int val = ch - '0';
                        if (valuesSoFar.contains(val)) {
                            return false;
                        }
                        if (val < 1 || val > 9) {
                            return false;
                        }
                        valuesSoFar.add(val);
                    }
                }
            }
        }

        return true;

    }
}
class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // suffix[j] stores the rightmost index in word1 that matches word2[j]
        int[] suffix = new int[m];
        int pos = n - 1;
        
        // 1. Precompute rightmost matches
        for (int j = m - 1; j >= 0; j--) {
            while (pos >= 0 && word1.charAt(pos) != word2.charAt(j)) {
                pos--;
            }
            if (pos < 0) {
                // FIXED: Using -1 ensures that suffix[j+1] > i will correctly 
                // evaluate to false if the remaining string cannot be matched.
                suffix[j] = -1; 
            } else {
                suffix[j] = pos;
                pos--;
            }
        }
        
        int[] ans = new int[m];
        int j = 0;
        boolean mismatched = false;
        
        // 2. Greedily find the earliest possible matches
        for (int i = 0; i < n && j < m; i++) {
            
            // Case A: Characters match naturally
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } 
            // Case B: Characters don't match, but we haven't used our mismatch yet
            else if (!mismatched) {
                // We can use a mismatch if we are at the last character OR 
                // the remaining substring of word2 can be perfectly matched after index i
                boolean remainingPossible = (j == m - 1) || (suffix[j + 1] > i);
                
                if (remainingPossible) {
                    ans[j] = i;
                    j++;
                    mismatched = true;
                }
            }
        }
        
        // If we successfully matched all m characters, return the answer array.
        // Otherwise, return an empty array indicating it's impossible.
        if (j != m) {
            return new int[0];
        }
        
        return ans;
    }
}
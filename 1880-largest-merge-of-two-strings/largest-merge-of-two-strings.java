
class Solution {
    public String largestMerge(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int i = 0, j = 0;

        StringBuilder sb = new StringBuilder(m + n);

        while (i < m && j < n) {

            int cmp = word1.substring(i).compareTo(word2.substring(j));

            if (cmp >= 0) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        }

        sb.append(word1.substring(i));
        sb.append(word2.substring(j));

        return sb.toString();
    }
}

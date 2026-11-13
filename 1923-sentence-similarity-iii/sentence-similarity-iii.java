
class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        String[] a = s1.split(" ");
        String[] b = s2.split(" ");

        if (a.length > b.length) {
            String[] temp = a;
            a = b;
            b = temp;
        }

        int i = 0;
        int j = a.length - 1;
        int k = b.length - 1;

        // Match prefix
        while (i < a.length && a[i].equals(b[i])) {
            i++;
        }

        // Match suffix
        while (j >= i && a[j].equals(b[k])) {
            j--;
            k--;
        }

        return j < i;
    }
}

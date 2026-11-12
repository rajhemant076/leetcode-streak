class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();

        long result = nextPermutation(arr);

        if (result == -1 || result > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) result;
    }

    public long nextPermutation(char[] arr) {
        int ind = -1;
        int n = arr.length;

        // Find pivot
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }

        // No greater permutation exists
        if (ind == -1) {
            return -1;
        }

        // Find successor and swap
        for (int i = n - 1; i > ind; i--) {
            if (arr[i] > arr[ind]) {
                char temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
                break;
            }
        }

        // Reverse suffix
        reverse(ind + 1, arr.length - 1, arr);

        return Long.parseLong(new String(arr));
    }

    public static void reverse(int s, int e, char[] arr) {
        while (s < e) {
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
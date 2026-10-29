
import java.util.*;

class Solution {

    static class Node {
        Node[] children = new Node[2];
    }

    Node root = new Node();

    public void insert(int num) {
        Node curr = root;

        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (curr.children[bit] == null) {
                curr.children[bit] = new Node();
            }

            curr = curr.children[bit];
        }
    }

    public int getMaxXor(int num) {
        Node curr = root;
        int xor = 0;

        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;

            if (curr.children[opposite] != null) {
                xor |= (1 << i);
                curr = curr.children[opposite];
            } else {
                curr = curr.children[bit];
            }
        }

        return xor;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int m = queries.length;
        int[][] offline = new int[m][3];

        for (int i = 0; i < m; i++) {
            offline[i][0] = queries[i][0]; // x
            offline[i][1] = queries[i][1]; // limit
            offline[i][2] = i;             // original index
        }

        Arrays.sort(offline, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int[] ans = new int[m];
        root = new Node();
        int j = 0;

        for (int[] query : offline) {
            int x = query[0];
            int limit = query[1];
            int index = query[2];

            while (j < nums.length && nums[j] <= limit) {
                insert(nums[j]);
                j++;
            }

            if (j == 0) {
                ans[index] = -1;
            } else {
                ans[index] = getMaxXor(x);
            }
        }

        return ans;
    }
}

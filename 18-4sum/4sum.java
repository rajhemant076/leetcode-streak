import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {   // ✅ fixed j = i + 1
                HashSet<Integer> h = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    // ✅ use long to prevent overflow
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = (long) target - sum;

                    // ✅ ensure the fourth value fits in int range before checking
                    if (fourth >= Integer.MIN_VALUE && fourth <= Integer.MAX_VALUE) {
                        if (h.contains((int) fourth)) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }

                    h.add(nums[k]);
                }
            }
        }

        return new ArrayList<>(set);
    }
}

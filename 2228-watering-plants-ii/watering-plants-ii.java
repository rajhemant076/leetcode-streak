class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {

        int n = plants.length;

        int a = capacityA;
        int b = capacityB;

        int left = 0;
        int right = n - 1;

        int count = 0;

        while (left < right) {

            // Alice
            if (plants[left] <= a) {
                a -= plants[left];
            }
            else {
                count++;
                a = capacityA - plants[left];
            }
            left++;

            // Bob
            if (plants[right] <= b) {
                b -= plants[right];
            }
            else {
                count++;
                b = capacityB - plants[right];
            }
            right--;
        }

        // Handle middle plant
        if (left == right) {

            if (a >= b) {
                if (plants[left] > a) {
                    count++;
                }
            }
            else {
                if (plants[left] > b) {
                    count++;
                }
            }
        }

        return count;
    }
}
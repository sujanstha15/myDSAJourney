import java.util.Arrays;

public class Day31 {

    // Main method that returns the maximum possible minimum distance
    public int aggressiveCows(int[] nums, int k) {
        // Step 1: Sort the stall positions
        Arrays.sort(nums);

        int low = 1; // Minimum possible distance between cows
        int high = nums[nums.length - 1] - nums[0]; // Maximum possible distance (between first and last stall)
        int ans = 0; // To store the best possible answer

        // Step 2: Binary search on the distance
        while (low <= high) {
            int mid = (low + high) / 2; // Try this as the minimum distance

            if (isPossible(nums, k, mid)) {
                // If it's possible to place all cows with at least 'mid' distance
                ans = mid; // Update the answer
                low = mid + 1; // Try for a bigger distance
            } else {
                // Not possible to place all cows with this distance
                high = mid - 1; // Try smaller distance
            }
        }

        return ans; // Return the largest minimum distance found
    }

    // Helper method to check if placing all cows with 'distance' is possible
    public static boolean isPossible(int[] stalls, int k, int distance) {
        int count = 1; // First cow is placed at the first stall
        int lastPosition = stalls[0]; // Keep track of the last placed cow's position

        for (int i = 1; i < stalls.length; i++) {
            // If current stall is at least 'distance' away from last cow
            if (stalls[i] - lastPosition >= distance) {
                count++; // Place another cow
                lastPosition = stalls[i]; // Update the position
            }
        }

        return count >= k; // Return true if we placed at least k cows
    }

    // Main function to test the code
    public static void main(String[] args) {
        int[] nums = {0, 3, 4, 7, 10, 9}; // Stall positions
        int k = 4; // Number of cows

        // We need to create an object to call the non-static method
        Day31 obj = new Day31();
        System.out.println(obj.aggressiveCows(nums, k)); // Output should be 3
    }
}

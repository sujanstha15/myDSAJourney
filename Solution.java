public class Solution {

    public double myPow(double x, int n) {
        long binaryForm = n;

        if (n < 0) {
            x = 1 / x;
            binaryForm = -binaryForm;
        }

        double ans = 1;

        while (binaryForm > 0) {
            if (binaryForm % 2 == 1) {
                ans *= x;
            }
            x *= x;
            binaryForm /= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        double result1 = sol.myPow(2.0, 10);
        System.out.println("2.0^10 = " + result1); // Expected: 1024.0

        double result2 = sol.myPow(2.0, -2);
        System.out.println("2.0^-2 = " + result2); // Expected: 0.25

        double result3 = sol.myPow(3.0, 0);
        System.out.println("3.0^0 = " + result3); // Expected: 1.0

        double result4 = sol.myPow(5.0, 3);
        System.out.println("5.0^3 = " + result4); // Expected: 125.0
    }
}

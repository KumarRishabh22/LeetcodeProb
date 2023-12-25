// class Solution {
//     public int solve(int i, String s, int n) {
//         if (i == n) {
//             return 1;
//         }

//         if (s.charAt(i) == '0') {
//             return 0;
//         }

//         int result = solve(i + 1, s, n);

//         if (i + 1 < n) {
//             char currentDigit = s.charAt(i);
//             char nextDigit = s.charAt(i + 1);

//             if (currentDigit == '1' || (currentDigit == '2' && nextDigit <= '6')) {
//                 result += solve(i + 2, s, n);
//             }
//         }

//         return result;
//     }

//     public int numDecodings(String s) {
//         int n = s.length();
//         return solve(0, s, n);
//     }
// }
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        // Initialize the DP array
        int[] dp = new int[n + 1];
        dp[n] = 1; // There is one way to decode an empty string

        // Fill in the DP array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Check for leading zero
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                // Decode single digit
                dp[i] += dp[i + 1];

                // Decode two digits if possible
                if (i + 1 < n && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}

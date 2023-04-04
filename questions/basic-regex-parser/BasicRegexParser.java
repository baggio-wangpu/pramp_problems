public class BasicRegexParser {

    /*
        same as https://leetcode.com/problems/regular-expression-matching/
        need to try another solution by DP.
     */
    // method2: use dp
    public static boolean isMatch(String text, String pattern) {
        int m = text.length(), n = pattern.length();
        boolean[][] dp = new boolean[m + 1][n + 1]; // dp[i][j]: text的前i个字符和pattern的前j个字符是否匹配

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (j == 0) {
                    dp[i][j] = false;
                } else {
                    if (pattern.charAt(j - 1) != '*') {
                        if (i > 0) dp[i][j] = (text.charAt(i - 1) == pattern.charAt(j - 1) ||
                                pattern.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                    } else { // '*'
                        if (i == 0) {
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2] || (text.charAt(i - 1) == pattern.charAt(j - 2) && dp[i - 1][j]) ||
                                    (pattern.charAt(j - 2) == '.' && dp[i - 1][j]);
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }

    /* method1: use recursion
    static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        // pattern has characters

        // "ab" "a*"
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            if (isMatch(text, pattern.substring(2))) { // *号匹配0次，如果成功，返回true；
                return true;
            } else { // 不成功则尝试匹配1-N次
                if (text.length() > 0 && (pattern.charAt(0) == '.'
                        || text.charAt(0) == pattern.charAt(0))) { // 相等或者等于. 继续匹配
                    return isMatch(text.substring(1), pattern);
                } else { // 不相等，也不等于"."，返回false
                    return false;
                }
            }
        } else { // second is not '*'
            if (text.length() > 0 && ((pattern.charAt(0) == '.'
                    || text.charAt(0) == pattern.charAt(0)))) {
                return isMatch(text.substring(1), pattern.substring(1));
            } else {
                return false;
            }
        }
    }
     */

    public static void main(String[] args) {

        // Expected output: false
        System.out.println(isMatch("aa", "a"));

        // Expected output: true
        System.out.println(isMatch("aa", "aa"));

        // Expected output: true
        System.out.println(isMatch("abc", "a.c"));

        // Expected output: true
        System.out.println(isMatch("abbb", "ab*"));

        // Expected output: true
        System.out.println(isMatch("acd", "ab*c."));

        // Expected output: false
        System.out.println(isMatch("ac", "abb*c"));

        // Expected output: true
        System.out.println(isMatch("abc", "abb*c"));

        // Expected output: true
        System.out.println(isMatch("ab", ".*"));

        // Expected output: false
        System.out.println(isMatch( "mississippi", "mis*is*p*."));
    }
}

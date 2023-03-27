public class BasicRegexParser {

    /*
        same as https://leetcode.com/problems/regular-expression-matching/
        need to try another solution by DP.
     */
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

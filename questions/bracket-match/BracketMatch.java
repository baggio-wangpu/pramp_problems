public class BracketMatch {

    /*
        same as https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
     */
    static int bracketMatch(String text) {
        int needRight = 0, res = 0;
        for (char c : text.toCharArray()) {
            if (c == '(') {
                needRight++;
            } else if (c == ')') {
                if (needRight > 0) needRight--;
                else res++;
            }
        }
        return res + needRight;
    }

    public static void main(String[] args) {
        String text = "(()";
        // Expected output: 1
        System.out.println(bracketMatch(text));

        text = "(())";
        // Expected output: 0
        System.out.println(bracketMatch(text));

        text = "())(";
        // Expected output: 2
        System.out.println(bracketMatch(text));
    }
}

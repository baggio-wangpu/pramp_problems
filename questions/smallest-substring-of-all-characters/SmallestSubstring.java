import java.util.HashMap;
import java.util.Map;

public class SmallestSubstring {

    /*
    input:  arr = ['x','y','z'], str = "xyyzyzyx"

    output: "zyx"
     */
    // sliding windows, same as https://leetcode.com/problems/minimum-window-substring/
    static String getShortestUniqueSubstring(char[] arr, String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int counter = map.size();
        int start = -1, minLen = Integer.MAX_VALUE;
        while(r < str.length()) {
            char curr = str.charAt(r);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) counter--;
            }

            while (counter == 0) { // satisfied, left pointer ++, find minLen
                int len = r - l + 1;
                if (len < minLen) {
                    start = l;
                    minLen = len;
                }

                char removed = str.charAt(l);
                if (map.containsKey(removed)) {
                    if (map.get(removed) == 0) counter++;
                    map.put(removed, map.get(removed) + 1);
                }
                l++;
            }
            r++;
        }
        return start == -1 ? "" : str.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        // case 1 : Expected output: "zyx"
        System.out.println(getShortestUniqueSubstring(new char[]{'x', 'y', 'z'}, "xyyzyzyx"));

        // case 2 : Expected output: "zyzyx"
        System.out.println(getShortestUniqueSubstring(new char[]{'z', 'z', 'x'}, "xyyzyzyx"));

        // case 3 : Expected output: "yyzy"
        System.out.println(getShortestUniqueSubstring(new char[]{'y', 'y', 'y'}, "xyyzyzyx"));

        // case 4 : Expected output: "BANC"
        System.out.println(getShortestUniqueSubstring(new char[]{'A', 'B', 'C'}, "ADOBECODEBANC"));

        // case 5 : Expected output: ""
        System.out.println(getShortestUniqueSubstring(new char[]{'x', 'z', 'z', 'z'}, "xyyzyzyx"));
    }
}

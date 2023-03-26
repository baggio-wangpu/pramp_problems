import java.util.ArrayList;
import java.util.List;

public class SentenceReverse {

    /*
    char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
    Expected output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ',
                          'm', 'a', 'k', 'e', 's', ' ',
                          'p', 'e', 'r', 'f', 'e', 'c', 't' ]
     */
    static char[] reverseWords(char[] arr) {

        // 1. split the sentences into words
        List<String> strs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c == ' ') {
                strs.add(sb.toString());
                sb = new StringBuilder();
            } else sb.append(c);
        }
        if (sb.length() > 0) strs.add(sb.toString());

        // 2. reverse the words in list
        int start = 0, end = strs.size() - 1;
        while (start < end) {
            String tmp = strs.get(end);
            strs.set(end, strs.get(start));
            strs.set(start, tmp);
            start++;
            end--;
        }

        // 3. add space and change into char[]
        String res = String.join(" ", strs);
        return res.toCharArray();
    }

    public static void main(String[] args) {
        // test case 1
        char[] arr = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        char[] result = reverseWords(arr);
        for (char c : result) {
            System.out.print("'" + c + "', ");
        }
        System.out.println();

        // test case 2
        arr = new char[]{'w', 'i', 'n', ' ', 't', 'o', ' ',
                'w', 'a', 'n', 't', ' ', 'y',
                'o', 'u', ' ', 'i', 'f'};
        result = reverseWords(arr);
        for (char c : result) {
            System.out.print("'" + c + "', ");
        }
        System.out.println();
    }
}

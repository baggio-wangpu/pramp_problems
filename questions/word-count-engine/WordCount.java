import java.util.*;

public class WordCount {

    /*
    input:  document = "Practice makes perfect. you'll only get Perfect by practice. just practice!"

    output: [ ["practice", "3"], ["perfect", "2"],
            ["makes", "1"], ["youll", "1"], ["only", "1"],
            ["get", "1"], ["by", "1"], ["just", "1"] ]
     */

    static String[][] wordCountEngine(String document) {
        String[] arrs = document.replaceAll("[,.:;'?!]", "").toLowerCase().split(" ");
        Map<String, Integer> map = new LinkedHashMap<>(); // string -> count (linkedHashMap can keep their order)

        for (String s : arrs) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String[][] res = new String[map.size()][2];
        int index = 0;
        for (String s : map.keySet()) {
            res[index][0] = s;
            res[index][1] = map.get(s).toString();
            index++;
        }

        // arrays.sort() is a stable sort, so can keep their order in the original sentence
        Arrays.sort(res, (a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
        return res;
    }

    /* method2. more complex than the method1
    static String[][] wordCountEngine(String document) {
        // your code goes here
        String[] words = document.replaceAll("[,.;'!?]", "").toLowerCase().split(" ");

        // String[] words = document.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
        TreeMap<Integer, List<String>> result = new TreeMap<>(Collections.reverseOrder()); // number -> string
        Map<String, Integer> content = new LinkedHashMap<>(); // string -> number

        for (String s : words) {
            content.put(s, content.getOrDefault(s, 0) + 1);
        }

        for (String s : content.keySet()) {
            result.putIfAbsent(content.get(s), new ArrayList<>());
            result.get(content.get(s)).add(s);
        }

        String[][] res = new String[content.size()][2];
        int index = 0;
        for (int num : result.keySet()) {
            for (int i = 0; i < result.get(num).size(); i++) {
                res[index][0] = result.get(num).get(i);
                res[index][1] = String.valueOf(num);
                index++;
            }
        }
        return res;
    }
     */

    public static void main(String[] args) {
        String document1 = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        String[][] res1 = wordCountEngine(document1);
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i][0] + ": " + res1[i][1] + " ");
        }
        System.out.println();

        String document2 = "To be, or not to be, that is the question.";
        String[][] res2 = wordCountEngine(document2);
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i][0] + ": " + res2[i][1] + " ");
        }
        System.out.println();

        String document3 = "Fear leads to anger; anger leads to hatred; hatred leads to conflict; conflict leads to suffering.";
        String[][] res3 = wordCountEngine(document3);
        for (int i = 0; i < res3.length; i++) {
            System.out.print(res3[i][0] + ": " + res3[i][1] + " ");
        }
        System.out.println();
    }
}
import java.util.*;

public class WordCount {

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

    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        String[][] res = wordCountEngine(document);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i][0] + ": " + res[i][1] + " ");
        }
        System.out.println();
    }
}
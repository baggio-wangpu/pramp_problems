public class DecryptMessage {

    /*
     Add 1 to the first letter, and then for every letter from the second one to the last one,
     add the value of the previous letter. Subtract 26 from every letter until it is in the range
     of lowercase letters a-z in ASCII.
     */
    static String decrypt(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int deASCII = word.charAt(i);
            if (i == 0) {
                deASCII -= 1;
            } else {
                deASCII -= word.charAt(i - 1);
            }

            while (deASCII > (int)'z' || deASCII < (int)'a') {
                deASCII += 26;
            }
            sb.append((char)deASCII);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String word = "dnotq";
        // Expected output: "crime"
        System.out.println(decrypt(word));

        word = "flgxswdliefy";
        // Expected output: "encyclopedia"
        System.out.println(decrypt(word));
    }
}

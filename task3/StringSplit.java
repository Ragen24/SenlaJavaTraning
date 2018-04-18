
public class StringSplit {
    public static String[] getWordArray(String str) {
        String[] words;
        words = str.split("[,;:.!?~()\\-\\[\\]{}<>\\\\/@\"\\s]+");
        return words;
    }

    public static void printWordArray(String[] arr) {
        for (String word : arr)
            System.out.print(word + " ");
    }
}

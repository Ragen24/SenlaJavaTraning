public class Main {
    public static void main(String[] args) {
        String text = "Программа позволяет получить текст в виде строки и вернуть массив слов.";
        String textWithSymbols = "test, test. test! test? test!?test?! test: test; test... (test) test-test-test-test [test] ~test - test @test test/test \"test\" test\\test {test} <test>";
        String[] words = StringSplit.getWordArray(text);
        StringSplit.printWordArray(words);
        System.out.println();
        String[] words2 = StringSplit.getWordArray(textWithSymbols);
        StringSplit.printWordArray(words2);
    }
}

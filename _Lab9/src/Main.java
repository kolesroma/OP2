import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String sentence = "The user with the nickname koala757677 " +
                "this month wrote 3 times more comments than " +
                "the user with the nickname croco181dile920 4 months ago";
        System.out.println(wordsToUpCase(sentence));
    }

    public static String wordsToUpCase(String sentence) {
        int i = 0;
        ArrayList<String> words = new ArrayList<>();
        for (char c : sentence.toCharArray()) {
            i++;
            if (i >= sentence.length()) {
                words.add(sentence);
            } else if (c == ' ') {
                words.add(sentence.substring(0, --i));
                sentence = sentence.substring(++i);
                i = 0;
            }
        }

        String sentenceOut = "";
        ArrayList<String> numbers = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            numbers.add(String.valueOf(j));
        }

        boolean flag = true;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                if (numbers.contains(String.valueOf(c))) {
                    flag = false;
                    break;
                }
            }
            sentenceOut += flag ? s.toUpperCase() + " " : s + " ";
            flag = true;
        }
        return sentenceOut.trim();
    }
}

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CommonestWord {
    private static ArrayList<String> getWordsList(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        ArrayList<String> words = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            Scanner scanner = new Scanner(line);
            while (scanner.hasNext())
                words.add(scanner.next());
            scanner.close();
        }
        br.close();
        return words;
    }

    public static String commonestWord(String fileName) throws IOException {
        ArrayList<String> wordsArray = getWordsList(fileName);
        TreeSet<String> wordsSet = new TreeSet(wordsArray);

        String commonestWord = "file is empty"; // default value if file read was empty
        int frequency = 0;

        for (String uniq : wordsSet) {
            int newFrequency = Collections.frequency(wordsArray, uniq);
            if (newFrequency > frequency) {
                frequency = newFrequency;
                commonestWord = uniq;
            }
        }
        return commonestWord;
    }
}

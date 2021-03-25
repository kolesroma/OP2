import java.io.FileInputStream;
import java.io.IOException;

public class NumberOfWords {
    public static long numberOfLatinCharacters(String filename) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            long latinCounter = 0;
            byte[] buf = new byte[128];
            while (true) {
                int readed = fileInputStream.read(buf);
                if (readed == -1)
                    return latinCounter;
                for (int i = 0; i < readed; i++) {
                    if (Character.isLetter(buf[i]))
                        latinCounter++;
                }
            }
        }
    }
}
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.print("numberOfLatinCharacters:");
            System.out.println(NumberOfWords.numberOfLatinCharacters("src\\file.txt"));
            System.out.print("checkSum:");
            System.out.println(CheckSum.checkSum("src\\file.txt"));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NewCommonest {
    public static String commonestWord(String str) throws IOException {
        ArrayList<String> al = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(str));
        while ((str = br.readLine()) != null)
            Collections.addAll(al, str.split(" "));
        br.close();

        return al.stream()
                .reduce((x, y) -> al.stream().filter(x::equals).count() > al.stream().filter(y::equals).count() ? x : y)
                .get();
    }
}

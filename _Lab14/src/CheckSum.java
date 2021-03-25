import java.io.FileInputStream;
import java.io.IOException;

public class CheckSum {
    public static int checkSum(String filename) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            byte[] buf = new byte[256];
            int sum = 0;
            while (true) {
                int reader = fileInputStream.read(buf);
                if (reader == -1)
                    return sum;
                for (int i = 0; i < reader; i++) {
                    String binaryByte = Integer.toBinaryString(buf[i]);
                    sum ^= Integer.parseInt(binaryByte);
                }
            }
        }
    }
}
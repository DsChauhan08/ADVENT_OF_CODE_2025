import java.io.*;
import java.util.*;

public class puz2{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;
        long total = 0;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.length() < 12) continue;

            StringBuilder out = new StringBuilder();
            int want = 12;
            int start = 0;

            while (want > 0) {
                int maxDigit = -1;
                int maxPos = -1;
                int end = line.length() - want;

                for (int i = start; i <= end; i++) {
                    int d = line.charAt(i) - '0';
                    if (d > maxDigit) {
                        maxDigit = d;
                        maxPos = i;
                    }
                }

                out.append((char)('0' + maxDigit));
                want--;
                start = maxPos + 1;
            }

            long value = Long.parseLong(out.toString());
            total += value;
        }
        System.out.println(total);
    }
}


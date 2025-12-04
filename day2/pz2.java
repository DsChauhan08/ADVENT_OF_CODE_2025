import java.io.*;
import java.util.*;

public class InvalidIDsPart2 {

    static boolean isInvalid(long n) {
        String s = Long.toString(n);
        int len = s.length();

        for (int k = 1; k <= len / 2; k++) {
            if (len % k != 0) continue;
            String block = s.substring(0, k);
            StringBuilder t = new StringBuilder();
            int times = len / k;
            for (int i = 0; i < times; i++) t.append(block);
            if (t.toString().equals(s)) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line = br.readLine();
        br.close();

        String[] parts = line.split(",");
        long total = 0;

        for (String p : parts) {
            p = p.trim();
            if (p.isEmpty()) continue;

            String[] r = p.split("-");
            long A = Long.parseLong(r[0]);
            long B = Long.parseLong(r[1]);
            if (A > B) {
                long t = A;
                A = B;
                B = t;
            }

            for (long x = A; x <= B; x++) {
                if (isInvalid(x)) total += x;
            }
        }

        System.out.println(total);
    }
}


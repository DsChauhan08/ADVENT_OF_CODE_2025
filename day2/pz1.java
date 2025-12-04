import java.io.*;
import java.util.*;

public class pz1{
    static long pow10(int n) {
        long x = 1;
        for (int i = 0; i < n; i++) x *= 10;
        return x;
    }

    static long ceilDiv(long a, long b) {
        if (a % b == 0) return a / b;
        return a / b + 1;
    }

    public static void main() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        String line = in.readLine();

        String parts[] = line.split(",");
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

            for (int k = 1; k <= 9; k++) {
                long t10 = pow10(k);
                long coef = t10 + 1;

                long xMin = ceilDiv(A, coef);
                long xMax = B / coef;

                long low = pow10(k - 1);
                long high = t10 - 1;

                if (xMin < low) xMin = low;
                if (xMax > high) xMax = high;
                if (xMin > xMax) continue;

                long count = xMax - xMin + 1;
                long sum = (xMin + xMax) * count / 2;
                total += sum * coef;
            }
        }

        System.out.println(total);
    }
}



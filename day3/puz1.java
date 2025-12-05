import java.io.*;
import java.util.*;

public class puz1{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;
        long total = 0;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.length() < 2) continue;

            int best = -1;

            for (int i = 0; i < line.length() - 1; i++) {
                int tens = line.charAt(i) - '0';

                int maxRight = -1;
                for (int j = i + 1; j < line.length(); j++) {
                    int d = line.charAt(j) - '0';
                    if (d > maxRight) maxRight = d;
                }

                int value = tens * 10 + maxRight;
                if (value > best) best = value;
            }

            total += best;
        }
        System.out.println(total);
    }
}



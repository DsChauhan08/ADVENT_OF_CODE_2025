import java.io.*;
import java.util.*;

public class puz1{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        List<String> lines = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) lines.add(line.trim());
        }

        int rows = lines.size();
        int cols = lines.get(0).length();

        char[][] g = new char[rows][cols];
        for (int i = 0; i < rows; i++) g[i] = lines.get(i).toCharArray();

        int count = 0;

        int[] dr = {-1,-1,-1, 0,0, 1,1,1};
        int[] dc = {-1, 0, 1,-1,1,-1,0,1};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (g[r][c] != '@') continue;

                int adj = 0;
                for (int k = 0; k < 8; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        if (g[nr][nc] == '@') adj++;
                    }
                }

                if (adj < 4) count++;
            }
        }

        System.out.println(count);
    }
}


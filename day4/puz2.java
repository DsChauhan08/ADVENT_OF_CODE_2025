import java.io.*;
import java.util.*;

public class puz2{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.length() > 0) lines.add(line);
        }

        int rows = lines.size();
        int cols = lines.get(0).length();
        char[][] g = new char[rows][cols];
        for (int r = 0; r < rows; r++) g[r] = lines.get(r).toCharArray();

        int[] dr = {-1,-1,-1, 0,0, 1,1,1};
        int[] dc = {-1, 0, 1,-1,1,-1,0,1};

        int totalRemoved = 0;

        while (true) {
            boolean[][] willRemove = new boolean[rows][cols];
            int found = 0;

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
                    if (adj < 4) {
                        willRemove[r][c] = true;
                        found++;
                    }
                }
            }

            if (found == 0) break;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (willRemove[r][c]) {
                        g[r][c] = '.';
                        totalRemoved++;
                    }
                }
            }
        }

        System.out.println(totalRemoved);
    }
}


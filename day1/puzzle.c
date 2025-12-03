#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "usage: %s input.txt\n", argv[0]);
        return 1;
    }

    FILE *f = fopen(argv[1], "r");
    if (!f) {
        perror("fopen");
        return 1;
    }

    int pos = 50;
    int zeros = 0;
    char dir;
    int dist;

    while (fscanf(f, " %c%d", &dir, &dist) == 2) {
        if (dir == 'L') {
            pos = (pos - dist) % 100;
            if (pos < 0) pos += 100;
        } else {  // 'R'
            pos = (pos + dist) % 100;
        }
        if (pos == 0) zeros++;
    }

    fclose(f);

    printf("%d\n", zeros);
    return 0;
}


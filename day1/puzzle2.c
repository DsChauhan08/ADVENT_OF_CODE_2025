#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "usage: %s input.txt\n", argv[0]);
        return 1;
    }

    FILE *f = fopen(argv[1], "r");
    if (!f) { perror("fopen"); return 1; }

    int pos = 50;             /* current dial position 0..99 */
    long long total = 0;      /* count of times dial hits 0 during clicks */
    char dir;
    long long dist;

    while (fscanf(f, " %c%lld", &dir, &dist) == 2) {
        long long first_k;
        if (dir == 'R') {
            /* small k in 1..dist such that (pos + k) % 100 == 0
               k ≡ (100 - pos) % 100, use 100 when remainder is 0 */
            first_k = (100 - pos) % 100;
            if (first_k == 0) first_k = 100;
        } else { /* 'L' */
            /* k ≡ pos % 100, use 100 when remainder is 0 */
            first_k = pos % 100;
            if (first_k == 0) first_k = 100;
        }

        if (first_k <= dist) {
            total += 1 + (dist - first_k) / 100;
        }

        /* update pos */
        if (dir == 'R') {
            pos = (int)((pos + (dist % 100)) % 100);
        } else {
            pos = (int)((pos - (dist % 100)) % 100);
            if (pos < 0) pos += 100;
        }
    }

    fclose(f);
    printf("%lld\n", total);
    return 0;
}


#include <stdio.h>

int main() {
    int field = 1;
    long long grains = 1, total_grains = 0;

    printf("Field\tGrains\tTotal Grains\n");

    while (field <= 64) {
        printf("%d\t%lld\t%lld\n", field, grains, total_grains);
        total_grains += grains;
        grains *= 2;
        field++;
    }

    return 0;
}

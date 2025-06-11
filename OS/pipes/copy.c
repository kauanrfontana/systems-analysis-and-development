#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    if (argc != 3)
    {
        fprintf(stderr, "Uso: %s <origem> <destino>\n", argv[0]);
        return 1;
    }

    FILE *src = fopen(argv[1], "rb");
    if (!src)
    {
        perror("Erro ao abrir arquivo de origem");
        return 1;
    }

    FILE *dst = fopen(argv[2], "wb");
    if (!dst)
    {
        perror("Erro ao abrir arquivo de destino");
        fclose(src);
        return 1;
    }

    char buffer[4096];
    size_t bytes;
    while ((bytes = fread(buffer, 1, sizeof(buffer), src)) > 0)
    {
        if (fwrite(buffer, 1, bytes, dst) != bytes)
        {
            perror("Erro ao escrever no arquivo de destino");
            fclose(src);
            fclose(dst);
            return 1;
        }
    }

    fclose(src);
    fclose(dst);
    return 0;
}

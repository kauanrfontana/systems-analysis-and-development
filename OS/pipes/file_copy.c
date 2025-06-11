#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>

int main(int argc, char *argv[])
{
    if (argc != 3)
    {
        fprintf(stderr, "Uso: %s <origem> <destino>\n", argv[0]);
        return 1;
    }

    int pid, fd[2];

    pipe(fd);

    FILE *src = fopen(argv[1], "rb");

    char buffer[4096];
    size_t bytes;

    pid = fork();
    if (pid == -1)
    {
        perror("fork falhou!");
        exit(-1);
    }
    else if (pid != 0)
    {
        close(fd[0]);
        if (!src)
        {
            perror("Erro ao abrir arquivo de origem");
            return 1;
        }

        while ((bytes = fread(buffer, 1, sizeof(buffer), src)) > 0)
        {
            write(fd[1], buffer, bytes);
        }
        fclose(src);
        exit(0);
    }
    else
    {

        close(fd[1]);
        FILE *dst = fopen(argv[2], "wb");
        if (!dst)
        {
            perror("Erro ao abrir arquivo de destino");
            return 1;
        }

        while ((bytes = read(fd[0], buffer, sizeof(buffer))))
        {
            if (fwrite(buffer, 1, bytes, dst) != bytes)
            {
                perror("Erro ao escrever no arquivo de destino");
                fclose(dst);
                return 1;
            }
        }

        fclose(dst);
        exit(0);
    }
}
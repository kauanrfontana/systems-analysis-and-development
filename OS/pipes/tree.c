#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>


char *message = "This is a message!!!";
int main()
{
    char buf[1024];
    int pid, fd[2];

    pid = fork();
    if (pid == -1)
    {
        perror("fork falhou!");
        exit(-1);
    }
    else if (pid == 0)
    {
        pid = fork();
        if (pid == -1)
        {
            perror("fork falhou!");
            exit(-1);
        }
        else if (pid == 0)
        {
            pid = fork();
            if (pid == -1)
            {
                perror("fork falhou!");
                exit(-1);
            }
            else if (pid == 0)
            {
                write(fd[1], message, strlen(message) + 1);
            }
            else
            {
                wait(0);
                read(fd[0], buf, 1024);
                write(fd[1], buf, strlen(buf) + 1);
                exit(0);
            }
        }
        else
        {
            wait(0);
            read(fd[0], buf, 1024);
            write(fd[1], buf, strlen(buf) + 1);
            exit(0);
        }
    }
    else
    {
        wait(0);
        read(fd[0], buf, 1024);
        printf("Mensagem: %s\n", buf);
        exit(0);
    }
}
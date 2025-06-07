#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
char *message = "This is a message!!!";
int main()
{
    char buf[1024];
    int fd[2];
    pipe(fd); // cria pipe

    if (fork() != 0)
    { // processo pai
        write(fd[1], message, strlen(message) + 1);
    }
    else
    { // processo filh
        read(fd[0], buf, 1024);
        printf("Got this from MaMa!!: %s\n", buf);
    }
}
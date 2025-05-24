#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int pid;
    pid = fork();
    if (pid == -1) {
        perror("fork falhou!");
        exit(-1);
    } else if (pid == 0) {
        pid = fork();
        if (pid == -1) {
            perror("fork falhou!");
            exit(-1);
        } else if (pid == 0) {
            sleep(1);
            printf("Eu sou o processo %d, filho de %d \n", getpid(), getppid());
            exit(0);
        } else {
            wait(0);
            sleep(1);
            printf("Eu sou o processo %d, filho de %d \n", getpid(), getppid());
            exit(0);
        }
        exit(0);
    } else {
        wait(0);
        sleep(1);
        printf("Eu sou o processo %d, filho de %d \n", getpid(), getppid());
        exit(0);
    }
}
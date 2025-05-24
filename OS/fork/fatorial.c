#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int pid, status;
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
            status = 5 * 4;
            exit(status);
        } else {
            wait(&status);
            if ( WIFEXITED(status) )
            {
                status = WEXITSTATUS(status) * 3;        
            }
            exit(status);
        }
        
    } else {
        wait(&status);
        if ( WIFEXITED(status) )
        {
            status = WEXITSTATUS(status) * 2;
            printf("O resultado de !5 é %d.", status);
        }
        exit(0);
    }
}
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>

int main(int argc, char *argv[], char *envp[]) {
    int espera;
    char cmd[4096];
    char wait_char[2][4] = {"com", "sem"};

    while(1){
        espera = 1;
        printf("SopTerm> ");
        fgets(cmd, 4096, stdin);
        int tamanho = strcspn(cmd, "\n");
        cmd[tamanho] = '\0';
        if(strncmp(cmd, "sair", 4) == 0){
            exit(0);
        }

        if(cmd[tamanho-1] == '&'){
            espera = 0;
            cmd[tamanho-1] = '\0';
        }


        int pid;

        pid = fork();

        if(pid == -1){
            perror("fork falhou!");
            exit(-1);
        }else if(pid == 0){
            execve(cmd, argv, envp);
            perror("Erro: ");
        }else {
            if(espera){
                wait(0);
            }
            exit(0);
        }
    }
}
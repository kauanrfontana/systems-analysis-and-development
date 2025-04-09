#include<stdio.h>
char decompose(float x, int *int_part, float *frac_part)
{
    *int_part = (int) x;
    *frac_part = x - *int_part;
    return x < 0 ? '-' : '+';
}

int main()
{
    float num, frac_part;
    int int_part;
    printf("Digite um número decimal:\n");
    scanf("%f", &num);
    char signal = decompose(num, &int_part, &frac_part);
    printf("Número: %f, Parte inteira: %d, Parte decimal: %f, Sinal: %c\n", num, int_part, frac_part, signal);
    return 0;
}
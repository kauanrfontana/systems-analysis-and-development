#include <stdio.h>
#include <math.h>

const float R_TERRA = 6371.00;

float hav(float theta)
{
    return pow(sin(theta / 2), 2);
}

float grau2rad(float graus)
{
    return (2 * M_PI) / 360 * graus;
}

float distancia_na_terra(float lat1, float lon1, float lat2, float lon2)
{
    return 2 * R_TERRA * asin(sqrt(hav(lat2 - lat1) + cos(lat1) * cos(lat2) * hav(lon2 - lon1)));
}

int main()
{
    float lat1, lon1, lat2, lon2;

    printf("Digite a latitude e a longitude do primeiro ponto(lat lon):\n");
    scanf("%f %f", &lat1, &lon1);

    printf("Digite a latitude e a longitude do segundo ponto(lat lon):\n");
    scanf("%f %f", &lat2, &lon2);

    printf("A distância é de %fkm\n", distancia_na_terra(grau2rad(lat1), grau2rad(lon1), grau2rad(lat2), grau2rad(lon2)));
    return 0;
}
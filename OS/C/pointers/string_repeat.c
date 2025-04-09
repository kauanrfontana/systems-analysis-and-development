#include<stdio.h>

int string_rep(char *src[11], int n, char *dest[101])
{
    int size = 0;

    for (size_t i = 0; i < 10; i++){
        size = i;
        if(*src[i] == 0){
            break;
        }
    }

    for (size_t i = 0; i < n; i++)
    {
        int lastIndex = 0;

        for (size_t j = 0; j < size; j++)
        {
           *dest[lastIndex] = *src[j];
           lastIndex++; 
        }
    }
    

    return sizeof(*dest);
}

int main()
{
    char src[11], dest[101];
    int n;
    
    scanf("%s", &src);
    scanf("%d", &n);
   
    //string_rep(&src, n, &dest); 

    printf("%s", *dest);
    
}
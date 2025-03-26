#include<stdio.h>
int main()
{
    int day, month, year;
    printf("Digite a data desejada: \n");
    scanf("%d/%d/%d", &day, &month, &year);

    char *monthName;
    switch (month){
        case 1:
            monthName = "January";
            break;
        case 2:
            monthName = "February";
            break;
        case 3:
            monthName = "March";
            break;
        case 4:
            monthName = "April";
            break;
        case 5:
            monthName = "May";
            break;
        case 6:
            monthName = "June";
            break;
        case 7:
            monthName = "July";
            break;
        case 8:
            monthName = "August";
            break;
        case 9:
            monthName = "September";
            break;
        case 10:
            monthName = "October";
            break;
        case 11:
            monthName = "November";
            break;
        case 12:
            monthName = "December";
            break;
    }

    char *suffix;
    if(day % 10 == 1) {
        suffix = "st";
    }

    if(day % 10 == 2){
        suffix = "nd";
    }

    if(day % 10 == 3){
        suffix = "rd";
    }

    if((day > 3 && day < 21) || !suffix){
        suffix = "th";
    }

    printf("%s %d%s, %d\n.", monthName, day, suffix, year);

    return 0;
}

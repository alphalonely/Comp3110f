#include <stdio.h>
#include <string.h>
#include <ctype.h>

char *isValidDnaChar(char dnaString[]) {
    int n = strlen(dnaString);
    for(int i = 0; i < n; i++){


    }

    for (int i = 0; dnaString[i] != '\0'; i++) {
        dnaString[i] = toupper(dnaString[i]);
    }
    
    
    return dnaString;

}

void runLengthEncoding(char dnaString[]) {
    int n = strlen(dnaString);
    int count = 1;

    printf("The Run Length Encoded string is: ");
    for (int i = 1; i <= n; i++) {
        
        if (dnaString[i] == dnaString[i - 1]) {
            count++;
        } else {
            if (count > 1) {
                printf("%c%d", dnaString[i - 1], count);
            } else {
                printf("%c", dnaString[i - 1]);
            }
            count = 1;
        }
    }
    printf("\n");
}

int main() {
    char dnaString[100];
    while(1){
        int menu;
    printf("Enter an input DNA string: ");
    scanf("%s", dnaString);
    
    while(isValidDnaChar(dnaString) == NULL){
        while(getchar()!= '\n');
        scanf("%s", dnaString);
    }

    runLengthEncoding(dnaString);

    printf("Continue?");
    scanf("%d",& menu);
    if(menu == 0){
        break;
    }else{
        while(getchar()!= '\n');
    }
    }

    return 0;
}

#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isEmailValid(char *email) {
    int atCount = 0, dotCount = 0;

     char *atpos = NULL;
    
    // locat the  '@' symbol
    for (char *ptr = email; *ptr != '\0'; ptr++) {
        if (*ptr == '@') {
            atCount++;
             atpos = ptr;
        }
    }

    if (atCount != 1) {
        printf("Invalid email: must contain exactly one '@' symbol.\n");
        return 0;
    }

    // Check for '.' symbol after '@'
    char *dotpos = NULL;
    for (char *ptr = atpos + 1; *ptr != '\0'; ptr++) {
        if (*ptr == '.') {
            dotCount++;
        
        }
    }
    if (dotCount == 0) {
        printf("Invalid email: must contain at least one '.' symbol after '@'.\n");
        return 0;
    }

    if(dotCount == 1){
        for (char *ptr = atpos + 1; *ptr != '\0'; ptr++) {
            if (*ptr == '.') {
                dotpos = ptr;
            }
    }
    if(dotpos - atpos < 1 ){
        printf("Invalid email: domain part must have at lease 2 characters between '@' and '.' \n");
        return 0;
   }
   if(strlen(dotpos + 1) < 2){
       printf("Invalid email: domain part after '.' should have at least 2 characters.\n");
       return 0;
   }
}


   if(dotCount > 1){
    char *firstdot;
    for (char *ptr = atpos + 1; *ptr != '\0'; ptr++) {
        if (*ptr == '.') {
            firstdot = ptr;
            break;
        }
    }
    if(firstdot - atpos < 1 ){
    printf("Invalid email: domain part must have at lease 2 characters between '@' and '.' \n");
    return 0;
   }
   dotpos = strrchr(atpos, '.');
     if(strlen(dotpos + 1) < 2){
       printf("Invalid email: domain part after last '.' should have at least 2 characters.\n");
       return 0;
   }
   }
   
 
    // Check local part (before '@')
    for (char *ptr = email; ptr < atpos; ptr++) {
    
        if (!(*ptr >= '0' && *ptr <= '9' || *ptr >= 'A' && *ptr <= 'Z' || *ptr >= 'a' && *ptr <= 'z')) {
            printf("Invalid email: local part contains invalid characters.\n");
            return 0;
        }
    }

    if (email == atpos) {
        printf("Invalid email: local part must not be empty.\n");
        return 0;
    }





    printf("The entered email address is valid.\n");
    return 1;

}

int main() {
    while(1){
    int menu;
    char email[100];

    printf("Enter an email address: \n");
    scanf("%99[^\n]s", email);

    if (isEmailValid(email)) {
        printf("The email address '%s' is valid.\n", email);
    } else {
        printf("The email address '%s' is not valid.\n", email);
    }
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

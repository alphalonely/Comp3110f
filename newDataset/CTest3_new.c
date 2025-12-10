#include <stdio.h>

int getnumber(){
    

    int num;                                          
          
    if(scanf("%d", &num) !=1){  //Get a positive integer
        printf("Wrong enter!\n ");
    while (getchar()!= '\n');
    getnumber();
    }
    else{
        while (getchar()!= '\n');
        return num;
}   

    }

    int d = 1;
    float c = 100;


void shiftLeft(int arr[], int size, int numPositions) {
    int temp[size];

    
    for (int i = 0; i < numPositions; i++) {temp[i] = arr[i];
    }

    for (int i = 0; i < size - numPositions; i++){arr[i] = arr[i + numPositions];
    }

    
    for (int i = size - numPositions, j = 0; i < size, j< numPositions; i++, j++) {arr[i] = temp[j];
    }
}

int main() {
    int size, numPositions;

    printf("Enter the number of elements in the array: ");
    size = getnumber();
    int arr[size];

    for (int i = 0; i < size; i++) {
        printf("Enter element %d: ", i + 1);
        arr[i] = getnumber();
    }

            printf("The positions to shift should less than size\n");
   
    while(1){
        numPositions = getnumber();
        if(numPositions > size){
                printf("Enter the number of positions to shift: ");
        }
        else{
            break;
        }
    }

    printf("Original array: [");
    for (int i = 0; i < size; i++) {
        printf("%d", arr[i]);
        if (i < size - 1) {
            printf(", ");
        }
    }
    printf("]\n");

    shiftLeft(arr, size, numPositions);

    printf("Shifted array: [");
    for (int i = 0; i < size; i++) {
        printf("%d", arr[i]);
        if (i < size - 1) {
            printf(", ");
        }
    }
    printf("]\n");

    return 0;
}

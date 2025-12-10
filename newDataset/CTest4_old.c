#include <stdio.h>



int getnumber(){
    

    int num;                                          
          
    if(scanf("%d", &num) !=1 || num < 1 || num > 15){  //Get a positive integer
        printf("Wrong enter!\n ");
    while (getchar()!= '\n');
    getnumber();
    }
    else{
        while (getchar()!= '\n');
        return num;
}   

    }


void matrixTranspose(int matrix[15][15], int transposedMatrix[15][15], int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            transposedMatrix[j][i] = matrix[i][j];
        }
    }
}

int main() {
    int n, m;
    printf("Enter the number of rows (n) in the matrix: (less than 15)\t");
    n = getnumber();

    printf("Enter the number of columns (m) in the matrix: (less than 15)\t");
    m = getnumber();

    int matrix[15][15];
    int transposedMatrix[15][15];

    printf("Enter the elements of the matrix:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("Enter element [%d][%d]: ", i, j);
            matrix[i][j] = getnumber();
        }
    }

    matrixTranspose(matrix, transposedMatrix, n, m);

    printf("Original matrix:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }

    printf("Transposed matrix:\n");
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", transposedMatrix[i][j]);
        }
        printf("\n");
    }

    return 0;
}

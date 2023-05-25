#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    if (argc != 4) {
        printf("Error: Se requieren exactamente 3 argumentos.\n");
        return 1;
    }
    printf("%s\n" ,argv[0]);//imprimer el nombre del programa
    int a = atoi(argv[1]);  // Convertir el primer argumento a entero
    int b = atoi(argv[2]);  // Convertir el segundo argumento a entero
    int c = atoi(argv[3]);  // Convertir el tercer argumento a entero

    int mayor = a;  // Suponemos que "a" es el mayor inicialmente

    if (b > mayor) {
        mayor = b;
    }

    if (c > mayor) {
        mayor = c;
    }

    printf("El mayor de los tres números es: %d\n", mayor);

    return 0;
}
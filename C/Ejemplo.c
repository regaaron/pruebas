#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definición de estructura
struct Persona {
    char nombre[50];
    int edad;
};

// Función para imprimir los datos de una persona
void imprimirPersona(struct Persona p) {
    printf("Nombre: %s\n", p.nombre);
    printf("Edad: %d\n", p.edad);
}

int main() {
    // Declaración de variables de diferentes tipos
    int entero = 10;
    float flotante = 3.14;
    char caracter = 'A';
    
    // Utilizando estructura de control for
    printf("Usando un bucle for:\n");
    for (int i = 0; i < 5; i++) {
        printf("%d ", i);
    }
    printf("\n\n");
    
    // Utilizando estructura de control while
    printf("Usando un bucle while:\n");
    int j = 0;
    while (j < 5) {
        printf("%d ", j);
        j++;
    }
    printf("\n\n");
    
    // Utilizando estructura de control do-while
    printf("Usando un bucle do-while:\n");
    int k = 0;
    do {
        printf("%d ", k);
        k++;
    } while (k < 5);
    printf("\n\n");
    
    // Declaración y uso de un arreglo
    int numeros[5] = {1, 2, 3, 4, 5};
    printf("Elementos del arreglo:\n");
    for (int i = 0; i < 5; i++) {
        printf("%d ", numeros[i]);
    }
    printf("\n\n");
    
    // Declaración y uso de una estructura
    struct Persona persona;
    strcpy(persona.nombre, "Juan");
    persona.edad = 25;
    
    // Llamada a la función que imprime los datos de una persona
    printf("Datos de la persona:\n");
    imprimirPersona(persona);
    printf("\n");
    
    // Uso de gestión de memoria
    int* numerosDinamicos = (int*)malloc(3 * sizeof(int));
    numerosDinamicos[0] = 10;
    numerosDinamicos[1] = 20;
    numerosDinamicos[2] = 30;
    
    printf("Elementos del arreglo dinámico:\n");
    for (int i = 0; i < 3; i++) {
        printf("%d ", numerosDinamicos[i]);
    }
    
    free(numerosDinamicos);
    
    return 0;
}

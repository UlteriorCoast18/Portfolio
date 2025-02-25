/*

	Programa de Alvarado Cristo Daniel

*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <unistd.h>

#define TIEMPO	1000

int imprimirArreglo(int arreglo[], int n);
int limpiarLinea(int arreglo[], int n);

int primerMetodo(int arreglo[], int n, int elem);
int segundoMetodo(int arreglo[], int n, int elem);
int tercerMetodo(int arreglo[], int n, int elem);

int main(int argc, char *argv[]) {
	int elementos[] = {1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, n, i, elem;
	n = sizeof(elementos)/sizeof(int);
	
	printf("\nPrograma que muestra los tipos de busquedas que se pueden realizar en un arreglo.\n");

	double k = sqrt(10);
	
	sleep(TIEMPO);
	printf("\nBusqueda Lineal\n");
	sleep(TIEMPO);
	
	elem = 14;
	printf("\nElemento a buscar: %d\n", elem);
	sleep(TIEMPO);
	imprimirArreglo(elementos, n);
	sleep(TIEMPO);
	primerMetodo(elementos, n, elem);
	
	elem = 3;
	printf("\nElemento a buscar: %d\n", elem);
	sleep(TIEMPO);
	imprimirArreglo(elementos, n);
	sleep(TIEMPO);
	primerMetodo(elementos, n, elem);
	
	sleep(TIEMPO);
	printf("\nBusqueda Binaria\n");
	sleep(TIEMPO);
	
	elem = 14;
	printf("\nElemento a buscar: %d\n", elem);
	sleep(TIEMPO);
	imprimirArreglo(elementos, n);
	sleep(TIEMPO);
	segundoMetodo(elementos, n, elem);
	
	elem = 3;
	printf("\nElemento a buscar: %d\n", elem);
	sleep(TIEMPO);
	imprimirArreglo(elementos, n);
	sleep(TIEMPO);
	segundoMetodo(elementos, n, elem);
	
	sleep(TIEMPO);
	printf("\nBusqueda Hash\n");
	sleep(TIEMPO);
	
	elem = 14;
	printf("\nElemento a buscar: %d\n", elem);
	sleep(TIEMPO);
	imprimirArreglo(elementos, n);
	sleep(TIEMPO);
	tercerMetodo(elementos, n, elem);
	
	elem = 3;
	printf("\nElemento a buscar: %d\n", elem);
	sleep(TIEMPO);
	imprimirArreglo(elementos, n);
	sleep(TIEMPO);
	tercerMetodo(elementos, n, elem);
	
	printf("\nFin del programa.\n");
	system("pause");
	return 0;
}

int generaPrimo(int n){
	int i, j, aux;
	if(n == 1 || n == 2) return 2;
	for(i = n; i > 0; i--){
		aux = sqrt(i) + 1;
		for(j = 2; j < aux; j++){
			if(i % j == 0) break;
		}
		if(j != aux) continue;
		else return i;
	}
	return 2;
}

int imprimirArreglo(int arreglo[], int n){
	int i, j, cont, i_aux;
	for(i = -1; i <= 1; i++){
		for(j = 0; j < n; j++){
			if(i == 0) printf("|%d", arreglo[j]);
			else{
				cont = 0;
				printf("-");
				i_aux = arreglo[j];
				do{
					cont++;
					i_aux /= 10;
				}while(i_aux != 0);
				for(i_aux = 0; i_aux < cont; i_aux++){
					printf("-");
				}
			}
		}
		if(i == 0) printf("|\n");
		else printf("-\n");
	}
	return 0;
}

int limpiarLinea(int arreglo[], int n){
	int j, cont, i_aux;
	for(j = 0; j < n; j++){
		cont = 0;
		printf(" ");
		i_aux = arreglo[j];
		while(i_aux != 0){
			cont++;
			i_aux /= 10;
		}
		for(i_aux = 0; i_aux < cont; i_aux++){
			printf(" ");
		}
	}
	printf("                             \r");
	return 0;
}

int escribirDebajo(int arreglo[], int n, int i, int elem){
	int j, cont, i_aux;
	for(j = 0; j < i; j++){
		cont = 0;
		printf("-");
		i_aux = arreglo[j];
		while(i_aux != 0){
			cont++;
			i_aux /= 10;
		}
		for(i_aux = 0; i_aux < cont; i_aux++){
			printf("-");
		}
	}
	printf("-");
	return 0;
}

int primerMetodo(int arreglo[], int n, int elem){ //fuerza bruta
	int i;
	for(i = 0; i < n; i++){
		escribirDebajo(arreglo, n, i, elem);
		printf("%d = %d?\r", elem, arreglo[i]);
		sleep(TIEMPO);
		if(elem == arreglo[i]){
			escribirDebajo(arreglo, n, i, elem);
			printf("%d = %d!", elem, arreglo[i]);
			sleep(TIEMPO);
			printf("\nSe ha encontrado el elemento.\n");
			return 1;
		}
	}
	limpiarLinea(arreglo, n);
	printf("\nNo se encontro el elemento.\n");
	return 0;
}

int segundoMetodo(int arreglo[], int n, int elem){//suponiendo que el arreglo est� ordenado
	int m, M, N_2, N_2_aux;
	
	M = n - 1;
	m = 0;
	
	N_2 = (M - m)/2;
	
	while(M > m + 1){
		escribirDebajo(arreglo, n, N_2, elem);
		printf("%d = %d?\r", elem, arreglo[N_2]);
		sleep(TIEMPO);
		if(elem == arreglo[N_2]){
			limpiarLinea(arreglo, n);
			escribirDebajo(arreglo, n, N_2, elem);
			printf("%d = %d!\r", elem, arreglo[N_2]);
			printf("\nSe ha encontrado el elemento.\n");
			return 1;
		}
		else{
			if(elem > arreglo[N_2]){
				m = N_2;
				N_2 += (M - m)/2;
			}
			else{
				M = N_2;
				N_2 -= (M - m)/2;
			}
		}
		limpiarLinea(arreglo, n);
	}
	
	escribirDebajo(arreglo, n, m, elem);
	printf("%d = %d?\r", elem, arreglo[m]);
	sleep(TIEMPO);
	
	if(elem == arreglo[m]){
		limpiarLinea(arreglo, n);
		escribirDebajo(arreglo, n, m, elem);
		printf("%d = %d!\r", elem, arreglo[m]);
		sleep(TIEMPO);
		printf("\nSe ha encontrado el elemento.\n");
		return 1;
	}
	limpiarLinea(arreglo, n);
	escribirDebajo(arreglo, n, M, elem);
	printf("%d = %d?\r", elem, arreglo[M]);
	sleep(TIEMPO);
	
	if(elem == arreglo[M]){
		limpiarLinea(arreglo, n);
		escribirDebajo(arreglo, n, M, elem);
		printf("%d = %d!\r", elem, arreglo[M]);
		sleep(TIEMPO);
		printf("\nSe ha encontrado el elemento.\n");
		return 1;
	}
	limpiarLinea(arreglo, n);
	
	printf("\nNo se encontro el elemento.\n");
	return 0;
}

int tercerMetodo(int arreglo[], int n, int elem){
	int i, j, p, i_0;
	p = generaPrimo((int)(sqrt(n) + 1));
	//funci�n que genera primo menor a un n�mero dado
	int tabla[p][n], coords[p][n];
	
	for(i = 0; i < p; i++){
		for(j = 0; j < n; j++){
			tabla[i][j] = 0;
			coords[i][j] = -1;
		}
	}
	/*Ahora se introducen los elementos a la tabla*/
	for(i = 0; i < n; i++){
		i_0 = arreglo[i] % p;
		j = 0;
		while(tabla[i_0][j] != 0) j++;
		tabla[i_0][j] = arreglo[i];
		coords[i_0][j] = i;
	}
	/*Ahora se busca el elemento en la tabla*/
	i_0 = elem % p;
	j = 0;
	while(tabla[i_0][j] != elem && tabla[i_0][j] != 0){
		i = coords[i_0][j];
		j++;
		limpiarLinea(arreglo, n);
		escribirDebajo(arreglo, n, i, elem);
		printf("%d = %d?\r", elem, arreglo[i]);
		sleep(TIEMPO);
	}
	if(tabla[i_0][j] != elem){
		limpiarLinea(arreglo, n);
		printf("\nNo se encontro el elemento.\n");
		return 0;
	}
	else{
		i = coords[i_0][j];
		limpiarLinea(arreglo, n);
		escribirDebajo(arreglo, n, i, elem);
		printf("%d = %d!\r", elem, arreglo[i]);
		sleep(TIEMPO);
		printf("\nSe ha encontrado el elemento.\n");
		return 1;
	}
}

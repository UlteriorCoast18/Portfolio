/*

Programa de ALvarado Cristo Daniel

*/

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <malloc.h>
#include <unistd.h>

#define ROW	25
#define COL	80
#define TIEMPO	1

typedef struct _pantalla_{
	int m, n;
	char p[ROW][COL];
}Pantalla;

typedef struct _nodo_{
	int info;
	int i;
	struct _nodo_ *der, *izq;
}NODO;

typedef NODO *ARBOL;

int copiaArreglo(int origen[], int destino[], int n);

/*Funciones del manejo de la pantalla*/
int generaPantalla(Pantalla *P, int arreglo[], int n);
int imprimePantalla(Pantalla P);
int cambiaColumnasPantalla(Pantalla *P, int i, int j);

int imprimeArreglo(int arreglo[], int n);

/*M�todos de ordenamiento*/

int ordenamientoIntercambioDirecto(int arreglo[], int n, Pantalla *P);
int ordenamientoSeleccionDirecta(int arreglo[], int n, Pantalla *P);
int ordenamientoInsercionDirecta(int arreglo[], int n, Pantalla *P);
int ordenamientoShellsort(int arreglo[], int n, Pantalla *P);

int ordenamientoHeapsort(int arreglo[], int n, Pantalla *P);
int removerUltimoElemento(ARBOL *A, int n);
int acomodarArbol(ARBOL *A, int n);
int generarArbol(ARBOL *A, int arreglo[], int n);
int conversorBinario(int num, int bin[128]);

int ordenamientoQuicksort(int arreglo[], int l, int u, Pantalla *P, int n);
int ordenamientoMergesort(int arreglo[], int l, int u, Pantalla *P, int n);

int main(int argc, char *argv[]) {
	int arreglo[] = {14,15,16,13,21,2,25,17,24,22,18,10,11,1,9,19,3,20,4,5,6,23,7,8,12}, i, n; //10 elementos
	Pantalla P;
	n = sizeof(arreglo)/sizeof(int);
	
	int aux[n];
	
	copiaArreglo(arreglo, aux, n);
	generaPantalla(&P, arreglo, n);
	
	printf("\nArreglo Inicial: \n\n");
	imprimePantalla(P);

	sleep_ms(TIEMPO);
	printf("\nAhora se realizaran los metodos de ordenamiento.\n");
	sleep_ms(TIEMPO);
	
	printf("\n Intercambio Directo: \n");
	ordenamientoIntercambioDirecto(aux, n, &P);
	
	sleep_ms(TIEMPO);
	printf("\nAhora el de seleccion directa:\n");
	sleep_ms(TIEMPO);
	
	copiaArreglo(arreglo, aux, n);
	generaPantalla(&P, arreglo, n);
	printf("\n Seleccion directa: \n");
	ordenamientoSeleccionDirecta(aux, n, &P);
	
	sleep_ms(TIEMPO);	
	printf("\nAhora el de insercion directa:\n");
	sleep_ms(TIEMPO);
	
	copiaArreglo(arreglo, aux, n);
	generaPantalla(&P, arreglo, n);
	printf("\n Insercion Directa: \n");
	ordenamientoInsercionDirecta(aux, n, &P);
	
	sleep_ms(TIEMPO);
	printf("\nAhora Shellsort:\n");
	sleep_ms(TIEMPO);
	
	copiaArreglo(arreglo, aux, n);
	generaPantalla(&P, arreglo, n);
	printf("\n Shellsort: \n");
	ordenamientoShellsort(aux, n, &P);
	
	sleep_ms(TIEMPO);
	printf("\nAhora Heapsort:\n");
	sleep_ms(TIEMPO);
	
	copiaArreglo(arreglo, aux, n);
	generaPantalla(&P, arreglo, n);
	printf("\n Heapsort: \n");
	ordenamientoHeapsort(aux, n, &P);
	
	sleep_ms(TIEMPO);
	printf("\nAhora Quicksort:\n");
	sleep_ms(TIEMPO);
	
	copiaArreglo(arreglo, aux, n);
	generaPantalla(&P, arreglo, n);
	printf("\n Quicksort: \n");
	ordenamientoQuicksort(aux, 0, n - 1, &P, n);
	
	sleep_ms(TIEMPO);
	printf("\nAhora Mergesort:\n");
	sleep_ms(TIEMPO);
	
	copiaArreglo(arreglo, aux, n);
	generaPantalla(&P, arreglo, n);
	printf("\n Mergesort: \n");
	ordenamientoMergesort(aux, 0, n - 1, &P, n);
	
	printf("\nFin del programa.\n");
	system("pause");
	return 0;
}

void sleep_ms(int milliseconds)
{
    // Convert milliseconds to microseconds
    usleep(milliseconds * 1000);
}

int copiaArreglo(int origen[], int destino[], int n){
	int i;
	for(i = 0; i < n; i++){
		destino[i] = origen[i];
	}
	return 0;
}

int imprimeArreglo(int arreglo[], int n){
	int i;
	for(i = 0; i < n; i++){
		printf(" %d", arreglo[i]);
	}
	printf("\n");
	return 0;
}

int ordenamientoIntercambioDirecto(int arreglo[], int n, Pantalla *P){
	int i, j, aux;
	for(i = 0; i < n; i++){
		for(j = 1; j < n; j++){
			if(arreglo[j] < arreglo[j - 1]){
				aux = arreglo[j];
				arreglo[j] = arreglo[j - 1];
				arreglo[j - 1] = aux;
				/**/
				system("clear");
				cambiaColumnasPantalla(P, j, j - 1);
				printf("\nOrdenamiento Intercambio Directo:\n");
				imprimePantalla(*P);
				sleep_ms(20); //poner en 20
				/**/
			}
		}
	}
	return 0;
}

int ordenamientoSeleccionDirecta(int arreglo[], int n, Pantalla *P){
	int i, j, min, j_aux, aux;
	for(i = 0; i < n - 1; i++){
		min = arreglo[i];
		j_aux = i;
		for(j = i + 1; j < n; j++){
			if(arreglo[j] < min){
				min = arreglo[j];
				j_aux = j;
			}
		}
		aux = arreglo[i];
		arreglo[i] = min;
		arreglo[j_aux] = aux;
		/**/
		cambiaColumnasPantalla(P, i, j_aux);
		system("clear");
		printf("\nOrdenamiento Seleccion directa:\n");
		imprimePantalla(*P);
		sleep_ms(200); //poner en 200
		/**/
	}
	return 0;
}

int ordenamientoInsercionDirecta(int arreglo[], int n, Pantalla *P){
	int i, j, k, aux;
	for(i = 1; i < n; i++){
		for(j = 0; j < i; j++){
			if(arreglo[i] < arreglo[j]){
				aux = arreglo[j];
				arreglo[j] = arreglo[i];
				for(k = i; k > j; k--){
					arreglo[k] = arreglo[k - 1];
				}
				arreglo[k + 1] = aux;
				/**/
				generaPantalla(P, arreglo, n);
				cambiaColumnasPantalla(P, k, j);
				system("clear");
				printf("\nOrdenamiento Insercion directa:\n");
				imprimePantalla(*P);
				sleep_ms(150); //150
				/**/
				break;
			}
		}
	}
	return 0;
}

int ordenamientoShellsort(int arreglo[], int n, Pantalla *P){
	int i, j, aux;
	for(i = n/2; i > 0; i--){
		for(j = 0; j + i < n; j++){
			if(arreglo[j + i] < arreglo[j]){
				aux = arreglo[j + i];
				arreglo[j + i] = arreglo[j];
				arreglo[j] = aux;
				/**/
				cambiaColumnasPantalla(P, j, j + i);
				system("clear");
				printf("\nOrdenamiento Shellsort:\n");
				imprimePantalla(*P);
				sleep_ms(150); //150
				/**/
			}
		}
	}
	return 0;
}

/*------------------------------------------------------------*/

int ordenamientoHeapsort(int arreglo[], int n, Pantalla *P){
	int i, j, bin[128], n_aux;
	ARBOL valores = NULL, aux = NULL;
	generarArbol(&valores, arreglo, n);
	n_aux = n;
	for(i = n - 1; i >= 0; i--){
		acomodarArbol(&valores, n);
		n--;
		arreglo[i] = valores->info;
		j = valores->i;
		/**/
		generaPantalla(P, arreglo, n_aux);
		system("clear");
		printf("\nOrdenamiento Heapsort:\n");
		imprimePantalla(*P);
		sleep_ms(200);//50
		/**/
		removerUltimoElemento(&valores, i);
	}
	return 0;
}

int removerUltimoElemento(ARBOL *A, int n){
	int j, bin[128];
	ARBOL aux = NULL;
	aux = *A;
	conversorBinario(n + 1, bin);
	j = 1;
	while(bin[j] != -1){
		if(bin[j] == 1){
			aux = aux->der;
		}
		else if(bin[j] == 0){
			aux = aux->izq;
		}
		j++;
	}
	(*A)->info = aux->info;
	(*A)->i = aux->i;
	aux->der = NULL;
	aux->izq = NULL;
	aux->info = 0;
	aux->i = -1;
	return 0;
}

int acomodarArbol(ARBOL *A, int n){
	int i, j, k, bin[128], aux_d, aux_i, info_aux, v_i, v_d, v;
	ARBOL aux;
	
	for(k = 0; k < 2; k++){
		for(i = 0; i < n; i++){
			aux = *A;
			if(i > 0){
				conversorBinario(i + 1, bin);
				j = 1;
				while(bin[j] != -1){
					if(bin[j] == 1){
						aux = aux->der;
					}
					else if(bin[j] == 0){
						aux = aux->izq;
					}
					j++;
				}
			}
			if(aux->der != NULL || aux->izq != NULL){
				info_aux = aux->info;
				v = aux->i;
				if(!(aux->der == NULL) && !(aux->izq == NULL)){
					aux_d = aux->der->info;
					aux_i = aux->izq->info;
					v_d = aux->der->i;
					v_i = aux->izq->i;
					if(aux_d > aux_i){
						if(aux_d > info_aux){
							aux->info = aux_d;
							aux->i = v_d;
							aux->der->info = info_aux;
							aux->der->i = v;
						}
					}
					else{
						if(aux_i > info_aux){
							aux->info = aux_i;
							aux->i = v_i;
							aux->izq->info = info_aux;
							aux->izq->i = v;
						}
					}
				}
				else if(!(aux->der == NULL)){
					aux_d = aux->der->info;
					v_d = aux->der->i;
					if(aux_d > info_aux){
						aux->info = aux_d;
						aux->i = v_d;
						aux->der->info = info_aux;
						aux->der->i = v;
					}
				}
				else{
					aux_i = aux->izq->info;
					v_i = aux->izq->i;
					if(aux_i > info_aux){
						aux->info = aux_i;
						aux->i = v_i;
						aux->izq->info = info_aux;
						aux->izq->i = v;
					}
				}
			}
		}
	}
	return 0;
}

int generarArbol(ARBOL *A, int arreglo[], int n){
	int i, j, bin[128];
	ARBOL aux;
	for(i = 0; i < n; i++){
		NODO *pnodo;
		
		if((pnodo = (NODO*)malloc(sizeof(NODO))) == NULL){
			int mierr = errno;
			//printf("Error al generar espacio de memoria: %d, <<%s>>.\n", mierr, strerror(mierr));
			return -2;
		}
		
		pnodo->der = pnodo->izq = NULL;
		pnodo->info = arreglo[i];
		pnodo->i = i;
		
		if(i == 0){
			*A = pnodo;
		}
		else{
			aux = *A;
			conversorBinario(i + 1, bin);
			j = 1;
			while(bin[j] != -1){
				if(bin[j] == 1){
					if(aux->der == NULL) aux->der = pnodo;
					else aux = aux->der;
				}
				else if(bin[j] == 0){
					if(aux->izq == NULL) aux->izq = pnodo;
					else aux = aux->izq;
				}
				j++;
			}
		}
	}
	return 0;
}

int conversorBinario(int num, int bin[128]){
	int i = 0, j, a[128];
	
	while (num > 0){
		a[i] = num % 2;
		i = i + 1;
		num = num / 2;
	}
	
	for (i--, j = 0; i >= 0; i--, j++){
		bin[j] = a[i];
	}
	for(; j < 128; j++){
		bin[j] = -1;
	}
	return 0;
}

/*------------------------------------------------------------*/

int ordenamientoQuicksort(int arreglo[], int l, int u, Pantalla *P, int n){
	int i, piv, c_d, c_i;
	//el pivote se toma por defecto en l
	
	if(u <= l) return 0;
	else if(u == l + 1){
		if(arreglo[u] < arreglo[l]){
			piv = arreglo[u];
			arreglo[u] = arreglo[l];
			arreglo[l] = piv;
		}
	}
	else{
		int der[u - l + 1], izq[u - l + 1];
		c_i = c_d = 0;
		piv = arreglo[l];
		for(i = l + 1; i <= u; i++){
			if(arreglo[i] < piv){
				izq[c_i] = arreglo[i];
				c_i++;
			}
			else{
				der[c_d] = arreglo[i];
				c_d++;
			}
		}
		c_i--;
		c_d--;
		
		for(i = l; i <= l + c_i; i++){
			arreglo[i] = izq[i - l];
			generaPantalla(P, arreglo, n);
			system("clear");
			printf("\nOrdenamiento Quicksort:\n");
			imprimePantalla(*P);
			sleep_ms(300);//50
		}
		arreglo[i] = piv;
		generaPantalla(P, arreglo, n);
		system("clear");
		printf("\nOrdenamiento Quicksort:\n");
		imprimePantalla(*P);
		sleep_ms(300);//50
		for(i = 0; i <= c_d; i++){
			arreglo[l + c_i + 2 + i] = der[i];
			generaPantalla(P, arreglo, n);
			system("clear");
			printf("\nOrdenamiento Quicksort:\n");
			imprimePantalla(*P);
			sleep_ms(300);//50
		}
		ordenamientoQuicksort(arreglo, l, l + c_i, P, n);
		ordenamientoQuicksort(arreglo, l + c_i + 2, u, P, n);
	}
	return 0;
}

int ordenamientoMergesort(int arreglo[], int l, int u, Pantalla *P, int n){
	int i, j, aux, cont, array_aux[u - l + 1];
	
	if(u <= l) return 0;
	else if(u == l + 1){
		if(arreglo[u] < arreglo[l]){
			aux = arreglo[l];
			arreglo[l] = arreglo[u];
			arreglo[u] = aux;
		}
	}
	else{
		aux = l + (u - l)/2;
		ordenamientoMergesort(arreglo, l, aux, P, n);
		ordenamientoMergesort(arreglo, aux + 1, u, P, n);
		i = l;
		cont = 0;
		j = aux + 1;
		while(i <= aux || j <= u){
			if(i > aux){
				array_aux[cont] = arreglo[j];
				cont++;
				j++;
			}
			else if(j > u){
				array_aux[cont] = arreglo[i];
				cont++;
				i++;
			}
			else{
				if(arreglo[j] < arreglo[i]){
					array_aux[cont] = arreglo[j];
					cont++;
					j++;
				}
				else{
					array_aux[cont] = arreglo[i];
					cont++;
					i++;
				}
			}
		}
		for(i = l; i <= u; i++){
			arreglo[i] = array_aux[i - l];
			generaPantalla(P, arreglo, n);
			system("clear");
			printf("\nOrdenamiento Mergesort:\n");
			imprimePantalla(*P);
			sleep_ms(40); //40
		}
	}
}

int generaPantalla(Pantalla *P, int arreglo[], int n){
	int i, j, max;
	(*P).n = n;
	
	max = arreglo[0];
	
	for(i = 0; i < n; i++){
		if(max < arreglo[i]) max = arreglo[i];
	}
	
	(*P).m = max;
	
	for(i = 0; i < max; i++){
		for(j = 0; j < n; j++){
			if(i + 1 <= arreglo[j]) (*P).p[max - i - 1][j] = '#';
			else (*P).p[max - i - 1][j] = ' ';
		}
		(*P).p[max - i - 1][j] = '\n';
	}
	
	(*P).n++;
	
	return 0;
}

int imprimePantalla(Pantalla P){
	int i, j;
	for(i = 0; i < P.m; i++){
		for(j = 0; j < P.n; j++){
			printf("%c",P.p[i][j]);
		}
	}
	return 0;
}

int cambiaColumnasPantalla(Pantalla *P, int i, int j){
	int k;
	char aux;
	for(k = 0; k < (*P).m; k++){
		aux = (*P).p[k][i];
		(*P).p[k][i] = (*P).p[k][j];
		(*P).p[k][j] = aux;
	}
	return 0;
}

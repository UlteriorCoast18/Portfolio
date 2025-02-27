/*

Programa de Alvarado Cristo Daniel

*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <malloc.h>
#include <string.h>
#include <errno.h>

#define N	30

typedef struct _tablero_{
	char tabla[N][N];
	int valor[N][N];
}TABLERO;

typedef struct _nodo_{
	int arista, i_ant, j_ant; //identificador del nodo
}NODO;

typedef struct _MAdy_{
	NODO **ent;
	int n;
}MAdy;

int generadorTablero(TABLERO *tablero);
int escribirTablero(TABLERO tablero);
int generarInicioFinal(TABLERO *tablero, int *ini_i, int *ini_j, int *fin_i, int *fin_j);
int conectaNodos(MAdy *M, TABLERO tablero);
MAdy generarAdy(TABLERO *tablero);
int obtenerCamino(MAdy Ady, int i_0, int j_0, int i_f, int j_f, TABLERO *tablero);
int siendoProcesado(int j, NODO procesando[], int n);
int liberaEspacio(MAdy *Ady);

int main(int argc, char *argv[]) {
	TABLERO tablero;
	MAdy Ady;
	int inicio_i, inicio_j, fin_i, fin_j;
	
	srand(time(NULL));
	
	generadorTablero(&tablero);
	
	generarInicioFinal(&tablero, &inicio_i, &inicio_j, &fin_i, &fin_j);
	
	escribirTablero(tablero);
	
	Ady = generarAdy(&tablero);
	
	conectaNodos(&Ady, tablero);
	
	if(obtenerCamino(Ady, inicio_i, inicio_j, fin_i, fin_j, &tablero)) escribirTablero(tablero);
	
	liberaEspacio(&Ady);
	
	printf("\nFin del programa.\n");
	return 0;
}

int generadorTablero(TABLERO *tablero){
	int i, j;
	for(i = 0; i < N; i++){
		for(j = 0; j < N; j++){
			if(rand()%3) (*tablero).tabla[i][j] = ' ';
			else (*tablero).tabla[i][j] = 'M'; //M
			(*tablero).valor[i][j] = 0;
		}
	}
	return 0;
}

int escribirTablero(TABLERO tablero){
	int i, j;
	for(i = -1; i < N + 1; i++){
		for(j = -1; j < N + 1; j++){
			if(i == -1 || i == N) printf("-");
			else if(j == -1 || j == N) printf("|");
			else printf("%c", tablero.tabla[i][j]);	
		}
		printf("\n");
	}
	return 0;
}

int generarInicioFinal(TABLERO *tablero, int *ini_i, int *ini_j, int *fin_i, int *fin_j){
	int i, j, i_0, j_0, aux_2, aux_1;
	
	aux_1 = rand()%2;
	aux_2 = rand()%2;
	if(aux_1){
		if(aux_2){
			i = 0;
			i_0 = N-1;
		}
		else{
			i = N-1;
			i_0 = 0;
		}
		j = rand()%N;
		j_0 = rand()%N;
	}
	else{
		if(aux_2){
			j = 0;
			j_0 = N-1;
		}
		else{
			j = N-1;
			j_0 = 0;
		}
		i = rand()%N;
		i_0 = rand()%N;
	}
	
	*ini_i = i_0;
	*ini_j = j_0;
	*fin_i = i;
	*fin_j = j;
	
	(*tablero).tabla[i_0][j_0] = 'E';
	(*tablero).tabla[i][j] = 'S';
	
	return 0;
}

MAdy generarAdy(TABLERO *tablero){
	int cont = 0, i, j, ide = 1;
	MAdy res;
	
	for(i = 0; i < N; i++){
		for(j = 0; j < N; j++){
			if((*tablero).tabla[i][j] != 'M'){
				cont++;
				(*tablero).valor[i][j] = cont;
			} //M
		}
	}
	
	res.n = cont;
	
	if((res.ent = (NODO**)malloc(cont*sizeof(NODO*))) == NULL){
		int mierr = errno;
		printf("\nError al crear espacio de memoria: %d <<%s>>\n", mierr, strerror(mierr));
		res.n = -1;
		return res;
	}
	
	for(i = 0; i < cont; i++){
		if((res.ent[i] = (NODO*)malloc(cont*sizeof(NODO))) == NULL){
			while(--i >= 0){
				free(res.ent[i]);
				res.ent[i] = NULL;
			}
			free(res.ent);
			res.ent = NULL;
			res.n = -1;
			int mierr = errno;
			printf("\nError al crear espacio de memoria: %d <<%s>>\n", mierr, strerror(mierr));
			return res;
		}
		for(j = 0; j < cont; j++){
			res.ent[i][j].arista = 0;
			res.ent[i][j].i_ant = 0;
			res.ent[i][j].j_ant = 0;
			ide++;
		}
	}
	return res;
}

int conectaNodos(MAdy *M, TABLERO tablero){
	int i, j, origen, dest;
	
	for(i = 0; i < N; i++){
		for(j = 0; j < N; j++){
			if(tablero.valor[i][j] != 0){
				//se procede a hacer las conexiones pertinentes
				origen = tablero.valor[i][j] - 1;
				//4 conexiones posibles alrededor de una celda
				if(i - 1 >= 0){
					if(tablero.valor[i - 1][j] != 0){
						dest = tablero.valor[i - 1][j] - 1;
						(*M).ent[origen][dest].arista = 1;
						(*M).ent[origen][dest].i_ant = i;
						(*M).ent[origen][dest].j_ant = j;
					}
				}
				if(i + 1 < N){
					if(tablero.valor[i + 1][j] != 0){
						dest = tablero.valor[i + 1][j] - 1;
						(*M).ent[origen][dest].arista = 1;
						(*M).ent[origen][dest].i_ant = i;
						(*M).ent[origen][dest].j_ant = j;
					}
				}
				if(j - 1 >= 0){
					if(tablero.valor[i][j - 1] != 0){
						dest = tablero.valor[i][j - 1] - 1;
						(*M).ent[origen][dest].arista = 1;
						(*M).ent[origen][dest].i_ant = i;
						(*M).ent[origen][dest].j_ant = j;
					}
				}
				if(j + 1 < N){
					if(tablero.valor[i][j + 1] != 0){
						dest = tablero.valor[i][j + 1] - 1;
						(*M).ent[origen][dest].arista = 1;
						(*M).ent[origen][dest].i_ant = i;
						(*M).ent[origen][dest].j_ant = j;
					}
				}
			}
		}
	}
	
	return 0;
}

int obtenerCamino(MAdy Ady, int i_0, int j_0, int i_f, int j_f, TABLERO *tablero){
	NODO procesando[Ady.n - 1], nodo_aux, valores[Ady.n];
	int i, j, r_i, r_f, c_procesando = 0, c_procesado = 0, fin = 0, arista;
	
	r_i = (*tablero).valor[i_0][j_0] - 1;
	r_f = (*tablero).valor[i_f][j_f] - 1;
	
	for(i = 0; i < Ady.n - 1; i++){
		procesando[i].arista = -1;
		procesando[i].i_ant = -1;
		procesando[i].j_ant = -1;
	}
	
	for(j = 0; j < Ady.n; j++){
		if(j != r_i){
			if(Ady.ent[r_i][j].arista > 0){
				//se añade esta arista a procesando
				procesando[c_procesando] = Ady.ent[r_i][j];
				procesando[c_procesando].arista = j; //esto me guarda la coordenada para la matriz de adyacencia
				valores[j] = procesando[c_procesando];
				if(j == r_f){
					printf("\nSe encontro el camino mas corto para ir de E a S\n\n");
					fin = 1;
					break;
				}
				c_procesando++;
			}
			else{
				valores[j].arista = 0;
				valores[j].i_ant = -1;
				valores[j].j_ant = -1;
			}
		}
	}
	
	while(c_procesando != c_procesado && !fin){
		nodo_aux = procesando[c_procesado];
		for(j = 0; j < Ady.n; j++){
			if(Ady.ent[nodo_aux.arista][j].arista > 0){ //hay conexion con otro nodo
				if(!siendoProcesado(j, procesando, Ady.n - 1) && j != r_i){ //necesitamos ver si este nodo está dentro de la lista que ya teníamos
					procesando[c_procesando] = Ady.ent[nodo_aux.arista][j];
					procesando[c_procesando].arista = j; //esto me guarda la coordenada para la matriz de adyacencia
					valores[j] = procesando[c_procesando];
					if(r_f == j){
						printf("\nSe encontro el camino mas corto para ir de E a S\n\n");
						fin = 1;
						break;
					}
					c_procesando++;
				}
			}
		}
		c_procesado++;
	}
	
	if(fin == 0){
		printf("\nNo hay camino que una a E con S\n");
		return 0;
	}
	
	arista = r_f;
	i = valores[r_f].i_ant;
	j = valores[r_f].j_ant;
	
	while(i != i_0 || j != j_0){
		(*tablero).tabla[i][j] = 'O';
		arista = (*tablero).valor[i][j] - 1;
		i = valores[arista].i_ant;
		j = valores[arista].j_ant;
	}
	return 1;
}

int siendoProcesado(int j, NODO procesando[], int n){
	int i;
	for(i = 0; i < n; i++){
		if(procesando[i].arista == -1) return 0;
		else if(j == procesando[i].arista) return 1;
	}
	return 0;
}

int liberaEspacio(MAdy *Ady){
	int i;
	
	for (i = 0; i < Ady->n; i++){
		free(Ady->ent[i]);
		Ady->ent[i] = NULL;
	}
	free(Ady->ent);
	Ady->ent = NULL;
	Ady->n = 0;
	
	return 0;
}
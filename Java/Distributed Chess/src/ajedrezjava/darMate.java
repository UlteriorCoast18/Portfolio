package ajedrezjava;

import java.io.Serializable;

public class darMate implements Serializable{
    ejecuteAll eA = new ejecuteAll();
    int death = 0;
    public boolean isMate(String[][] tablero, String turno){
        String[][] realTablero = tablero;
        boolean mate = false;
        String atacado = obtenerColor(turno);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (atacado.equals("B")) {
                    if (tablero[i][j].equals("PB")) {
                        Peon(tablero,i,j,turno);
                    }
                    if (tablero[i][j].equals("CB")) {
                        Caballo(tablero,i,j,turno);
                    }
                    if (tablero[i][j].equals("AB")) {
                        Alfil(tablero,i,j,turno);
                    }
                    if (tablero[i][j].equals("TB")) {
                        Torre(tablero,i,j,turno);
                    }
                    if (tablero[i][j].equals("DB")) {
                        Dama(tablero,i,j,turno);
                    }
                    if (tablero[i][j].equals("RB")) {
                        Rey(tablero,i,j,atacado,turno);
                    }
                }
                else if (atacado.equals("N")) {
                    if (tablero[i][j].equals("PN")) {
                        Peon(tablero,i,j,turno);
                    }
                    if (tablero[i][j].equals("CN")) {
                        Caballo(tablero,i,j,turno);
                    }
                    if (tablero[i][j].equals("AN")) {
                        Alfil(tablero,i,j,turno);
                    }
                    if (tablero[i][j].equals("TM")) {
                        Torre(tablero,i,j,turno);
                    }
                    if (tablero[i][j].equals("DN")) {
                        Dama(tablero,i,j,turno);
                    }
                    if (tablero[i][j].equals("RN")) {
                        Rey(tablero,i,j,atacado,turno);
                    }
                }
            }
        }
        tablero = realTablero;   
        if (death > 0) {
            mate = false;
        }
        if (death == 0) {
            mate = true;
        }
        death = 0;
        return mate;
    }
    private void revisarfrente(String [][]pieza,int posX, int posY, int j, String enemigo, String color, String turn){
        String[][] move = pieza;
        int casilla = posX;
        String CO = obtenerColor(turn);
        boolean amenaza = eA.retornarPosibilidades(pieza, turn);
        if((posX>0&&posX<7)&&(posY>0&&posY<7)){
            for (int i = -1; i <2; i++) {
                if(i==0){
                    if(pieza[posX+j][posY+i].equals("")){
                            String oldEnemigo = move[posX+j][posY+i];
                            move[posX][posY] = "";
                            move[posX+j][posY+i] = "P"+CO;
                            amenaza = eA.retornarPosibilidades(move, turn);
                        if (amenaza) {
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                        else{
                            death++;
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                    }
                    if (pieza[posX+j][posY+i].equals("") && posX+(2*j) >= 0 && posY+i >= 0 && posX+(2*j) < 8 && posY+i < 8) {
                        if (casilla == 1 && color.equals("N") && pieza[posX+(2*j)][posY+i].equals("")) {
                                String oldEnemigo = move[posX+j][posY+i];
                                move[posX][posY] = "";
                                move[posX+(2*j)][posY+i] = "P"+CO;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                        }
                        else if (casilla == 6 && color.equals("B") && pieza[posX+(2*j)][posY+i].equals("")) {
                                String oldEnemigo = move[posX+j][posY+i];
                                move[posX][posY] = "";
                                move[posX+(2*j)][posY+i] = "P"+CO;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                        }
                    }
                }
                if(i==-1){
                    if(pieza[posX+j][posY+i].length()>0&&
                            pieza[posX+j][posY+i].substring(1, 2).toUpperCase().equals(enemigo)){
                            String oldEnemigo = move[posX+j][posY+i];
                            move[posX][posY] = "";
                            move[posX+j][posY+i] = "P"+CO;
                            amenaza = eA.retornarPosibilidades(move, turn);
                        if (amenaza) {
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                        else{
                            death++;
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                    }
                }
                if(i==1){
                    if(pieza[posX+j][posY+i].length()>0&&
                            pieza[posX+j][posY+i].substring(1, 2).toUpperCase().equals(enemigo)){
                            String oldEnemigo = move[posX+j][posY+i];
                            move[posX][posY] = "";
                            move[posX+j][posY+i] = "P"+CO;
                            amenaza = eA.retornarPosibilidades(move, turn);
                        if (amenaza) {
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                        else{
                            death++;
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                    }
                }
            }
        }
        if((posX>0&&posX<7)&&(posY==0)){
            for (int i = 0; i < 2; i++) {
                if(i==0){
                    if(pieza[posX+j][posY+i].equals("")){
                            String oldEnemigo = move[posX+j][posY+i];
                            move[posX][posY] = "";
                            move[posX+j][posY+i] = "P"+CO;
                            amenaza = eA.retornarPosibilidades(move, turn);
                        if (amenaza) {
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                        else{
                            death++;
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                    }
                    if (pieza[posX+j][posY+i].equals("") && posX+(2*j) >= 0 && posY+i >= 0 && posX+(2*j) < 8 && posY+i < 8) {
                        if (casilla == 1 && color.equals("N") && pieza[posX+(2*j)][posY+i].equals("")) {
                            String oldEnemigo = move[posX+j][posY+i];
                                move[posX][posY] = "";
                                move[posX+(2*j)][posY+i] = "P"+CO;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                        }
                        else if (casilla == 6 && color.equals("B") && pieza[posX+(2*j)][posY+i].equals("")) {
                            String oldEnemigo = move[posX+j][posY+i];
                                move[posX][posY] = "";
                                move[posX+(2*j)][posY+i] = "P"+CO;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                        }
                    }
                }
                if(i==1){
                    if(pieza[posX+j][posY+i].length()>0&&
                            pieza[posX+j][posY+i].substring(1, 2).toUpperCase().equals(enemigo)){
                        String oldEnemigo = move[posX+j][posY+i];
                            move[posX][posY] = "";
                            move[posX+j][posY+i] = "P"+CO;
                            amenaza = eA.retornarPosibilidades(move, turn);
                        if (amenaza) {
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                        else{
                            death++;
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                    }
                }
            }
        }
        if((posX>0&&posX<7)&&(posY==7)){
            for (int i = -1; i <1; i++) {
                if(i==-1){
                    if(pieza[posX+j][posY+i].length()>0&&
                            pieza[posX+j][posY+i].substring(1, 2).toUpperCase().equals(enemigo)){
                        String oldEnemigo = move[posX+j][posY+i];
                            move[posX][posY] = "";
                            move[posX+j][posY+i] = "P"+CO;
                            amenaza = eA.retornarPosibilidades(move, turn);
                        if (amenaza) {
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                        else{
                            death++;
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                    }
                }
                if(i==0){
                    if(pieza[posX+j][posY+i].equals("")){
                        String oldEnemigo = move[posX+j][posY+i];
                            move[posX][posY] = "";
                            move[posX+j][posY+i] = "P"+CO;
                            amenaza = eA.retornarPosibilidades(move, turn);
                        if (amenaza) {
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                        else{
                            death++;
                            move[posX][posY] = "P"+CO;
                            move[posX+j][posY+i] = oldEnemigo;
                        }
                    }
                    if (pieza[posX+j][posY+i].equals("") && posX+(2*j) >= 0 && posY+i >= 0 && posX+(2*j) < 8 && posY+i < 8) {
                        if (casilla == 1 && color.equals("N") && pieza[posX+(2*j)][posY+i].equals("")) {
                            String oldEnemigo = move[posX+j][posY+i];
                                move[posX][posY] = "";
                                move[posX+(2*j)][posY+i] = "P"+CO;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                        }
                        else if (casilla == 6 && color.equals("B") && pieza[posX+(2*j)][posY+i].equals("")) {
                            String oldEnemigo = move[posX+j][posY+i];
                                move[posX][posY] = "";
                                move[posX+(2*j)][posY+i] = "P"+CO;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = "P"+CO;
                                move[posX+(2*j)][posY+i] = oldEnemigo;
                            }
                        }
                    }
                }
            }
        }
    }
    private void pintarlineas(String [][]pieza, int cambiarX, int posX, int cambiarY, int posY, String amigo, String enemigo, String turn){
        String[][] move = pieza;
        boolean amenaza = eA.retornarPosibilidades(pieza, turn);
        if(posX>-1 && posX<8){
            for (cambiarX = posX-1; cambiarX>-1;cambiarX--) {
                if(pieza[cambiarX][posY].equals("")){
                                String oldEnemigo = move[cambiarX][posY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[cambiarX][posY] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[cambiarX][posY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[cambiarX][posY] = oldEnemigo;
                            }
                }
                else if(pieza[cambiarX][posY].length()>0 && 
                        pieza[cambiarX][posY].substring(1,2).toUpperCase().equals(amigo)){
                    break;
                }
                else if(pieza[cambiarX][posY].length()>0 && 
                        pieza[cambiarX][posY].substring(1,2).toUpperCase().equals(enemigo)){
                        String oldEnemigo = move[cambiarX][posY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[cambiarX][posY] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[cambiarX][posY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[cambiarX][posY] = oldEnemigo;
                            }
                    break;
                }
            }
            for (cambiarX = posX+1; cambiarX<8;cambiarX++) {
                if(pieza[cambiarX][posY].equals("")){
                        String oldEnemigo = move[cambiarX][posY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[cambiarX][posY] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[cambiarX][posY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[cambiarX][posY] = oldEnemigo;
                            }
                }
                else if(pieza[cambiarX][posY].length()>0 && 
                        pieza[cambiarX][posY].substring(1,2).toUpperCase().equals(amigo)){
                    break;
                }
                else if(pieza[cambiarX][posY].length()>0 && 
                        pieza[cambiarX][posY].substring(1,2).toUpperCase().equals(enemigo)){
                        String oldEnemigo = move[cambiarX][posY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[cambiarX][posY] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[cambiarX][posY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[cambiarX][posY] = oldEnemigo;
                            }
                    break;
                }
            }
        }
        if(posY>-1 && posY<8){
            for (cambiarY = posY-1; cambiarY>-1;cambiarY--) {
                if(pieza[posX][cambiarY].equals("")){
                        String oldEnemigo = move[posX][cambiarY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX][cambiarY] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX][cambiarY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX][cambiarY] = oldEnemigo;
                            }
                }
                else if(pieza[posX][cambiarY].length()>0 && 
                        pieza[posX][cambiarY].substring(1,2).toUpperCase().equals(amigo)){
                    break;
                }
                else if(pieza[posX][cambiarY].length()>0 && 
                        pieza[posX][cambiarY].substring(1,2).toUpperCase().equals(enemigo)){
                    String oldEnemigo = move[posX][cambiarY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX][cambiarY] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX][cambiarY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX][cambiarY] = oldEnemigo;
                            }
                    break;
                }
            }
            for (cambiarY = posY+1; cambiarY<8;cambiarY++) {
                if(pieza[posX][cambiarY].equals("")){
                    String oldEnemigo = move[posX][cambiarY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX][cambiarY] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX][cambiarY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX][cambiarY] = oldEnemigo;
                            }
                }
                else if(pieza[posX][cambiarY].length()>0 && 
                        pieza[posX][cambiarY].substring(1,2).toUpperCase().equals(amigo)){
                    break;
                }
                else if(pieza[posX][cambiarY].length()>0 && 
                        pieza[posX][cambiarY].substring(1,2).toUpperCase().equals(enemigo)){
                                String oldEnemigo = move[posX][cambiarY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX][cambiarY] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX][cambiarY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX][cambiarY] = oldEnemigo;
                            }
                    break;
                }
            }
        }
    }
    private void pintardiagonales(String[][]pieza, int posX, int posY,String enemigo, String turn){
        int i;
        int j;
        int k;
        int l;
        String[][] move = pieza;
        boolean amenaza = eA.retornarPosibilidades(pieza, turn);
        for (i = 1; (posX+i<8)&&(posY+i<8); i++) {
            if(pieza[posX+i][posY+i].equals("")){
                String oldEnemigo = move[posX+i][posY+i];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+i][posY+i] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+i][posY+i] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+i][posY+i] = oldEnemigo;
                            }
            }
            else if(pieza[posX+i][posY+i].length()>0){
                if(pieza[posX+i][posY+i].substring(1, 2).toUpperCase().equals(enemigo)){
                    String oldEnemigo = move[posX+i][posY+i];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+i][posY+i] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+i][posY+i] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+i][posY+i] = oldEnemigo;
                            }
                    break;
                }
                else{
                    break;
                }
            }
        }
        for (j = 1; ((posX-j >-1)&&(posY+j<8)); j++) {
            if (pieza[posX-j][posY+j].equals("")){
                String oldEnemigo = move[posX-j][posY+j];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-j][posY+j] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-j][posY+j] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-j][posY+j] = oldEnemigo;
                            }
            }
            else if(pieza[posX-j][posY+j].length()>0){
                if(pieza[posX-j][posY+j].substring(1, 2).toUpperCase().equals(enemigo)){
                                String oldEnemigo = move[posX-j][posY+j];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-j][posY+j] = oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-j][posY+j] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-j][posY+j] = oldEnemigo;
                            }
                    break;
                }
                else{
                    break;
                }
            }       
        }
        for (k = 1; (posX-k >-1)&&(posY-k>-1); k++) {
            if(pieza[posX-k][posY-k].equals("")){
                String oldEnemigo = move[posX-k][posY-k];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-k][posY-k]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-k][posY-k] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-k][posY-k] = oldEnemigo;
                            }
            }
            else if((pieza[posX-k][posY-k].length()>0)&&
                    pieza[posX-k][posY-k].substring(1, 2).toUpperCase().equals(enemigo)){
                String oldEnemigo = move[posX-k][posY-k];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-k][posY-k]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-k][posY-k] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-k][posY-k] = oldEnemigo;
                            }
                break;
            }
            else{
                break;
            }
        }
        for (l = 1; (posX+l<8)&&(posY-l>-1); l++) {
            if(pieza[posX+l][posY-l].equals("")){
                String oldEnemigo = move[posX+l][posY-l];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+l][posY-l]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+l][posY-l] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+l][posY-l] = oldEnemigo;
                            }
            }
            else if((pieza[posX+l][posY-l].length()>0)&&
                    pieza[posX+l][posY-l].substring(1, 2).toUpperCase().equals(enemigo)){
                String oldEnemigo = move[posX+l][posY-l];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+l][posY-l]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+l][posY-l] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+l][posY-l] = oldEnemigo;
                            }
                break;
            }
            else{
                break;
            }
        }
    }
    private void pintarR(String[][]pieza, int posX, int posY,String amigo, String turn){
        String[][] move = pieza;
        boolean amenaza = eA.retornarPosibilidades(pieza, turn);   
        if (posX-1 >= 0 && posY-1 >= 0 && posX-1 < 8 && posY-1 < 8) {
            if (pieza[posX-1][posY-1].equals("")) {
                String oldEnemigo = move[posX-1][posY-1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-1][posY-1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY-1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY-1] = oldEnemigo;
                            }
            }
            else if (!pieza[posX-1][posY-1].substring(1,2).toUpperCase().equals(amigo)) {
                String oldEnemigo = move[posX-1][posY-1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-1][posY-1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY-1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY-1] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX-1 >= 0 && posY >= 0 && posX-1 < 8 && posY < 8) {
            if (pieza[posX-1][posY].equals("")) {
                String oldEnemigo = move[posX-1][posY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-1][posY]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY] = oldEnemigo;
                            }
            }
            else if (!pieza[posX-1][posY].substring(1,2).toUpperCase().equals(amigo)) {
                String oldEnemigo = move[posX-1][posY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-1][posY]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX-1 >= 0 && posY+1 >= 0 && posX-1 < 8 && posY+1 < 8) {
            if (pieza[posX-1][posY+1].equals("")) {
                String oldEnemigo = move[posX-1][posY+1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-1][posY+1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY+1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY+1] = oldEnemigo;
                            }
            }
            else if (!pieza[posX-1][posY+1].substring(1,2).toUpperCase().equals(amigo)) {
                String oldEnemigo = move[posX-1][posY+1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-1][posY+1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY+1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY+1] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX >= 0 && posY-1 >= 0 && posX < 8 && posY-1 < 8) {
            if (pieza[posX][posY-1].equals("")) {
                String oldEnemigo = move[posX][posY-1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX][posY-1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX][posY-1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX][posY-1] = oldEnemigo;
                            }
            }
            else if (!pieza[posX][posY-1].substring(1,2).toUpperCase().equals(amigo)) {
                String oldEnemigo = move[posX][posY-1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX][posY-1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX][posY-1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX][posY-1] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX >= 0 && posY+1 >= 0 && posX < 8 && posY+1 < 8) {
            if (pieza[posX][posY+1].equals("")) {
                String oldEnemigo = move[posX][posY+1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX][posY+1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX][posY+1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX][posY+1] = oldEnemigo;
                            }
            }
            else if (!pieza[posX][posY+1].substring(1,2).toUpperCase().equals(amigo)) {
                String oldEnemigo = move[posX][posY+1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX][posY+1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX][posY+1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX][posY+1] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX+1 >= 0 && posY-1 >= 0 && posX+1 < 8 && posY-1 < 8) {
            if (pieza[posX+1][posY-1].equals("")) {
                String oldEnemigo = move[posX+1][posY-1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+1][posY-1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY-1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY-1] = oldEnemigo;
                            }
            }
            else if (!pieza[posX+1][posY-1].substring(1,2).toUpperCase().equals(amigo)) {
                String oldEnemigo = move[posX+1][posY-1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+1][posY-1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY-1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY-1] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX+1 >= 0 && posY >= 0 && posX+1 < 8 && posY < 8) {
            if (pieza[posX+1][posY].equals("")) {
                String oldEnemigo = move[posX+1][posY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+1][posY]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY] = oldEnemigo;
                            }
            }
            else if (!pieza[posX+1][posY].substring(1,2).toUpperCase().equals(amigo)) {
                String oldEnemigo = move[posX+1][posY];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+1][posY]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX+1 >= 0 && posY+1 >= 0 && posX+1 < 8 && posY+1 < 8) {
            if (pieza[posX+1][posY+1].equals("")) {
                String oldEnemigo = move[posX+1][posY+1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+1][posY+1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY+1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY+1] = oldEnemigo;
                            }
            }
            else if (!pieza[posX+1][posY+1].substring(1,2).toUpperCase().equals(amigo)) {
                String oldEnemigo = move[posX+1][posY+1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+1][posY+1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY+1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY+1] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (amigo.equals("B")) {
            if (posX == 7 && posY == 4 && pieza[7][5].equals("") && pieza[7][6].equals("") && pieza[7][7].equals("TB")) {
                String oldEnemigo = move[7][6];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[7][6]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[7][6] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[7][6] = oldEnemigo;
                            }
            }
            if (posX == 7 && posY == 4 && pieza[7][3].equals("") && pieza[7][2].equals("") && pieza[7][1].equals("") && pieza[7][0].equals("TB")) {
                String oldEnemigo = move[7][2];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[7][2]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[7][2] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[7][2] = oldEnemigo;
                            }
            }
        }
        if (amigo.equals("N" )) {
            if (posX == 0 && posY == 4 && pieza[0][5].equals("") && pieza[0][6].equals("") && pieza[0][7].equals("TN")) {
                String oldEnemigo = move[0][6];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[0][6]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[0][6] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[0][6] = oldEnemigo;
                            }
            }
            if (posX == 0 && posY == 4 && pieza[0][3].equals("") && pieza[0][2].equals("") && pieza[0][1].equals("") && pieza[0][0].equals("TN")) {
                String oldEnemigo = move[0][2];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[0][2]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[0][2] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[0][2] = oldEnemigo;
                            }
            }
        }
    }
    private void pintarL(String[][]pieza, int posX, int posY,String enemigo, String turn){
        String[][] move = pieza;
        boolean amenaza = eA.retornarPosibilidades(pieza, turn);
        if (posX-2 >= 0 && posY+1 >= 0 && posX-2 < 8 && posY+1 < 8) {
            if (pieza[posX-2][posY+1].equals("")) {
                String oldEnemigo = move[posX-2][posY+1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-2][posY+1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-2][posY+1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-2][posY+1] = oldEnemigo;
                            }
            }
            else if (pieza[posX-2][posY+1].substring(1,2).toUpperCase().equals(enemigo)) {
                String oldEnemigo = move[posX-2][posY+1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-2][posY+1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-2][posY+1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-2][posY+1] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX-2 >= 0 && posY-1 >= 0 && posX-2 < 8 && posY-1 < 8) {
            if (pieza[posX-2][posY-1].equals("")) {
                String oldEnemigo = move[posX-2][posY-1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-2][posY-1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-2][posY-1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-2][posY-1] = oldEnemigo;
                            }
            }
            else if (pieza[posX-2][posY-1].substring(1,2).toUpperCase().equals(enemigo)) {
                String oldEnemigo = move[posX-2][posY-1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-2][posY-1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-2][posY-1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-2][posY-1] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX-1 >= 0 && posY+2 >= 0 && posX-1 < 8 && posY+2 < 8) {
            if (pieza[posX-1][posY+2].equals("")) {
                String oldEnemigo = move[posX-1][posY+2];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-1][posY+2]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY+2] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY+2] = oldEnemigo;
                            }
            }
            else if (pieza[posX-1][posY+2].substring(1,2).toUpperCase().equals(enemigo)) {
                String oldEnemigo = move[posX-1][posY+2];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-1][posY+2]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY+2] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY+2] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX-1 >= 0 && posY-2 >= 0 && posX-1 < 8 && posY-2 < 8) {
            if (pieza[posX-1][posY-2].equals("")) {
                String oldEnemigo = move[posX-1][posY-2];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-1][posY-2]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY-2] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY-2] = oldEnemigo;
                            }
            }
            else if (pieza[posX-1][posY-2].substring(1,2).toUpperCase().equals(enemigo)) {
                String oldEnemigo = move[posX-1][posY-2];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX-1][posY-2]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY-2] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX-1][posY-2] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX+2 >= 0 && posY+1 >= 0 && posX+2 < 8 && posY+1 < 8) {
            if (pieza[posX+2][posY+1].equals("")) {
                String oldEnemigo = move[posX+2][posY+1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+2][posY+1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+2][posY+1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+2][posY+1] = oldEnemigo;
                            }
            }
            else if (pieza[posX+2][posY+1].substring(1,2).toUpperCase().equals(enemigo)) {
                String oldEnemigo = move[posX+2][posY+1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+2][posY+1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+2][posY+1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+2][posY+1] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX+2 >= 0 && posY-1 >= 0 && posX+2 < 8 && posY-1 < 8) {
            if (pieza[posX+2][posY-1].equals("")) {
                String oldEnemigo = move[posX+2][posY-1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+2][posY-1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+2][posY-1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+2][posY-1] = oldEnemigo;
                            }
            }
            else if (pieza[posX+2][posY-1].substring(1,2).toUpperCase().equals(enemigo)) {
                String oldEnemigo = move[posX+2][posY-1];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+2][posY-1]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+2][posY-1] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+2][posY-1] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX+1 >= 0 && posY+2 >= 0 && posX+1 < 8 && posY+2 < 8) {
            if (pieza[posX+1][posY+2].equals("")) {
                String oldEnemigo = move[posX+1][posY+2];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+1][posY+2]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY+2] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY+2] = oldEnemigo;
                            }
            }
            else if (pieza[posX+1][posY+2].substring(1,2).toUpperCase().equals(enemigo)) {
                String oldEnemigo = move[posX+1][posY+2];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+1][posY+2]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY+2] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY+2] = oldEnemigo;
                            }
            }
            else{
            }
        }
        if (posX+1 >= 0 && posY-2 >= 0 && posX+1 < 8 && posY-2 < 8) {
            if (pieza[posX+1][posY-2].equals("")) {    
                String oldEnemigo = move[posX+1][posY-2];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+1][posY-2]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY-2] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY-2] = oldEnemigo;
                            }
            }
            else if (pieza[posX+1][posY-2].substring(1,2).toUpperCase().equals(enemigo)) {
                                String oldEnemigo = move[posX+1][posY-2];
                                String oldPieza = move[posX][posY];
                                move[posX][posY] = "";
                                move[posX+1][posY-2]= oldPieza;
                                amenaza = eA.retornarPosibilidades(move, turn);
                            if (amenaza) {
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY-2] = oldEnemigo;
                            }
                            else{
                                death++;
                                move[posX][posY] = oldPieza;
                                move[posX+1][posY-2] = oldEnemigo;
                            }
            }
            else{
            }
        }
    }
    public void Peon(String [][]pieza, int posX, int posY, String turn){
        int j;
        String enemigo;
        if(pieza[posX][posY].substring(1, 2).toUpperCase().equals("B")){
            j = -1;
            enemigo = "N";
            revisarfrente(pieza, posX, posY,j,enemigo,"B",turn);
        }
        else{
            j = 1;
            enemigo = "B";
            revisarfrente(pieza, posX, posY,j,enemigo,"N",turn);
        }
    }
    public void Torre(String[][]pieza, int posX, int posY, String turn){
        int cambiarX;
        int cambiarY;
        if(pieza[posX][posY].substring(1, 2).toUpperCase().equals("N")){
            cambiarX = 0;
            cambiarY = 0;
            pintarlineas(pieza,cambiarX,posX,cambiarY,posY,"N","B",turn);
        }
        else{
            cambiarX = 7;
            cambiarY = 7;
            pintarlineas(pieza,cambiarX,posX,cambiarY,posY,"B","N",turn);
        }
    }
    public void Alfil(String [][]pieza,int posX, int posY, String turn){
        if(pieza[posX][posY].substring(1, 2).toUpperCase().equals("N")){
            pintardiagonales(pieza,posX,posY,"B",turn);
        }
        else{
            pintardiagonales(pieza,posX,posY,"N",turn);
        }
    }
    public void Caballo(String [][]pieza, int posX, int posY, String turn){
        if(pieza[posX][posY].substring(1, 2).toUpperCase().equals("N")){
            pintarL(pieza,posX,posY,"B",turn);
        }
        else{
            pintarL(pieza,posX,posY,"N",turn);
        }
    }
    public void Dama(String [][]pieza,int posX, int posY, String turn){
        int cambiarX;
        int cambiarY;
        if(pieza[posX][posY].substring(1, 2).toUpperCase().equals("N")){
            cambiarX = 0;
            cambiarY = 0;
            pintarlineas(pieza,cambiarX,posX,cambiarY,posY,"N","B",turn);
            pintardiagonales(pieza,posX,posY,"B",turn);
        }
        else{
            cambiarX = 7;
            cambiarY = 7;
            pintarlineas(pieza,cambiarX,posX,cambiarY,posY,"B","N",turn);
            pintardiagonales(pieza,posX,posY,"N",turn);
        }
    }
    public void Rey(String[][] pieza, int posX, int posY, String amigo, String turn){
        if (amigo.equals("B")) {
            pintarR(pieza, posX, posY, amigo,turn);
        }    
        else{
            pintarR(pieza, posX, posY, amigo,turn);
        }
    }
    private String obtenerColor(String turn){
        String res;
        if (turn.equals("N")) {
            res = "B";
        }
        else{
            res = "N";
        }
        return res;
    } /*
    private void ataques(int oldPosX, int oldPosY, int newPosX, int newPosY){
        String oldEnemigo = move[posX+1][posY-2];
        String oldPieza = move[posX][posY];
        move[posX][posY] = "";
        move[posX+1][posY-2]= oldPieza;
        amenaza = eA.retornarPosibilidades(move, turn);
        if (amenaza) {
        move[posX][posY] = oldPieza;
        move[posX+1][posY-2] = oldEnemigo;
        }
        else{
        death++;
        move[posX][posY] = oldPieza;
        move[posX+1][posY-2] = oldEnemigo;
        }
    }*/
}
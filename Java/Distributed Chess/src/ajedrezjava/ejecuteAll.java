package ajedrezjava;

import java.io.Serializable;

public class ejecuteAll implements Serializable{
    
    public boolean retornarPosibilidades(String[][] tablero,String turn){
        boolean amenaza = false;
        String[][] ataques = new String[8][8];
        String[] res;
        int posXR = 0;
        int posYR = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (turn.equals("B")) {
                    if (tablero[i][j].equals("PB")) {
                        res = Peon(tablero,i,j);
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                    break;
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("AB")) {
                        res = Alfil(tablero,i,j);
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("CB")) {
                        res = Caballo(tablero,i,j);
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                    break;
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("TB")) {
                        res = Torre(tablero,i,j);
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                    break;
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("DB")) {
                        res = Dama(tablero,i,j);
                        if (res.length == 0) {
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("RB")) {
                        res = Rey(tablero,i,j,"B");
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                    break;
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("RN")) {
                        posXR = i;
                        posYR = j;
                    }
                }
                else if (turn.equals("N")) {
                    if (tablero[i][j].equals("PN")) {
                        res = Peon(tablero,i,j);
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                    break;
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("AN")) {
                        res = Alfil(tablero,i,j);
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                    break;
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("CN")) {
                        res = Caballo(tablero,i,j);
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                    break;
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("TN")) {
                        res = Torre(tablero,i,j);
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                    break;
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("DN")) {
                        res = Dama(tablero,i,j);
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("RN")) {
                        res = Rey(tablero,i,j,"N");
                        if (res.length == 0) {
                            break;
                        }else{
                            for (int k = 0; k < res.length; k++) {
                                if (res[k].isEmpty()) {
                                    break;
                                }
                                else{
                                    int posX = Integer.parseInt(res[k].substring(0,1));
                                    int posY = Integer.parseInt(res[k].substring(2,3));
                                    ataques[posX][posY] = "■";
                                }
                            }    
                        }
                    }
                    if (tablero[i][j].equals("RB")) {
                        posXR = i;
                        posYR = j;
                    }
                }
            }
        }
        
        for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (ataques[k][l] != null) {
                            if (k == posXR && l == posYR) {
                                amenaza = true;
                            }
                    }
                    else{
                        ataques[k][l] = "□";
                    }
                }
        }
        return amenaza;
    }

    private String[] revisarfrente(String[][] pieza, int posX, int posY, int j, String enemigo, String color){
        String[] pos = new String[81];
        int z = 0;
        int casilla = posX;
        if((posX>0&&posX<7)&&(posY>0&&posY<7)){
            for (int i = -1; i <2; i++) {
                if(i==0){
                }
                if(i==-1){
                    if(pieza[posX+j][posY+i].equals("")){
                        pos[z] = (posX+j) + "," + (posY+i);
                        z++;
                    }
                    else if (pieza[posX+j][posY+i].length() > 0 && pieza[posX+j][posY+i].substring(1, 2).toUpperCase().equals(enemigo)) {
                        pos[z] = (posX+j) + "," + (posY+i);
                        z++;
                    }
                }
                if(i==1){
                    if(pieza[posX+j][posY+i].equals("")){
                        pos[z] = (posX+j) + "," + (posY+i);
                        z++;
                    }
                    else if (pieza[posX+j][posY+i].length() > 0 && pieza[posX+j][posY+i].substring(1, 2).toUpperCase().equals(enemigo)) {
                        pos[z] = (posX+j) + "," + (posY+i);
                        z++;
                    }
                }
            }
        }
        
        if((posX>0&&posX<7)&&(posY==0)){
            for (int i = 0; i < 2; i++) {
                if(i==0){
                }
                if(i==1){
                    if(pieza[posX+j][posY+i].equals("")){
                        pos[z] = (posX+j) + "," + (posY+i);
                        z++;
                    }
                    else if (pieza[posX+j][posY+i].length() > 0 && pieza[posX+j][posY+i].substring(1, 2).toUpperCase().equals(enemigo)) {
                        pos[z] = (posX+j) + "," + (posY+i);
                        z++;
                    }
                }
            }
        }
        
        if((posX>0&&posX<7)&&(posY==7)){
            for (int i = -1; i <1; i++) {
                if(i==-1){
                    if(pieza[posX+j][posY+i].equals("")){
                        pos[z] = (posX+j) + "," + (posY+i);
                        z++;
                    }
                    else if (pieza[posX+j][posY+i].length() > 0 && pieza[posX+j][posY+i].substring(1, 2).toUpperCase().equals(enemigo)) {
                        pos[z] = (posX+j) + "," + (posY+i);
                        z++;
                    }
                }
                if(i==0){
                }
            }
        }
        
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] != null) {
            }
            else{
                pos[i] = "";
            }
        }
        
        return pos;
    }
    private String[] pintarlineas(String [][]pieza,
            int cambiarX, int posX,
            int cambiarY, int posY,
            String amigo, String enemigo){
        String[] pos = new String[40];
        int z = 0;
        if(posX>-1 && posX<8){
            for (cambiarX = posX-1; cambiarX>-1;cambiarX--) {
                if(pieza[cambiarX][posY].equals("")){
                    pos[z] = (cambiarX) + "," + (posY);
                    z++;
                }
                else if(pieza[cambiarX][posY].length()>0 && 
                        pieza[cambiarX][posY].substring(1,2).toUpperCase().equals(amigo)){
                    break;
                }
                else if(pieza[cambiarX][posY].length()>0 && 
                        pieza[cambiarX][posY].substring(1,2).toUpperCase().equals(enemigo)){
                    pos[z] = (cambiarX) + "," + (posY);
                    z++;
                    break;
                }
            }
            for (cambiarX = posX+1; cambiarX<8;cambiarX++) {
                if(pieza[cambiarX][posY].equals("")){
                    pos[z] = (cambiarX) + "," + (posY);
                    z++;
                }
                else if(pieza[cambiarX][posY].length()>0 && 
                        pieza[cambiarX][posY].substring(1,2).toUpperCase().equals(amigo)){
                    break;
                }
                else if(pieza[cambiarX][posY].length()>0 && 
                        pieza[cambiarX][posY].substring(1,2).toUpperCase().equals(enemigo)){
                    pos[z] = (cambiarX) + "," + (posY);
                    z++;
                    break;
                }
            }
        }
        if(posY>-1 && posY<8){
            for (cambiarY = posY-1; cambiarY>-1;cambiarY--) {
                if(pieza[posX][cambiarY].equals("")){
                    pos[z] = (posX) + "," + (cambiarY);
                    z++;
                }
                else if(pieza[posX][cambiarY].length()>0 && 
                        pieza[posX][cambiarY].substring(1,2).toUpperCase().equals(amigo)){
                    break;
                }
                else if(pieza[posX][cambiarY].length()>0 && 
                        pieza[posX][cambiarY].substring(1,2).toUpperCase().equals(enemigo)){
                    pos[z] = (posX) + "," + (cambiarY);
                       z++;
                    break;
                }
            }
            for (cambiarY = posY+1; cambiarY<8;cambiarY++) {
                if(pieza[posX][cambiarY].equals("")){
                    pos[z] = (posX) + "," + (cambiarY);
                    z++;
                }
                else if(pieza[posX][cambiarY].length()>0 && 
                        pieza[posX][cambiarY].substring(1,2).toUpperCase().equals(amigo)){
                    break;
                }
                else if(pieza[posX][cambiarY].length()>0 && 
                        pieza[posX][cambiarY].substring(1,2).toUpperCase().equals(enemigo)){
                    pos[z] = (posX) + "," + (cambiarY);
                    z++;
                    break;
                }
            }
        }
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] != null) {
            }
            else{
                pos[i] = "";
            }
        }
        return pos;
    }
    private String[] pintardiagonales(String[][]pieza, 
            int posX, int posY,String enemigo){
        String[] pos = new String[40];
        int z = 0;
        int i;
        int j;
        int k;
        int l;
        
        for (i = 1; (posX+i<8)&&(posY+i<8); i++) {
            if(pieza[posX+i][posY+i].equals("")){
                pos[z] = (posX+i) + "," + (posY+i);
                z++;
            }
            else if(pieza[posX+i][posY+i].length()>0){
                if(pieza[posX+i][posY+i].substring(1, 2).toUpperCase().equals(enemigo)){
                    pos[z] = (posX+i) + "," + (posY+i);
                z++;
                    break;
                }
                else{
                    break;
                }
            }
        }
        for (j = 1; ((posX-j >-1)&&(posY+j<8)); j++) {
            if (pieza[posX-j][posY+j].equals("")){
                pos[z] = (posX-j) + "," + (posY+j);
                z++;
            }
            else if(pieza[posX-j][posY+j].length()>0){
                if(pieza[posX-j][posY+j].substring(1, 2).toUpperCase().equals(enemigo)){
                    pos[z] = (posX-j) + "," + (posY+j);
                z++;
                    break;
                }
                else{
                    break;
                }
            }       
        }
        for (k = 1; (posX-k >-1)&&(posY-k>-1); k++) {
            if(pieza[posX-k][posY-k].equals("")){
                pos[z] = (posX-k) + "," + (posY-k);
                z++;
            }
            else if((pieza[posX-k][posY-k].length()>0)&&
                    pieza[posX-k][posY-k].substring(1, 2).toUpperCase().equals(enemigo)){
                pos[z] = (posX-k) + "," + (posY-k);
                z++;
                break;
            }
            else{
                break;
            }
        }
        for (l = 1; (posX+l<8)&&(posY-l>-1); l++) {
            if(pieza[posX+l][posY-l].equals("")){
                pos[z] = (posX+l) + "," + (posY-l);
                z++;
            }
            else if((pieza[posX+l][posY-l].length()>0)&&
                    pieza[posX+l][posY-l].substring(1, 2).toUpperCase().equals(enemigo)){
                pos[z] = (posX+l) + "," + (posY-l);
                z++;
                break;
            }
            else{
                break;
            }
        }
        for (int  m = 0; m < pos.length; m++) {
            if (pos[m] != null) {
            }
            else{
                pos[m] = "";
            }
        }
        return pos;
    }
    private String[] pintarL(String[][]pieza, int posX, int posY,String enemigo){
        String[] pos = new String[81];
        int z = 0;
        if (posX-2 >= 0 && posY+1 >= 0 && posX-2 < 8 && posY+1 < 8) {
            if (pieza[posX-2][posY+1].equals("")) {
                pos[z] = (posX-2) + "," + (posY+1);
                z++;
            }
            else if (pieza[posX-2][posY+1].substring(1,2).toUpperCase().equals(enemigo)) {
                pos[z] = (posX-2) + "," + (posY+1);
                z++;
            }
            else{
            }
        }
        if (posX-2 >= 0 && posY-1 >= 0 && posX-2 < 8 && posY-1 < 8) {
            if (pieza[posX-2][posY-1].equals("")) {
                pos[z] = (posX-2) + "," + (posY-1);
                z++;
            }
            else if (pieza[posX-2][posY-1].substring(1,2).toUpperCase().equals(enemigo)) {
                pos[z] = (posX-2) + "," + (posY-1);
                z++;
            }
            else{
            }
        }
        if (posX-1 >= 0 && posY+2 >= 0 && posX-1 < 8 && posY+2 < 8) {
            if (pieza[posX-1][posY+2].equals("")) {
                pos[z] = (posX-1) + "," + (posY+2);
                z++;
            }
            else if (pieza[posX-1][posY+2].substring(1,2).toUpperCase().equals(enemigo)) {
                pos[z] = (posX-1) + "," + (posY+2);
                z++;
            }
            else{
            }
        }
        if (posX-1 >= 0 && posY-2 >= 0 && posX-1 < 8 && posY-2 < 8) {
            if (pieza[posX-1][posY-2].equals("")) {
                pos[z] = (posX-1) + "," + (posY-2);
                z++;
            }
            else if (pieza[posX-1][posY-2].substring(1,2).toUpperCase().equals(enemigo)) {
                pos[z] = (posX-1) + "," + (posY-2);
                z++;
            }
            else{
            }
        }
        
        if (posX+2 >= 0 && posY+1 >= 0 && posX+2 < 8 && posY+1 < 8) {
            if (pieza[posX+2][posY+1].equals("")) {
                pos[z] = (posX+2) + "," + (posY+1);
                z++;                
            }
            else if (pieza[posX+2][posY+1].substring(1,2).toUpperCase().equals(enemigo)) {
                pos[z] = (posX+2) + "," + (posY+1);
                z++;
            }
            else{
            }
        }
        if (posX+2 >= 0 && posY-1 >= 0 && posX+2 < 8 && posY-1 < 8) {
            if (pieza[posX+2][posY-1].equals("")) {
                pos[z] = (posX+2) + "," + (posY-1);
                z++;
            }
            else if (pieza[posX+2][posY-1].substring(1,2).toUpperCase().equals(enemigo)) {
                pos[z] = (posX+2) + "," + (posY-1);
                z++;
            }
            else{
            }
        }
        if (posX+1 >= 0 && posY+2 >= 0 && posX+1 < 8 && posY+2 < 8) {
            if (pieza[posX+1][posY+2].equals("")) {
                pos[z] = (posX+1) + "," + (posY+2);
                z++;
            }
            else if (pieza[posX+1][posY+2].substring(1,2).toUpperCase().equals(enemigo)) {
                pos[z] = (posX+1) + "," + (posY+2);
                z++;
            }
            else{
            }
        }
        if (posX+1 >= 0 && posY-2 >= 0 && posX+1 < 8 && posY-2 < 8) {
            if (pieza[posX+1][posY-2].equals("")) {
                pos[z] = (posX+1) + "," + (posY-2);
                z++;
            }
            else if (pieza[posX+1][posY-2].substring(1,2).toUpperCase().equals(enemigo)) {
                pos[z] = (posX+1) + "," + (posY-2);
                z++;
            }
            else{
            }
        }
        for (int  m = 0; m < pos.length; m++) {
            if (pos[m] != null) {
            }
            else{
                pos[m] = "";
            }
        }
        return pos;
    }
    
    private String[] pintarR(String[][]pieza, int posX, int posY,String amigo){
        String[] pos = new String[81];
        int z = 0;
        if (posX-1 >= 0 && posY-1 >= 0 && posX-1 < 8 && posY-1 < 8) {
            if (pieza[posX-1][posY-1].equals("")) {
                pos[z] = (posX-1) + "," + (posY-1);
                z++;
            }
            else if (!pieza[posX-1][posY-1].substring(1,2).toUpperCase().equals(amigo)) {
                pos[z] = (posX-1) + "," + (posY-1);
                z++;
            }
            else{
            }
        }
        if (posX-1 >= 0 && posY >= 0 && posX-1 < 8 && posY < 8) {
            if (pieza[posX-1][posY].equals("")) {
                pos[z] = (posX-1) + "," + (posY);
                z++;
            }
            else if (!pieza[posX-1][posY].substring(1,2).toUpperCase().equals(amigo)) {
                pos[z] = (posX-1) + "," + (posY);
                z++;
            }
            else{
            }
        }
        if (posX-1 >= 0 && posY+1 >= 0 && posX-1 < 8 && posY+1 < 8) {
            if (pieza[posX-1][posY+1].equals("")) {
                pos[z] = (posX-1) + "," + (posY+1);
                z++;
            }
            else if (!pieza[posX-1][posY+1].substring(1,2).toUpperCase().equals(amigo)) {
                pos[z] = (posX-1) + "," + (posY+1);
                z++;
            }
            else{
            }
        }
        if (posX >= 0 && posY-1 >= 0 && posX < 8 && posY-1 < 8) {
            if (pieza[posX][posY-1].equals("")) {
                pos[z] = (posX) + "," + (posY-1);
                z++;
            }
            else if (!pieza[posX][posY-1].substring(1,2).toUpperCase().equals(amigo)) {
                pos[z] = (posX) + "," + (posY-1);
                z++;
            }
            else{
            }
        }
        if (posX >= 0 && posY+1 >= 0 && posX < 8 && posY+1 < 8) {
            if (pieza[posX][posY+1].equals("")) {
                pos[z] = (posX) + "," + (posY+1);
                z++;
            }
            else if (!pieza[posX][posY+1].substring(1,2).toUpperCase().equals(amigo)) {
                pos[z] = (posX) + "," + (posY+1);
                z++;
            }
            else{
            }
        }
        if (posX+1 >= 0 && posY-1 >= 0 && posX+1 < 8 && posY-1 < 8) {
            if (pieza[posX+1][posY-1].equals("")) {
                pos[z] = (posX+1) + "," + (posY-1);
                z++;
            }
            else if (!pieza[posX+1][posY-1].substring(1,2).toUpperCase().equals(amigo)) {
                pos[z] = (posX+1) + "," + (posY-1);
                z++;
            }
            else{
            }
        }
        if (posX+1 >= 0 && posY >= 0 && posX+1 < 8 && posY < 8) {
            if (pieza[posX+1][posY].equals("")) {
                pos[z] = (posX+1) + "," + (posY);
                z++;
            }
            else if (!pieza[posX+1][posY].substring(1,2).toUpperCase().equals(amigo)) {
                pos[z] = (posX+1) + "," + (posY);
                z++;
            }
            else{
            }
        }
        if (posX+1 >= 0 && posY+1 >= 0 && posX+1 < 8 && posY+1 < 8) {
            if (pieza[posX+1][posY+1].equals("")) {
                pos[z] = (posX+1) + "," + (posY+1);
                z++;
            }
            else if (!pieza[posX+1][posY+1].substring(1,2).toUpperCase().equals(amigo)) {
                pos[z] = (posX+1) + "," + (posY+1);
                z++;
            }
            else{
            }
        }
        if (amigo.equals("B")) {
            if (posX == 7 && posY == 4 && pieza[7][5].equals("") && pieza[7][6].equals("") && pieza[7][7].equals("TB")) {
                pos[z] = (7) + "," + (6);
                z++;
            }
            if (posX == 7 && posY == 4 && pieza[7][3].equals("") && pieza[7][2].equals("") && pieza[7][1].equals("") && pieza[7][0].equals("TB")) {
                pos[z] = (7) + "," + (2);
                z++;
            }
        }
        if (amigo.equals("N" )) {
            if (posX == 0 && posY == 4 && pieza[0][5].equals("") && pieza[0][6].equals("") && pieza[0][7].equals("TN")) {
                pos[z] = (0) + "," + (6);
                z++;
            }
            if (posX == 0 && posY == 4 && pieza[0][3].equals("") && pieza[0][2].equals("") && pieza[0][1].equals("") && pieza[0][0].equals("TN")) {
                pos[z] = (0) + "," + (2);
                z++;
            }
        }
        for (int  m = 0; m < pos.length; m++) {
            if (pos[m] != null) {
            }
            else{
                pos[m] = "";
            }
        }
        return pos;
    }
    public String[] Peon(String [][]pieza,int posX, int posY){
        String[] ame;
        
        int j;
        String enemigo;
        
        if(pieza[posX][posY].substring(1, 2).toUpperCase().equals("B")){
            j = -1;
            enemigo = "N";
            ame = revisarfrente(pieza, posX, posY,j,enemigo,"B");
        }
        else{
            j = 1;
            enemigo = "B";
            ame = revisarfrente(pieza, posX, posY,j,enemigo,"N");
        }
        return ame;
    }
    
    public String[] Torre(String[][]pieza, int posX, int posY){
        int cambiarX;
        int cambiarY;
        String[] ame;
        if(pieza[posX][posY].substring(1, 2).toUpperCase().equals("N")){
            cambiarX = 0;
            cambiarY = 0;
            ame = pintarlineas(pieza,cambiarX,posX,cambiarY,posY,"N","B");
        }
        else{
            cambiarX = 7;
            cambiarY = 7;
            ame = pintarlineas(pieza,cambiarX,posX,cambiarY,posY,"B","N");
        }
        return ame;
    }
    
    public String[] Alfil(String [][]pieza, int posX, int posY){
        String[] ame;
        if(pieza[posX][posY].substring(1, 2).toUpperCase().equals("N")){
            ame = pintardiagonales(pieza,posX,posY,"B");
        }
        else{
            ame = pintardiagonales(pieza,posX,posY,"N");
        }
        return ame;
    }
    
    public String[] Caballo(String [][]pieza, int posX, int posY){
        String[] ame;
        if(pieza[posX][posY].substring(1, 2).toUpperCase().equals("N")){
            ame = pintarL(pieza,posX,posY,"B");
        }
        else{
            ame = pintarL(pieza,posX,posY,"N");
        }
        return ame;
    }
    
    public String[] Dama(String [][]pieza, int posX, int posY){
        int cambiarX;
        int cambiarY;
        String[] ame;
        String[] ama;
        if(pieza[posX][posY].substring(1, 2).toUpperCase().equals("N")){
            cambiarX = 0;
            cambiarY = 0;
            ame = pintarlineas(pieza,cambiarX,posX,cambiarY,posY,"N","B");
            ama = pintardiagonales(pieza,posX,posY,"B");
        }
        else{
            cambiarX = 7;
            cambiarY = 7;
            ame = pintarlineas(pieza,cambiarX,posX,cambiarY,posY,"B","N");
            ama = pintardiagonales(pieza,posX,posY,"N");
        }
        
        String[] resa = new String[ame.length+ama.length];
        for (int i = 0; i < ame.length; i++) {
            resa[i] = ame[i];
        }
        for (int i = 0; i < ama.length; i++) {
            resa[ame.length+i] = ama[i];
        }
        for (int i = 0; i < resa.length; i++) {
            if (resa[i] != null) {
            }
            else{
            }
        }
        return resa;
    }
    public String[] Rey(String[][] pieza, int posX, int posY, String amigo){
        String ame[];
        if (amigo.equals("B")) {
            ame = pintarR(pieza, posX, posY, amigo);
        }    
        else{
            ame = pintarR(pieza, posX, posY, amigo);
        }
        return ame;
    }
}
